package com.epam.project.task02.exception;

public class TypePlaneNotCorrectHandlerException extends RuntimeException {
    public TypePlaneNotCorrectHandlerException() {
    }

    public TypePlaneNotCorrectHandlerException(String message) {
        super(message);
    }

    public TypePlaneNotCorrectHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypePlaneNotCorrectHandlerException(Throwable cause) {
        super(cause);
    }

    public TypePlaneNotCorrectHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
