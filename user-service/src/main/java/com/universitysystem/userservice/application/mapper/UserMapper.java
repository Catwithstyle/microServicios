package com.universitysystem.userservice.application.mapper;

import com.universitysystem.userservice.application.dto.UserRequestDto;
import com.universitysystem.userservice.application.dto.UserResponseDto;
import com.universitysystem.userservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authUserId", source = "authUserId")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phone", source = "phone")
    User toModel(UserRequestDto dto);

    UserResponseDto toResponseDto(User user);
}
