package com.jobportal.backend.dto;

public class JobRequest {
    private String title;
    private String company;
    private String location;
    private String packageInfo;
    private String skills;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getPackageInfo() { return packageInfo; }
    public void setPackageInfo(String packageInfo) { this.packageInfo = packageInfo; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
}

