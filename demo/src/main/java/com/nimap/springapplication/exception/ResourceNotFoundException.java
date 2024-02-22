package com.nimap.springapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    // Constructor with parameters to initialize the exception
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        // Calling the superclass constructor with a formatted error message
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));

        // Assigning values to class fields
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    // Getter method for the resourceName field
    public String getResourceName() {
        return resourceName;
    }

    // Getter method for the fieldName field
    public String getFieldName() {
        return fieldName;
    }

    // Getter method for the fieldValue field
    public Object getFieldValue() {
        return fieldValue;
    }
}
