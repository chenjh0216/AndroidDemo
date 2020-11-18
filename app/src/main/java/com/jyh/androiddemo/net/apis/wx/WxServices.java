package com.jyh.androiddemo.net.apis.wx;

import androidx.annotation.NonNull;

import com.jyh.androiddemo.entity.wx.AccessTokenEntity;
import com.jyh.androiddemo.net.retrofit.RetrofitService;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;

public class WxServices implements WxApis {

    @Override
    public Observable<AccessTokenEntity> token(String grantType, String appId, String secret) {
        if (mAccessToken != null && mAccessToken.isAvailable()){
            return Observable.just(mAccessToken);
        }
        return wxApis.token(grantType, appId, secret)
                .flatMap(new Function<AccessTokenEntity, ObservableSource<? extends AccessTokenEntity>>() {
                    @Override
                    public ObservableSource<? extends AccessTokenEntity> apply(AccessTokenEntity entity) throws Throwable {
                        if (entity.isAvailable()) {
                            mAccessToken = entity;
                            return Observable.just(entity);
                        }
                        return Observable.error(new Throwable(entity.getErrmsg()));
                    }
                });
    }

    public interface WxConstants {
        String GRANT_TYPE = "client_credential";
        String APP_ID = "wx838a480b8c4bc2c8";
        String APP_SECRET = "b7596b6fafbf14cf9a6a2c6c1c3454d4";
        enum ENV {
            ENV_DEV("dev-pdnbq"),ENV_PRO("pro-hml29");

            private String value;

            ENV(String s) {
                value = s;
            }

            @NonNull
            @Override
            public String toString() {
                return value;
            }
        }
    }

    private AccessTokenEntity mAccessToken;

    private static volatile WxServices instance;

    private final WxApis wxApis;

    public static WxApis getInstance(){
        if (instance == null){
            synchronized (WxServices.class){
                if (instance == null){
                    instance = new WxServices();
                }
            }
        }
        return instance;
    }

    private WxServices() {
        wxApis = RetrofitService.obtain(WxApis.baseWxUrl).create(WxApis.class);
    }

}
