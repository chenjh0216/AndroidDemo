package com.jyh.androiddemo.presenters.impl;

import android.content.Context;

import com.jyh.androiddemo.presenters.IIndexPresenter;

public class IndexPresenter extends DefaultPresenter implements IIndexPresenter {

    private int mLayoutId;
    private Context mContext;

    public IndexPresenter(Context context, int mLayoutId){
        this.mLayoutId = mLayoutId;
        this.mContext = context;
    }

}
