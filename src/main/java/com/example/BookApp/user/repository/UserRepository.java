package com.example.BookApp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BookApp.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
