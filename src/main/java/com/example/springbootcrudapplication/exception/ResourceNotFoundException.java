package com.example.springbootcrudapplication.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String exceptionMessage)
    {
        super(exceptionMessage);
    }

}
