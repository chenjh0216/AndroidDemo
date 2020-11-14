package com.jyh.androiddemo.presenters.impl;

import android.app.Activity;
import android.widget.Button;

import com.jakewharton.rxbinding4.view.RxView;
import com.jyh.androiddemo.R;
import com.jyh.androiddemo.entity.wx.AccessTokenEntity;
import com.jyh.androiddemo.net.apis.wx.WxApis;
import com.jyh.androiddemo.net.apis.wx.WxServices;
import com.jyh.androiddemo.presenters.IIndexPresenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;

import static com.jyh.androiddemo.net.apis.wx.WxServices.WxConstants.APP_ID;
import static com.jyh.androiddemo.net.apis.wx.WxServices.WxConstants.APP_SECRET;
import static com.jyh.androiddemo.net.apis.wx.WxServices.WxConstants.GRANT_TYPE;

public class IndexPresenter extends DefaultPresenter implements IIndexPresenter {

    private int mLayoutId;
    private Activity mActivity;

    private Button mloginBtn;

    private WxApis wxApis;

    public IndexPresenter(Activity mActivity, int mLayoutId) {
        this.mLayoutId = mLayoutId;
        this.mActivity = mActivity;
        this.wxApis = WxServices.getInstance();

        mloginBtn = mActivity.findViewById(R.id.loginBtn);
        RxView.clicks(mloginBtn)
                .throttleFirst(3, TimeUnit.SECONDS)
                .flatMap((Function<Unit, ObservableSource<AccessTokenEntity>>) unit -> wxApis.token(GRANT_TYPE, APP_ID, APP_SECRET))
                .subscribe(new Consumer<AccessTokenEntity>() {
                    @Override
                    public void accept(AccessTokenEntity entity) throws Throwable {
                        debug("access token : " + entity.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        error(throwable.toString());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Throwable {

                    }
                });
    }

    @Override
    public String getTag() {
        return this.getClass().getSimpleName();
    }
}
