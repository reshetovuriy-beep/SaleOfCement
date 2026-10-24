package org.example.service;

public class IncorrectInputException extends RuntimeException {

    public IncorrectInputException(String message) {
        super(message);
    }
}

