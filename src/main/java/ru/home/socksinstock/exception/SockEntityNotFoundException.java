package ru.home.socksinstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SockEntityNotFoundException extends RuntimeException {

    public SockEntityNotFoundException() {
    }

    public SockEntityNotFoundException(String message) {
        super(message);
    }
}
