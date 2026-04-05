package com.company.moody.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.company.moody.dto.UserDto;
import com.company.moody.entities.User;
import com.company.moody.services.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class MoodController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDto userDto) {
        var registeredUser = userService.register(userDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
    
    @GetMapping("/{user}/moods")
    public String userMoods(@PathVariable String user) {
        return "Hello, " + user;
    }
    
}
