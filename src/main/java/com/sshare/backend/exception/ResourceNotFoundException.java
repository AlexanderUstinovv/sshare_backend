package com.sshare.backend.exception;

import lombok.Getter;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    @Getter
    private String resourceName;
    @Getter
    private String fieldName;
    @Getter
    private Object fieldValue;
}
