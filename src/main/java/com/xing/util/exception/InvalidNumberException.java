package com.xing.util.exception;

public class InvalidNumberException extends RuntimeException{
    private String message;

    public InvalidNumberException(String message) {
        this.message = message;
    }
}
