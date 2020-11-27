package com.jyh.androiddemo.entity.wx;


import java.util.ArrayList;
import java.util.List;

public class WxCollectionResponse extends WxPagerResponse {

    public static class WxCollection {
        public String name;
        public int count;
        public int size;
        public int index_count;
        public int index_size;
    }

    private List<WxCollection> collections = new ArrayList<>();

    public List<WxCollection> getCollections() {
        return collections;
    }

    public void setCollections(List<WxCollection> collections) {
        this.collections = collections;
    }
}
