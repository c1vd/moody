package com.company.moody.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.company.moody.dto.UserDto;
import com.company.moody.entities.User;
import com.company.moody.exceptions.PasswordTooWeakException;
import com.company.moody.exceptions.UserAlreadyExistsException;
import com.company.moody.services.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class MoodController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDto userDto) {
        try{
            var registeredUser = userService.register(userDto);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        }catch (UserAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }catch(PasswordTooWeakException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password too weak");
        }
    }
}
