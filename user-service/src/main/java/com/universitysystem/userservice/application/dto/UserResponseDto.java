package com.universitysystem.userservice.application.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Integer id;
    private Integer authUserId;
    private String firstName;
    private String lastName;
    private String phone;
}
