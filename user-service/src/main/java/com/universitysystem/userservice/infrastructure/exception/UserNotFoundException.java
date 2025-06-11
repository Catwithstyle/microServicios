package com.universitysystem.userservice.infrastructure.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("Usuario no encontrado con ID: " + id);
    }
}
