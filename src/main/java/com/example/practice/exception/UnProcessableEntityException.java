package com.example.practice.exception;

public class UnProcessableEntityException extends RuntimeException {
    public UnProcessableEntityException() {
        super("Unprocessable entity.");
    }
    public UnProcessableEntityException(String msg) {
        super(msg);
    }
}
