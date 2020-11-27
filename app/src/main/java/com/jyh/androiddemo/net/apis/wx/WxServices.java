package com.jyh.androiddemo.net.apis.wx;

import com.jyh.androiddemo.entity.wx.AccessTokenEntity;
import com.jyh.androiddemo.exception.AccessTokenNotAvailableException;
import com.jyh.androiddemo.entity.wx.WxCollectionResponse;
import com.jyh.androiddemo.net.retrofit.RetrofitService;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class WxServices implements WxApis {

    private <T> Observable<T> notLoginResponse() {
        return Observable.error(new AccessTokenNotAvailableException("token is not available"));
    }

    @Override
    public boolean hasLogin() {
        return mAccessToken != null && mAccessToken.isAvailable();
    }

    @Override
    public void logout() {
        synchronized (this) {
            mAccessToken = null;
        }
    }

    @Override
    public Observable<AccessTokenEntity> token(String grantType, String appId, String secret) {
        if (mAccessToken != null) {
            if (mAccessToken.isAvailable()) {
                return Observable.just(mAccessToken);
            }
            return notLoginResponse();
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

    @Override
    public Observable<WxCollectionResponse> fetchCollections(String env, int offset) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("env", env);
        map.put("offset", offset);
        RequestBody body = RequestBody.create(new JSONObject(map).toString(),MediaType.parse("Content-Type, application/json"));
        return fetchCollections(mAccessToken.getAccess_token(), body);
    }

    @Override
    public Observable<WxCollectionResponse> fetchCollections(String access_token, RequestBody body) {
        if (!hasLogin()) {
            return notLoginResponse();
        }
        return wxApis.fetchCollections(access_token, body);
    }

    public interface WxConstants {
        String GRANT_TYPE = "client_credential";
        String APP_ID = "wx838a480b8c4bc2c8";
        String APP_SECRET = "b7596b6fafbf14cf9a6a2c6c1c3454d4";

        String ENV_DEV = "dev-pdnbq";
        String ENV_PRO = "pro-hml29";
    }


    private AccessTokenEntity mAccessToken;
    private final WxApis wxApis;
    private WxCollectionRepository collectionRepository;

    private static volatile WxServices instance;

    public static WxApis getInstance() {
        if (instance == null) {
            synchronized (WxServices.class) {
                if (instance == null) {
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
