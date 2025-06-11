package com.universitysystem.authservice.application.port.in;

import com.universitysystem.authservice.application.dto.JwtResponse;
import com.universitysystem.authservice.application.dto.LoginRequest;
import com.universitysystem.authservice.application.dto.RegisterRequest;
import com.universitysystem.authservice.application.dto.UserInfoResponse;

public interface AuthUseCase {
    JwtResponse login(LoginRequest request);
    JwtResponse register(RegisterRequest request);
    UserInfoResponse getCurrentUserInfo();

}
