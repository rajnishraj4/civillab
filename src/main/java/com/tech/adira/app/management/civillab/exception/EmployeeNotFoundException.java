package com.tech.adira.app.management.civillab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when an Employee entity cannot be found by its identifier.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

    /**
     * Constructs a new EmployeeNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public EmployeeNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new EmployeeNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the root cause exception
     */
    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}