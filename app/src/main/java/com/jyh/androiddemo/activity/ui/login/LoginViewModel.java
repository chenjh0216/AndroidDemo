package com.jyh.androiddemo.activity.ui.login;

import com.jyh.androiddemo.activity.data.Result;
import com.jyh.androiddemo.entity.wx.AccessTokenEntity;
import com.jyh.androiddemo.net.apis.wx.WxServices;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<Result> loginResponseMutableLiveData;

    public LoginViewModel(){
        this.loginResponseMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Result> getLoginResponseMutableLiveData() {
        return loginResponseMutableLiveData;
    }

    public void login(String appId, String secret, String env){
      	WxServices.getInstance().token(WxServices.WxConstants.GRANT_TYPE, appId, secret)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(new Consumer<AccessTokenEntity>() {
			  @Override
			  public void accept(AccessTokenEntity accessTokenEntity) throws Throwable {
				//success
			  }
			},new Consumer<Throwable>(){
			  @Override
			  public void accept(Throwable throwable) throws Throwable {
				//error
			  }
			}, new Action(){

			  @Override
			  public void run() throws Throwable {
				//complete
			  }
			});
    }

    public void logout(){
        WxServices.getInstance().logout();
    }

}
