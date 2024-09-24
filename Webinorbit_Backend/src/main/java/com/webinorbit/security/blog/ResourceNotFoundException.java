package com.webinorbit.security.blog;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, Object fieldValue) {
        super(String.format("%s not found with id : '%s'", resourceName, fieldValue));
    }
}
