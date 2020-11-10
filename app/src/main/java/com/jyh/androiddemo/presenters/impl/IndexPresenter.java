package com.jyh.androiddemo.presenters.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.widget.Button;

import com.jakewharton.rxbinding4.view.RxView;
import com.jyh.androiddemo.R;
import com.jyh.androiddemo.presenters.IIndexPresenter;
import com.jyh.androiddemo.services.MyVpnService;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;

public class IndexPresenter extends DefaultPresenter implements IIndexPresenter {

    private int mLayoutId;
    private Activity mActivity;

    private Button mStartServiceBtn;
    private Button mStopServiceBtn;

    public IndexPresenter(Activity mActivity, int mLayoutId){
        this.mLayoutId = mLayoutId;
        this.mActivity = mActivity;

        mStartServiceBtn = mActivity.findViewById(R.id.startServiceBtn);
        mStopServiceBtn = mActivity.findViewById(R.id.stopServiceBtn);
        RxView.clicks(mStartServiceBtn)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Unit>() {
                    @Override
                    public void accept(Unit unit) throws Throwable {
                        debug("startVpnService");
                        startVpnService();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        error("startVpnService");
                    }
                }, new Action(){
                    @Override
                    public void run() throws Throwable {

                    }
                });
        RxView.clicks(mStopServiceBtn)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Unit>() {
                    @Override
                    public void accept(Unit unit) throws Throwable {
                        debug("stopVpnService");
                        stopVpnService();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        error("stopVpnService");
                    }
                }, new Action(){
                    @Override
                    public void run() throws Throwable {

                    }
                });
    }

    @Override
    public void startVpnService() {
        Intent i = new Intent(mActivity, MyVpnService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mActivity.startForegroundService(i);
        } else {
            mActivity.startService(i);
        }
    }

    @Override
    public void stopVpnService() {
        Intent i = new Intent(mActivity, MyVpnService.class);
        mActivity.stopService(i);
    }

    @Override
    public String getTag() {
        return this.getClass().getSimpleName();
    }
}
