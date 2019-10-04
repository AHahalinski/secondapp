package com.epam.project.task02.exception;

public class FileNotExistHandlerException extends RuntimeException {
    public FileNotExistHandlerException() {
    }

    public FileNotExistHandlerException(String message) {
        super(message);
    }

    public FileNotExistHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotExistHandlerException(Throwable cause) {
        super(cause);
    }

    public FileNotExistHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
