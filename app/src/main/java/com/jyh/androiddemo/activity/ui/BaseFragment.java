package com.jyh.androiddemo.activity.ui;


import android.util.Log;

import androidx.fragment.app.Fragment;

import com.jyh.androiddemo.presenters.IBaseLogger;

public class BaseFragment extends Fragment implements IBaseLogger {

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
