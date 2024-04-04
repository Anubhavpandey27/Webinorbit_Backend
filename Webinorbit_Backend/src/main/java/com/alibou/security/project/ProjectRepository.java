package com.alibou.security.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Optional<Project>findByname(String name);

}
