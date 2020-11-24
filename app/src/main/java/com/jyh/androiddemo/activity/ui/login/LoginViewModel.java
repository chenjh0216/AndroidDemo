package com.jyh.androiddemo.activity.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jyh.androiddemo.activity.data.Result;
import com.jyh.androiddemo.net.apis.wx.WxServices;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<Result> loginResponseMutableLiveData;

    public LoginViewModel(){
        this.loginResponseMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Result> getLoginResponseMutableLiveData() {
        return loginResponseMutableLiveData;
    }

    public void login(String appId, String secret, String env){
        if (WxServices.getInstance().hasLogin()){

        } else {
            WxServices.getInstance().token(WxServices.WxConstants.GRANT_TYPE, appId, secret);
        }
    }

    public void logout(){
        WxServices.getInstance().logout();
    }

}
