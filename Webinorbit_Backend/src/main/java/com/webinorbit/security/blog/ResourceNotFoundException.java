package com.webinorbit.security.blog;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, Integer id) {
        super(resourceName + " with ID " + id + " not found");
    }
}
