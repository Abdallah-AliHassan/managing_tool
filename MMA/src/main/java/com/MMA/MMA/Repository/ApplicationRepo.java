package com.MMA.MMA.Repository;

import java.util.List;
import java.util.Optional;

import com.MMA.MMA.Entites.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, Integer> {

    List<Application> findApplicationsByEmail(String email);
}
