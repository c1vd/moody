package com.company.moody.services;

import org.springframework.stereotype.Service;

@Service
public class PasswordCheckerService {
    public boolean isValid(String password){
        return password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!]{6,}");
    }
}
