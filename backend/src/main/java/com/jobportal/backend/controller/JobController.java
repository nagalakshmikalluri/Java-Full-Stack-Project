package com.jobportal.backend.controller;

import com.jobportal.backend.dto.JobRequest;
import com.jobportal.backend.model.*;
import com.jobportal.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public ResponseEntity<?> getAllJobs(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(required = false) String q) {
        Pageable p = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Job> jobs;
        if (q != null && !q.isBlank()) {
            jobs = jobRepo.findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCase(q, q, p);
        } else {
            jobs = jobRepo.findAll(p);
        }
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJob(@PathVariable Long id) {
        return jobRepo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody JobRequest req, Authentication auth) {
        if (auth == null) return ResponseEntity.status(401).body("Unauthorized");
        String email = auth.getName();
        User employer = userRepo.findByEmail(email).orElse(null);
        if (employer == null) return ResponseEntity.status(404).body("Employer not found");
        Job job = new Job();
        job.setTitle(req.getTitle());
        job.setCompany(req.getCompany());
        job.setLocation(req.getLocation());
        job.setPackageInfo(req.getPackageInfo());
        job.setSkills(req.getSkills());
        job.setPostedBy(employer);
        jobRepo.save(job);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/employer/{employerId}")
    public ResponseEntity<?> getJobsByEmployer(@PathVariable Long employerId) {
        List<Job> jobs = jobRepo.findAll();
        // naive filter — better to add repository method; for simplicity:
        List<Job> res = new ArrayList<>();
        for (Job j : jobs) if (j.getPostedBy() != null && Objects.equals(j.getPostedBy().getUserId(), employerId)) res.add(j);
        return ResponseEntity.ok(res);
    }
}

