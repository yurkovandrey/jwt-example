package com.github.yurkovandrey.jwt.example.dto;

import lombok.Data;

@Data
public class SigninRequest {
  private String email;
  private String password;
}
