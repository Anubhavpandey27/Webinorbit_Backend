package com.alibou.security.auth;

import com.alibou.security.config.JwtService;
import com.alibou.security.user.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin("https://webinorbitfinalrun2.netlify.app/")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;
  private final UserService servicee;
  private final JwtService jwtService;


  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  @PostMapping("/test")
  public ResponseEntity<ProfileResponse> use(
          @RequestBody Test request
  ) {
    String a=request.getUsername();

    String s1=jwtService.extractUsername(a);
    System.out.println(s1);
    Optional<User> user=servicee.getUserByEmail(s1);
    User user1=user.get();
    var response= ProfileResponse.builder()
            .email(user1.getEmail())
            .firstname(user1.getFirstname())
            .lastname(user1.getLastname())
            .skils(user1.getSkills())
            .projects(user1.getProjects())
            .position(user1.getPosition())
            .image(user1.getImage())
            .college(user1.getCollege())
            .build();
    System.out.println(response);
    return ResponseEntity.ok(response);
  }


  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}
