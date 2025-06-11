package com.universitysystem.userservice.application.port.out;

import com.universitysystem.userservice.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserPort {
    User save(User user);
    Optional<User> findById(Integer id);
    List<User> findAll();
    void deleteById(Integer id);


    boolean existsByAuthUserId(Integer authUserId);
}
