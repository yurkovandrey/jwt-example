package com.github.yurkovandrey.jwt.example.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupRequest {
  @NotNull
  @Email
  private String email;
  @NotNull
  private String password;
}