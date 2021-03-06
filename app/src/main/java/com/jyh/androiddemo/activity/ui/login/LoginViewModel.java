package com.jyh.androiddemo.activity.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jyh.androiddemo.activity.data.Result;
import com.jyh.androiddemo.net.apis.wx.WxServices;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<Result> loginResponseMutableLiveData;
    private boolean isSigning;

    public LoginViewModel() {
        this.isSigning = false;
        this.loginResponseMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Result> getLoginResponseMutableLiveData() {
        return loginResponseMutableLiveData;
    }

    public void login(String appId, String secret) {
        if (isSigning){
            return;
        }
        isSigning = true;
        WxServices.getInstance().token(WxServices.WxConstants.GRANT_TYPE, appId, secret)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(accessTokenEntity -> {
                    //success
                    loginResponseMutableLiveData.setValue(new Result.Success<>(accessTokenEntity));
                }, throwable -> {
                    //error
                    loginResponseMutableLiveData.setValue(new Result.Error(new Exception(throwable)));
                }, () -> {
                    //complete
                    isSigning = false;
                });
    }

    public void logout() {
        WxServices.getInstance().logout();
    }

}
