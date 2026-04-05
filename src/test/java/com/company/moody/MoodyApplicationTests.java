package com.company.moody;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.moody.dto.UserDto;
import com.company.moody.services.UserService;

@SpringBootTest
class MoodyApplicationTests {
	@Autowired
	private UserService userService;
	@Test
	void shouldNotSaveUserWithExistingName(){
		var user1 = new UserDto("JohnDoe", "SuperWeakPassword1");
		var user2 = new UserDto("JohnDoe", "SuperWeakPassword2");

		assertEquals("JohnDoe", userService.register(user1).getUsername());
		assertEquals(null, userService.register(user1));
		assertEquals(null, userService.register(user2));
	}


	
}
