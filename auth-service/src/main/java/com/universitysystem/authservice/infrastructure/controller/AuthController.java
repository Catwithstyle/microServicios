package com.universitysystem.authservice.infrastructure.controller;

import com.universitysystem.authservice.application.dto.JwtResponse;
import com.universitysystem.authservice.application.dto.LoginRequest;
import com.universitysystem.authservice.application.dto.RegisterRequest;
import com.universitysystem.authservice.application.dto.UserInfoResponse;
import com.universitysystem.authservice.application.port.in.AuthUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody @Valid RegisterRequest request) {
        JwtResponse jwt = authUseCase.register(request);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid LoginRequest request) {
        JwtResponse jwt = authUseCase.login(request);
        return ResponseEntity.ok(jwt);
    }

    @GetMapping("/me")
    public ResponseEntity<UserInfoResponse> getCurrentUser() {
        return ResponseEntity.ok(authUseCase.getCurrentUserInfo());
    }

}
