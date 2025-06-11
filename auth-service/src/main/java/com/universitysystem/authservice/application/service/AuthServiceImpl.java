package com.universitysystem.authservice.application.service;

import com.universitysystem.authservice.application.dto.JwtResponse;
import com.universitysystem.authservice.application.dto.LoginRequest;
import com.universitysystem.authservice.application.dto.RegisterRequest;
import com.universitysystem.authservice.application.dto.UserInfoResponse;
import com.universitysystem.authservice.application.mapper.UserMapper;
import com.universitysystem.authservice.application.port.in.AuthUseCase;
import com.universitysystem.authservice.application.port.out.UserPort;
import com.universitysystem.authservice.domain.model.User;
import com.universitysystem.authservice.domain.model.enums.Role;
import com.universitysystem.authservice.infrastructure.exception.UserAlreadyExistsException;
import com.universitysystem.authservice.infrastructure.exception.UserNotFoundException;
import com.universitysystem.authservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthUseCase {

    private final UserPort userPort;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Override
    public JwtResponse register(RegisterRequest request) {
        if (userPort.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("El nombre de usuario ya está en uso.");
        }
        if (userPort.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("El correo electrónico ya está registrado.");
        }

        User user = userMapper.fromRegisterRequest(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.valueOf(request.getRole().toUpperCase()));

        User savedUser = userPort.save(user);
        String token = jwtService.generateToken(savedUser);
        return new JwtResponse(token);
    }
    @Override
    public UserInfoResponse getCurrentUserInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userPort.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        return new UserInfoResponse(user.getUsername(), user.getEmail(), user.getRole());
    }


    @Override
    public JwtResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userPort.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        String token = jwtService.generateToken(user);
        return new JwtResponse(token);
    }
}
