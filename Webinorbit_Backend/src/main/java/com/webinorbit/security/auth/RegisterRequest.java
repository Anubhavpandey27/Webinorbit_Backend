package com.webinorbit.security.auth;

import com.webinorbit.security.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private Role role;
  private String college;
  private String skills;
  private String position;
  private float rating;
  private String image;
  private int projects;
}
