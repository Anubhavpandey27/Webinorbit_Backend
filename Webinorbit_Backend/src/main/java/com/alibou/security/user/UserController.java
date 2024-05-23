package com.alibou.security.user;

import com.alibou.security.auth.AuthenticationResponse;
import com.alibou.security.auth.RegisterRequest;
import com.alibou.security.config.JwtService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://webinorbitfinalrun2.netlify.app/")
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final JwtService jwtService;
    private final UserService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/prof/{email}")
    public ResponseEntity<ProfileResponse> findByEmail(@PathVariable String email) {
        Optional<User> user=service.getUserByEmail(email);
        User user1=user.get();
        var response= ProfileResponse.builder()
                .firstname(user1.getFirstname())
                .lastname(user1.getLastname())
                .skills(user1.getSkills())
                .projects(user1.getProjects())
                .position(user1.getPosition())
                .image(user1.getImage())
                .college(user1.getCollege())
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/test")
    public ResponseEntity<ProfileResponse> use(
            @RequestBody Test request
    ) {
        String a=request.getUsername();

        String s1=jwtService.extractUsername(a);
        System.out.println(s1);
        Optional<User> user=service.getUserByEmail(s1);
        User user1=user.get();
        var response= ProfileResponse.builder()
                .email(user1.getEmail())
                .firstname(user1.getFirstname())
                .lastname(user1.getLastname())
                .skills(user1.getSkills())
                .projects(user1.getProjects())
                .position(user1.getPosition())
                .image(user1.getImage())
                .college(user1.getCollege())
                .build();
        System.out.println(response);
        return ResponseEntity.ok(response);
    }


}
