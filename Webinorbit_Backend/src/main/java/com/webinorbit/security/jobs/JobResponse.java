package com.webinorbit.security.jobs;

import lombok.Data;

@Data
public class JobResponse {
    private Long id;
    private String companyName;
    private String companyLogo;
    private String jobType;
    private String role;
    private String location;
    private String duration;
    private String batch;
    private String salary;
    private String description;
    private String applyLink;
}