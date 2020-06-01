package com.banshee.infoclients.exception;

import java.io.Serializable;

public class ApplicationException extends Exception implements Serializable {

    private static final long serialVersionUID = 7095257931911379656L;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
