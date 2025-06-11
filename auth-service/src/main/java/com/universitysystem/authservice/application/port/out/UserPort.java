package com.universitysystem.authservice.application.port.out;

import com.universitysystem.authservice.domain.model.User;

import java.util.Optional;

public interface UserPort {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User save(User user);
}
