package com.jyh.androiddemo.entity.wx;

public class AccessTokenNotAvailableException extends Exception {
    public AccessTokenNotAvailableException(String token_is_not_available) {
        super(token_is_not_available);
    }
}
