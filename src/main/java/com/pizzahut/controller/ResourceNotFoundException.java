package com.pizzahut.controller;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(int index) {
        super(String.format("%d not found with list ",index));

    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}