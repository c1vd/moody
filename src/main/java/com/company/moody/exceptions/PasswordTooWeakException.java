package com.company.moody.exceptions;

public class PasswordTooWeakException extends RuntimeException {
    public PasswordTooWeakException(){
        super("Password too weak");
    }
}
