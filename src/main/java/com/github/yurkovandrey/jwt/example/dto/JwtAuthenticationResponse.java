package com.github.yurkovandrey.jwt.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtAuthenticationResponse {
  private String token;
}
