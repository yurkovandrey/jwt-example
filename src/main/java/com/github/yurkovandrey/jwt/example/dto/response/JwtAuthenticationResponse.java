package com.github.yurkovandrey.jwt.example.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtAuthenticationResponse {
  private String token;
}
