package com.example.BookApp.user.config;

import com.example.BookApp.user.service.PasswordEncoder;

public class BCryptPasswordEncoder implements PasswordEncoder {
    
    @Override
    public String encode(Object password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encode'");
    }

    @Override
    public boolean matches(Object password, String password2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'matches'");
    }

}
