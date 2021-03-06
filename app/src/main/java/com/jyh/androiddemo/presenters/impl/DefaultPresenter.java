package com.jyh.androiddemo.presenters.impl;

import android.util.Log;

import com.jyh.androiddemo.presenters.IBasePresenter;

public class DefaultPresenter implements IBasePresenter {

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
        return null;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onDestroy() {

    }
}
