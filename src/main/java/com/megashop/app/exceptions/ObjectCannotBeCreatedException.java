package com.megashop.app.exceptions;

public class ObjectCannotBeCreatedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectCannotBeCreatedException(String err) {
        super(err);
    }

    public ObjectCannotBeCreatedException(String err, Throwable cause) {
        super(err, cause);
    }
}
