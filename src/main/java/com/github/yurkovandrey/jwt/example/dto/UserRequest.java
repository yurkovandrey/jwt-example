package com.github.yurkovandrey.jwt.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {
  @NotNull
  private String email;
  @NotNull
  private String name;
  @NotNull
  private String password;
}
