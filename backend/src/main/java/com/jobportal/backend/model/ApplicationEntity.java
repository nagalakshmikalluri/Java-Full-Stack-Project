package com.jobportal.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
public class ApplicationEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;
    @ManyToOne @JoinColumn(name = "job_id")
    private Job job;
    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
    private String status = "Applied";
    private LocalDateTime appliedOn = LocalDateTime.now();

    public Long getAppId() { return appId; }
    public void setAppId(Long appId) { this.appId = appId; }
    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getAppliedOn() { return appliedOn; }
    public void setAppliedOn(LocalDateTime appliedOn) { this.appliedOn = appliedOn; }
}

