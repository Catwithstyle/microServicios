package com.universitysystem.authservice.application.dto;

import com.universitysystem.authservice.domain.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private String username;
    private String email;
    private Role role;
}
