package com.company.moody.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.moody.exceptions.PasswordTooWeakException;
import com.company.moody.factories.UserDtoFactory;

@SpringBootTest
public class UserServiceTest {
    @Autowired
	private UserService userService;
	@Test
	public void shouldNotThrowWhenPasswordStrong(){
		assertDoesNotThrow(() -> userService.register(UserDtoFactory.randomUsername("Password1")));
		assertDoesNotThrow(() -> userService.register(UserDtoFactory.randomUsername("paSsword1")));
		assertDoesNotThrow(() -> userService.register(UserDtoFactory.randomUsername("pa1sswoRd")));
	}

	@Test
	public void shouldThrowWhenPasswordWeak(){
		assertThrows(PasswordTooWeakException.class, () -> userService.register(UserDtoFactory.randomUsername("password1")));
        assertThrows(PasswordTooWeakException.class, () -> userService.register(UserDtoFactory.randomUsername("password134543534534")));
        assertThrows(PasswordTooWeakException.class, () -> userService.register(UserDtoFactory.randomUsername("PASSWORD1")));
	}
}
