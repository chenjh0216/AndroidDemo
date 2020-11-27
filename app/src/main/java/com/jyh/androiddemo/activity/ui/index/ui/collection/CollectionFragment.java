package com.jyh.androiddemo.activity.ui.index.ui.collection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jyh.androiddemo.R;
import com.jyh.androiddemo.activity.ui.BaseFragment;
import com.jyh.androiddemo.entity.wx.WxCollectionResponse;


public class CollectionFragment extends BaseFragment {

    private CollectionViewModel collectionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        collectionViewModel =
                new ViewModelProvider(this).get(CollectionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_collection, container, false);
        collectionViewModel.getCollectionResponseLiveData().observe(getViewLifecycleOwner(), new Observer<WxCollectionResponse>() {
            @Override
            public void onChanged(WxCollectionResponse wxCollectionResponse) {
                debug("wxCollectionResponse : " + wxCollectionResponse);
            }
        });
        collectionViewModel.fetch(1);

        return root;
    }
}