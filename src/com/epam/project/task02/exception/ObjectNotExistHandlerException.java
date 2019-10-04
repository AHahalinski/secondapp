package com.epam.project.task02.exception;

public class ObjectNotExistHandlerException extends RuntimeException {
    public ObjectNotExistHandlerException() {
    }

    public ObjectNotExistHandlerException(String message) {
        super(message);
    }

    public ObjectNotExistHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotExistHandlerException(Throwable cause) {
        super(cause);
    }

    public ObjectNotExistHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
