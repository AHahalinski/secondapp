package com.epam.project.tas02.exception;

public class ErrorCreateIOStreamHandlerException extends RuntimeException {
    public ErrorCreateIOStreamHandlerException() {
    }

    public ErrorCreateIOStreamHandlerException(String message) {
        super(message);
    }

    public ErrorCreateIOStreamHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCreateIOStreamHandlerException(Throwable cause) {
        super(cause);
    }

    public ErrorCreateIOStreamHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
