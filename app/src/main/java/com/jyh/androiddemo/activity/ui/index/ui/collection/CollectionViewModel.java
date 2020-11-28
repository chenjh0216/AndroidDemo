package com.jyh.androiddemo.activity.ui.index.ui.collection;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jyh.androiddemo.entity.wx.WxCollectionResponse;
import com.jyh.androiddemo.net.apis.wx.WxCollectionRepository;
import com.jyh.androiddemo.net.apis.wx.WxServices;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

public class CollectionViewModel extends ViewModel{

    private MutableLiveData<WxCollectionResponse> collectionResponseMutableLiveData;
    private WxCollectionRepository wxCollectionRepository;

    public CollectionViewModel() {
        wxCollectionRepository = WxCollectionRepository.getInstance();
        collectionResponseMutableLiveData = new MutableLiveData<>();
    }

    public void fetch(String env, int page){
        int skip = (page - 1 ) * WxServices.DEFAULT_LIMIT;
        int offset = skip < 0 ? 0 : skip;
        wxCollectionRepository.fetchCollections(env, offset)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WxCollectionResponse>() {
                    @Override
                    public void accept(WxCollectionResponse wxCollectionResponse) throws Throwable {
                        collectionResponseMutableLiveData.setValue(wxCollectionResponse);
                        Log.d("CollectionViewModel", "wxCollectionResponse succeed");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.e("CollectionViewModel", "wxCollectionResponse failed " + throwable.getMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Throwable {

                    }
                });
    }

    public LiveData<WxCollectionResponse> getCollectionResponseLiveData() {
        return collectionResponseMutableLiveData;
    }
}