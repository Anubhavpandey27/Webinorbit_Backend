package com.webinorbit.security.project;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5501")
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor

public class ProjectController {
    private  final ProjectService projectService;
    @PostMapping("/add")
    public ResponseEntity<RegisterResponse> add(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(projectService.register(request));
    }




}
