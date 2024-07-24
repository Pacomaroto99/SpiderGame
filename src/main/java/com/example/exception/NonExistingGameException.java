package com.example.exception;

public class NonExistingGameException extends RuntimeException {
    public NonExistingGameException(String message) {
        super(message);
    }
}
