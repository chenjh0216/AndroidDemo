package com.jyh.androiddemo.net.apis.wx;

import com.jyh.androiddemo.entity.wx.AccessTokenEntity;
import com.jyh.androiddemo.net.retrofit.RetrofitService;

public class WxServices {

    public interface WxConstants {
        String GRANT_TYPE = "client_credential";
        String APP_ID = "wx838a480b8c4bc2c8";
        String APP_SECRET = "b7596b6fafbf14cf9a6a2c6c1c3454d4";
        String ENV_DEV = "dev-pdnbq";
        String ENV_PRO = "pro-hml29";
    }

    private AccessTokenEntity mAccessToken;

    private static volatile WxApis instance;

    public static WxApis getInstance(){
        if (instance == null){
            synchronized (WxApis.class){
                if (instance == null){
                    instance = RetrofitService.obtain(WxApis.baseWxUrl).create(WxApis.class);
                }
            }
        }
        return instance;
    }

    private WxServices() {
    }

}
