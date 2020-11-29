package com.jyh.androiddemo.activity.ui.index.ui.collection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jyh.androiddemo.R;
import com.jyh.androiddemo.activity.ui.BaseFragment;
import com.jyh.androiddemo.entity.wx.WxCollectionResponse;

import static com.jyh.androiddemo.net.apis.wx.WxServices.WxConstants.ENV_PRO;


public class CollectionFragment extends BaseFragment {

    private CollectionViewModel collectionViewModel;

    private RecyclerView mRecyclerView;
    private CollectionAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        collectionViewModel =
                new ViewModelProvider(this).get(CollectionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_collection, container, false);
        mRecyclerView = root.findViewById(R.id.collectionRecyclerView);
        mAdapter = new CollectionAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        collectionViewModel.getCollectionResponseLiveData().observe(getViewLifecycleOwner(), new Observer<WxCollectionResponse>() {
            @Override
            public void onChanged(WxCollectionResponse wxCollectionResponse) {
                debug("wxCollectionResponse : " + wxCollectionResponse);
                mAdapter.setCollections(wxCollectionResponse);
            }
        });
        collectionViewModel.fetch(ENV_PRO,1);

        return root;
    }
}