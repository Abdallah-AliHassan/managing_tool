package com.MMA.MMA.Services;

import com.MMA.MMA.Repository.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationServices {

    private final ApplicationRepo applicationRepo;

    @Autowired
    public ApplicationServices(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }


}
