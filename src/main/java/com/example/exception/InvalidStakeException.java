package com.example.exception;

public class InvalidStakeException extends RuntimeException {

    public InvalidStakeException(String message) {
        super(message);
    }
}
