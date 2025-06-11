package com.universitysystem.userservice.application.port.in;

import com.universitysystem.userservice.application.dto.UserRequestDto;
import com.universitysystem.userservice.application.dto.UserResponseDto;

import java.util.List;

public interface UserUseCase {

    UserResponseDto createUser(UserRequestDto userDto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(Integer id);

    UserResponseDto updateUser(Integer id, UserRequestDto userDto);

    void deleteUser(Integer id);
}
