package com.common.exceptionClass;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException{
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public UserException(String message) {
        super(message);
    }
}
