package com.example.applemanagement.repository.login;

import com.example.applemanagement.model.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail (String email);
    Optional<User> findByUsernameOrEmail (String username, String email);
    Optional<User> findByUsername (String username);
    Boolean existsByUsername (String username);
    Boolean existsByEmail (String email);
}
