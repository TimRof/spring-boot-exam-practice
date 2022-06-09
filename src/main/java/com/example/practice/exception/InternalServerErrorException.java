package com.example.practice.exception;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException() {
        super("Internal server error.");
    }
    public InternalServerErrorException(String msg) {
        super(msg);
    }
}