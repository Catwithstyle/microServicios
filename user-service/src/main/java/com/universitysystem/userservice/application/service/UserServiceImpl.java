package com.universitysystem.userservice.application.service;

import com.universitysystem.userservice.application.dto.UserRequestDto;
import com.universitysystem.userservice.application.dto.UserResponseDto;
import com.universitysystem.userservice.application.mapper.UserMapper;
import com.universitysystem.userservice.application.port.in.UserUseCase;
import com.universitysystem.userservice.application.port.out.UserPort;
import com.universitysystem.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserUseCase {

    private final UserPort userPort;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userDto) {
        User user = userMapper.toModel(userDto);
        User savedUser = userPort.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userPort.findAll().stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Integer id) {
        User user = userPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        return userMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(Integer id, UserRequestDto userDto) {
        User existingUser = userPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setPhone(userDto.getPhone());

        User updatedUser = userPort.save(existingUser);
        return userMapper.toResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        if (!userPort.findById(id).isPresent()) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        userPort.deleteById(id);
    }
}
