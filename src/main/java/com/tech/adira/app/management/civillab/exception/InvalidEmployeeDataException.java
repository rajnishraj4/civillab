package com.tech.adira.app.management.civillab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when provided Employee data is invalid or fails validation rules.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeDataException extends RuntimeException {

    /**
     * Constructs a new InvalidEmployeeDataException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidEmployeeDataException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidEmployeeDataException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the root cause exception
     */
    public InvalidEmployeeDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
