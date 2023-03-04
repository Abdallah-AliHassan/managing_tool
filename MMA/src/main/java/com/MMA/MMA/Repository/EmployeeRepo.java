package com.MMA.MMA.Repository;

import com.MMA.MMA.Entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeByEmail(String email);
    Optional<Employee> findEmployeeById(Long id);

    void deleteEmployeeById(Long id);
}
