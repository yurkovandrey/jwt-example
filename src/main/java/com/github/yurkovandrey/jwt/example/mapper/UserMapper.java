package com.github.yurkovandrey.jwt.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.yurkovandrey.jwt.example.dto.User;
import com.github.yurkovandrey.jwt.example.dto.UserRequest;
import com.github.yurkovandrey.jwt.example.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "password", ignore = true)
  UserModel requestToModel(UserRequest dto);

  User modelToDto(UserModel model);
}
