package com.jyh.androiddemo.presenters.impl;

import android.util.Log;

import androidx.annotation.NonNull;

import com.jyh.androiddemo.presenters.IBaseLogger;

public class DefaultLogger implements IBaseLogger {

    private String tag;

    public DefaultLogger(@NonNull String tag){
        this.tag = tag;
    }

    @Override
    public void debug(String str) {
        Log.d(getTag(), str);
    }

    @Override
    public void info(String str) {
        Log.i(getTag(), str);
    }

    @Override
    public void warn(String str) {
        Log.w(getTag(), str);
    }

    @Override
    public void error(String str) {
        Log.e(getTag(), str);
    }

    @Override
    public void wtf(String str) {
        Log.wtf(getTag(), str);
    }

    @Override
    public String getTag() {
        return tag;
    }
}
