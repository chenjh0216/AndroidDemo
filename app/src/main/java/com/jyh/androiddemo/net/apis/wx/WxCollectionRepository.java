package com.jyh.androiddemo.net.apis.wx;

import androidx.collection.ArrayMap;

import com.jyh.androiddemo.entity.wx.WxCollectionResponse;

import io.reactivex.rxjava3.core.Observable;

public class WxCollectionRepository {

    private static volatile WxCollectionRepository instance;

    public static WxCollectionRepository getInstance() {
        if (instance == null) {
            synchronized (WxCollectionRepository.class) {
                if (instance == null) {
                    instance = new WxCollectionRepository();
                }
            }
        }
        return instance;
    }

    private WxCollectionRepository(){
        collectionResponseArrayMap = new ArrayMap<>();
    }

    private ArrayMap<String,WxCollectionResponse> collectionResponseArrayMap;

    public Observable<WxCollectionResponse> fetchCollections(String envPro, int offset) {

        return WxServices.getInstance().fetchCollections(envPro,offset);
    }
}
