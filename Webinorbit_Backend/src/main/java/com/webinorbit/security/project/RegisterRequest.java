package com.webinorbit.security.project;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class RegisterRequest {
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
