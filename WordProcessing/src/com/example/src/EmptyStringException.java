package com.example.src;

/**
 * Exception class that validates that strings aren't empty.
 *
 * @author kemar
 */
public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("Must not be empty");
    }
    
    public EmptyStringException(String msg) {
        super(msg);
    }
}
