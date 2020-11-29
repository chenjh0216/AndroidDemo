package com.jyh.androiddemo.activity.ui.index.ui.collection;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jyh.androiddemo.R;
import com.jyh.androiddemo.entity.wx.WxCollectionResponse;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder> {

    private WxCollectionResponse collections;

    public CollectionAdapter(){
        this.collections = new WxCollectionResponse();
    }

    public void setCollections(WxCollectionResponse response){
        this.collections = response;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(getClass().getSimpleName(),"onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_collection_item,parent,false);
        return new CollectionViewHolder(view);
    }

    @Override
    public int getItemCount() {
        Log.d(getClass().getSimpleName(), "get Item Count");
        return collections.getCollections().size();
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder holder, int position) {
        Log.d(getClass().getSimpleName(), "onBindViewHolder index " + position);
        WxCollectionResponse.WxCollection collection = collections.getCollections().get(position);
        holder.mNameTextView.setText(collection.name);
        holder.mCountTextView.setText(String.valueOf(collection.count));
        holder.mSizeTextView.setText(String.valueOf(collection.size));
    }


    public static class CollectionViewHolder extends RecyclerView.ViewHolder {

        public TextView mNameTextView;
        public TextView mCountTextView;
        public TextView mSizeTextView;

        public CollectionViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameTextView = itemView.findViewById(R.id.name);
            mCountTextView = itemView.findViewById(R.id.count);
            mSizeTextView = itemView.findViewById(R.id.size);
        }
    }


}
