package com.jyh.androiddemo.net.apis.wx;

import androidx.annotation.NonNull;

public enum Env {

    ENV_DEV("dev-pdnbq"), ENV_PRO("pro-hml29");

    private String value;

    Env(String s) {
        value = s;
    }

    @NonNull
    @Override
    public String toString() {
        return value;
    }

}
