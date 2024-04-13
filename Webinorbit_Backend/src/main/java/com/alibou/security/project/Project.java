package com.alibou.security.project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter


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
    private String team;
    private int rating;
    private String docfile;
    private String description;




}
