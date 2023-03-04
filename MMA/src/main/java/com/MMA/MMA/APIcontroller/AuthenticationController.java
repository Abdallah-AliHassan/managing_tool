package com.MMA.MMA.APIcontroller;

import com.MMA.MMA.Entites.*;
import com.MMA.MMA.Repository.EmployeeRepo;
import com.MMA.MMA.auth.AuthenticationRequest;
import com.MMA.MMA.auth.AuthenticationResponse;
import com.MMA.MMA.auth.AuthenticationService;
import com.MMA.MMA.auth.RegisterRequest;
import com.MMA.MMA.Services.EmployeeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
@RequiredArgsConstructor
public class AuthenticationController {

    private final EmployeeRepo repository;
    private final EmployeeServices employeeService;

    private final AuthenticationService service;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from MMA APP");
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/Login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping("/find/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail (@PathVariable("email") String email) {

        Employee employee = employeeService.findEmployeeByEmail(email);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {

        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }





}

