package com.github.yurkovandrey.jwt.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.yurkovandrey.jwt.example.dto.response.JwtAuthenticationResponse;
import com.github.yurkovandrey.jwt.example.dto.request.SigninRequest;
import com.github.yurkovandrey.jwt.example.dto.request.SignupRequest;
import com.github.yurkovandrey.jwt.example.exception.AuthException;
import com.github.yurkovandrey.jwt.example.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthenticationService authenticationService;

  @PostMapping("/signup")
  public ResponseEntity<JwtAuthenticationResponse> signup(@Validated @RequestBody SignupRequest request) {
    var token = authenticationService.signup(request);
    return ResponseEntity.ok(token);
  }

  @PostMapping("/signin")
  public ResponseEntity<JwtAuthenticationResponse> signin(@Validated @RequestBody SigninRequest request) {
    var token = authenticationService.signin(request);
    return ResponseEntity.ok(token);
  }

  @ExceptionHandler(AuthException.class)
  public ResponseEntity<Object> handle(AuthException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }
}
