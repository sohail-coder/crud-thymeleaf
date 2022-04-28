package com.sohail.springboot.thymeleafdemo.controller;

public class EmployeetNotFoundException extends RuntimeException{
    public EmployeetNotFoundException(String message) {
        super(message);
    }

    public EmployeetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeetNotFoundException(Throwable cause) {
        super(cause);
    }
}
