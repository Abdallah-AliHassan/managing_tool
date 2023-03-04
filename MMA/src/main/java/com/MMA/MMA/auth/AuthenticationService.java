package com.MMA.MMA.auth;

import com.MMA.MMA.Repository.ApplicationRepo;
import com.MMA.MMA.Repository.EmployeeRepo;
import com.MMA.MMA.Services.JwtService;
import com.MMA.MMA.Entites.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final EmployeeRepo repository;

    private final ApplicationRepo repo;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private String loggedEmail;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Employee.builder()
                .name(request.getName())
                .email(request.getEmail())
                .level(request.getLevel())
                .password(passwordEncoder.encode(request.getPassword()))
                .onbenchsince(request.getOnbenchsince())
                .role(Role.ADMIN)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var test = jwtService.extractUsername(jwtToken);
        return AuthenticationResponse.builder()
                .token("Hello, thank you for Registering as an Admin: "+ test)
                .build();
    }
    public AuthenticationResponse addUser(RegisterRequest request) {
        var user = Employee.builder()
                .name(request.getName())
                .email(request.getEmail())
                .level(request.getLevel())
                .password(passwordEncoder.encode(request.getPassword()))
                .onbenchsince(request.getOnbenchsince())
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var test = jwtService.extractUsername(jwtToken);
        return AuthenticationResponse.builder()
                .token("Hello, thank you for Registering the new user with the username: "+ test)
                .build();
    }

    public Application addEntry(AddApplicationRequest request) {
        var user = Application.builder()
                .email(loggedEmail)
                .client(request.getClient())
                .project(request.getProject())
                .roleid(request.getRoleid())
                .statues(request.getStatues())
                .title(request.getTitle())
                .build();
        return repo.save(user);
    }

    public List<Application> findAllApps() {
        List<Application> application = repo.findApplicationsByEmail(loggedEmail);
        return application;
    }



    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("Hola From here " + request.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        System.out.println("Hola From here 22 " + request.getEmail());
        var user = repository.findEmployeeByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var test = jwtService.extractUsername(jwtToken);
        loggedEmail = test;
        return AuthenticationResponse.builder()
                .token("Hello, thank you for logging in with the username: "+ test + " Token: " + jwtToken )
                .build();
    }
}
