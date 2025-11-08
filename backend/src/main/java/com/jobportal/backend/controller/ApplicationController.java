package com.jobportal.backend.controller;

import com.jobportal.backend.model.*;
import com.jobportal.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepo;

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/jobs/{id}/apply")
    public ResponseEntity<?> applyToJob(@PathVariable Long id, Authentication auth) {
        if (auth == null) return ResponseEntity.status(401).body("Unauthorized");
        String email = auth.getName();
        User seeker = userRepo.findByEmail(email).orElse(null);
        if (seeker == null) return ResponseEntity.status(404).body("User not found");
        Job job = jobRepo.findById(id).orElse(null);
        if (job == null) return ResponseEntity.status(404).body("Job not found");

        ApplicationEntity app = new ApplicationEntity();
        app.setJob(job);
        app.setUser(seeker);
        app.setStatus("Applied");
        applicationRepo.save(app);
        return ResponseEntity.ok("Applied successfully");
    }

    @GetMapping("/applications")
    public ResponseEntity<?> getMyApplications(Authentication auth) {
        if (auth == null) return ResponseEntity.status(401).body("Unauthorized");
        String email = auth.getName();
        User user = userRepo.findByEmail(email).orElse(null);
        if (user == null) return ResponseEntity.status(404).body("User not found");
        List<ApplicationEntity> apps = applicationRepo.findByUserUserId(user.getUserId());
        return ResponseEntity.ok(apps);
    }

    @GetMapping("/jobs/{id}/applicants")
    public ResponseEntity<?> getApplicantsForJob(@PathVariable Long id, Authentication auth) {
        // Only employer who posted should view; simplified: any authenticated user
        List<ApplicationEntity> apps = applicationRepo.findByJobJobId(id);
        return ResponseEntity.ok(apps);
    }
}

