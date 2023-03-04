package com.MMA.MMA.Services;

import com.MMA.MMA.Entites.Employee;
import com.MMA.MMA.Repository.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServices {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServices(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeByEmail(String email) {
        return employeeRepo.findEmployeeByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

}
