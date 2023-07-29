package com.github.yurkovandrey.jwt.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.yurkovandrey.jwt.example.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
  Optional<UserModel> findByEmail(String email);
}
