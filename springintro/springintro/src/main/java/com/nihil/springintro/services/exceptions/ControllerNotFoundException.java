package com.nihil.springintro.services.exceptions;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(Object id){
        super("No data was found for id: " + id);
    }
}
