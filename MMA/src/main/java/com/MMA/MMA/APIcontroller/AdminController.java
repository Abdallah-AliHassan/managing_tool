package com.MMA.MMA.APIcontroller;


import com.MMA.MMA.Entites.*;
import com.MMA.MMA.auth.AuthenticationResponse;
import com.MMA.MMA.auth.AuthenticationService;
import com.MMA.MMA.auth.RegisterRequest;
import com.MMA.MMA.Services.EmployeeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final EmployeeServices employeeService;

    private final AuthenticationService service;
    @PostMapping("/addUser")
    public ResponseEntity<AuthenticationResponse> addUser(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.addUser(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

}
