package com.github.yurkovandrey.jwt.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.yurkovandrey.jwt.example.dto.JwtAuthenticationResponse;
import com.github.yurkovandrey.jwt.example.dto.SigninRequest;
import com.github.yurkovandrey.jwt.example.dto.SignupRequest;
import com.github.yurkovandrey.jwt.example.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthenticationService authenticationService;

  @PostMapping("/signup")
  public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignupRequest request) {
    var token = authenticationService.signup(request);
    return ResponseEntity.ok(token);
  }

  @PostMapping("/signin")
  public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
    var token = authenticationService.signin(request);
    return ResponseEntity.ok(token);
  }
}
