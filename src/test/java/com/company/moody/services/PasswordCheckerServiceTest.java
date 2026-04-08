package com.company.moody.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordCheckerServiceTest {
    @Autowired
    public PasswordCheckerService passwordCheckerService;
    @Test
    public void testMatch(){
        assertEquals(true, passwordCheckerService.isValid("sdfsdfdsJKDFSDHFSD9938388"));
    }
}
