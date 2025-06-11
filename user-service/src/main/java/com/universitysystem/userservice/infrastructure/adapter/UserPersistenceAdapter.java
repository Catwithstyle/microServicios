package com.universitysystem.userservice.infrastructure.adapter;

import com.universitysystem.userservice.application.port.out.UserPort;
import com.universitysystem.userservice.domain.model.User;
import com.universitysystem.userservice.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsByAuthUserId(Integer authUserId) {
        return userRepository.existsByAuthUserId(authUserId);
    }

}
