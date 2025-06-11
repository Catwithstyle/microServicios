package com.universitysystem.authservice.application.mapper;

import com.universitysystem.authservice.application.dto.RegisterRequest;
import com.universitysystem.authservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {



    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true) // se codifica después
    @Mapping(target = "role", ignore = true)     // se asigna después
    User fromRegisterRequest(RegisterRequest request);
}
