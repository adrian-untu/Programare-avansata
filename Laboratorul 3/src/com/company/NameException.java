package com.company;

/**
 * I created a custom exception class which returns a custom message that I implemented in all the classes that required a custom exception
 */
public class NameException extends Exception {
    public NameException(String message) {
        super(message);
    }
}
