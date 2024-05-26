package com.example.BookApp.user.service;

import com.example.BookApp.user.model.User;

public interface UserService {
    User registerUser(UserRegistrationDto registrationDto);
    User loginUser(LoginRequestDto loginRequestDto);
    User getUserById(Long userId);
}

