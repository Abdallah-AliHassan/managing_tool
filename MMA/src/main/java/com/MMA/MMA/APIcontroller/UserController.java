package com.MMA.MMA.APIcontroller;

import com.MMA.MMA.Repository.ApplicationRepo;
import com.MMA.MMA.auth.AddApplicationRequest;
import com.MMA.MMA.auth.AuthenticationService;
import com.MMA.MMA.Entites.Application;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Secured API call, accessed only with Admin Authentications
@RestController
@RequestMapping("/api/other")
@AllArgsConstructor
public class UserController {

    private final AuthenticationService service;
    private final ApplicationRepo appRepo;
//    private final ApplicationServices AppServices;
    @GetMapping("/check")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hola Admin from secured endpoint");
    }
    @PostMapping("/newApplication")
    public ResponseEntity<Application> addEntry(@RequestBody AddApplicationRequest Application) {
        Application newEntry = service.addEntry(Application);
        System.out.print("Hello new entry");
        return new ResponseEntity<>(newEntry, HttpStatus.CREATED);
    }
    @GetMapping("/allApplications")
    public ResponseEntity<List<Application>> getApplicationsByEmail () {
        List<Application> Apps = service.findAllApps();
        return new ResponseEntity<>(Apps, HttpStatus.OK);
    }

    @PutMapping("/updateApplication")
    public ResponseEntity<Application> UpdateApplication (@RequestBody Application application) {
        return new ResponseEntity<>(appRepo.save(application), HttpStatus.OK);
    }


}