package com.company.moody.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.moody.dto.UserDto;
import com.company.moody.entities.User;
import com.company.moody.exceptions.UserAlreadyExistsException;
import com.company.moody.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findByUsername(String username){
        return userRepository.findUserByUsername(username);
    }


    /**
     * Регистрирует пользователя по заданному DTO
     * @param userDto
     * @return пользователь, который сохранен в базе данных
     */
    public User register(UserDto userDto){
        if(existsByUsername(userDto.getUsername())) throw new UserAlreadyExistsException();

        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return userRepository.save(user);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
}
