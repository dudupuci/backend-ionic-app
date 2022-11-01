package com.megashop.app.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String err) {
        super(err);
    }

    public ObjectNotFoundException(String err, Throwable cause) {
        super(err, cause);
    }
}
