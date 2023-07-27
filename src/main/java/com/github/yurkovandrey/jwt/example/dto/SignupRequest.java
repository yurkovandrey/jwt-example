package com.github.yurkovandrey.jwt.example.dto;

import lombok.Data;

@Data
public class SignupRequest {
  private String firstName;
  private String email;
  private String password;
}