package com.example.BookApp.user.service;

public interface PasswordEncoder {

    String encode(Object password);

    boolean matches(Object password, String password2);

}
