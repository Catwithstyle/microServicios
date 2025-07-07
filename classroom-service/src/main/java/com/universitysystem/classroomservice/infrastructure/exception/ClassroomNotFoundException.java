package com.universitysystem.classroomservice.infrastructure.exception;

public class ClassroomNotFoundException extends RuntimeException {
    public ClassroomNotFoundException(String message) {
        super(message);
    }
}
