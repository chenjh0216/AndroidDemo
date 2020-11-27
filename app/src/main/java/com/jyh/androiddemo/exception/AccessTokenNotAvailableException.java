package com.jyh.androiddemo.exception;

public class AccessTokenNotAvailableException extends Exception {
    public AccessTokenNotAvailableException(String token_is_not_available) {
        super(token_is_not_available);
    }
}
