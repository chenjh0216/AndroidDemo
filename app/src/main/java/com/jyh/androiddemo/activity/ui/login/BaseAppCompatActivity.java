package com.jyh.androiddemo.activity.ui.login;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.jyh.androiddemo.presenters.IBaseLogger;

public abstract class BaseAppCompatActivity extends AppCompatActivity implements IBaseLogger {

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

}
