package com.github.yurkovandrey.jwt.example.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.yurkovandrey.jwt.example.dto.response.JwtAuthenticationResponse;
import com.github.yurkovandrey.jwt.example.dto.request.SigninRequest;
import com.github.yurkovandrey.jwt.example.dto.request.SignupRequest;
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
    var email = request.getEmail();
    var rawPassword = request.getPassword();

    if (userRepository.findByEmail(email).isPresent()) {
      throw new RuntimeException();
    }

    var user = new UserModel();
    user.setEmail(email);
    user.setPassword(passwordEncoder.encode(rawPassword));
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
