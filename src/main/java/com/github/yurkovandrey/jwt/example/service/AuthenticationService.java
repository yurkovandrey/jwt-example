package com.github.yurkovandrey.jwt.example.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.yurkovandrey.jwt.example.dto.JwtAuthenticationResponse;
import com.github.yurkovandrey.jwt.example.dto.SigninRequest;
import com.github.yurkovandrey.jwt.example.dto.SignupRequest;
import com.github.yurkovandrey.jwt.example.model.UserModel;
import com.github.yurkovandrey.jwt.example.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public JwtAuthenticationResponse signup(SignupRequest request) {
    var user = new UserModel();
    user.setName(request.getFirstName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    userRepository.save(user);
    var jwt = jwtService.generateToken(user);
    return JwtAuthenticationResponse.builder().token(jwt).build();
  }

  public JwtAuthenticationResponse signin(SigninRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    var user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
    var jwt = jwtService.generateToken(user);
    return JwtAuthenticationResponse.builder().token(jwt).build();
  }
}
