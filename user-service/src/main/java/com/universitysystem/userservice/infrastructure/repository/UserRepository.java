package com.universitysystem.userservice.infrastructure.repository;

import com.universitysystem.userservice.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Si necesitas buscar por el ID del auth-service:
    boolean existsByAuthUserId(Integer authUserId);
}
