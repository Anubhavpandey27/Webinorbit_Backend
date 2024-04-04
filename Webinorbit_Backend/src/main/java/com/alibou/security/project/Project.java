package com.alibou.security.project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Entity


@Table(name="project")
public class Project {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String price;
    private String client;
    private String teamsize;
    private LocalDateTime deadline;
    private int rating;
    private String docfile;
    private String description;


}
