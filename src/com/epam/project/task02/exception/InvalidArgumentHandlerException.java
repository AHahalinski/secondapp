package com.epam.project.task02.exception;

public class InvalidArgumentHandlerException extends RuntimeException {

    public InvalidArgumentHandlerException() {
    }

    public InvalidArgumentHandlerException(String message) {
        super(message);
    }

    public InvalidArgumentHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArgumentHandlerException(Throwable cause) {
        super(cause);
    }

    public InvalidArgumentHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
