package com.webinorbit.security.jobs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.IdGeneratorType;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Job {

    @Id
    @GeneratedValue
    private int id;
    private String companyname;
    private String companylogo;
    private String jobtype;
    private String role;
    private String location;
    private String duration;
    private String batch;
    private String salary;
    private String description;
    private String applylink;



}
