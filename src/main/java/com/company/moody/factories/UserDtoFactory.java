package com.company.moody.factories;

import java.util.UUID;

import com.company.moody.dto.UserDto;

public class UserDtoFactory {
    public static UserDto randomUsername(String password){
        return new UserDto(UUID.randomUUID().toString(), password);
    }
}
