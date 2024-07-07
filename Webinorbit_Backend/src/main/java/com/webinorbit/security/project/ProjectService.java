package com.webinorbit.security.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ProjectService {
    private  final ProjectRepository repository;
    public RegisterResponse register(RegisterRequest request){
        var project = Project.builder()
                .name(request.getName())
                .price(request.getPrice())
                .client(request.getClient())
                .teamsize(request.getTeamsize())
                .team(request.getTeam())
                .deadline(request.getDeadline())
                .rating(request.getRating())
                .docfile(request.getDocfile())
                .description(request.getDescription())
                .build();
        var savedproject=repository.save(project);
        var respons=RegisterResponse.builder()
                .status("successful")
                .build();
        return respons;

    }



}
