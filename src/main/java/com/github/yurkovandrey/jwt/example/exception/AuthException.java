package com.github.yurkovandrey.jwt.example.exception;

public class AuthException extends RuntimeException {
  public AuthException(String message) {
    super(message);
  }
}
