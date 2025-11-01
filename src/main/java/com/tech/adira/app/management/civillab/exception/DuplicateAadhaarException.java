package com.tech.adira.app.management.civillab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when an Employee with the same Aadhaar number already exists.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateAadhaarException extends RuntimeException {

    /**
     * Constructs a new DuplicateAadhaarException with the specified detail message.
     *
     * @param message the detail message
     */
    public DuplicateAadhaarException(String message) {
        super(message);
    }

    /**
     * Constructs a new DuplicateAadhaarException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the root cause exception
     */
    public DuplicateAadhaarException(String message, Throwable cause) {
        super(message, cause);
    }
}
