package com.universitysystem.userservice.application.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    private Integer authUserId;
    private String firstName;
    private String lastName;
    private String phone;
}
