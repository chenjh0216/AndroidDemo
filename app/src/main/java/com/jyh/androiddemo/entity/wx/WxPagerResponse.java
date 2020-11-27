package com.jyh.androiddemo.entity.wx;

public class WxPagerResponse extends BaseWxResponse {

    public static class Pager {
        public int Offset;
        public int Limit;
        public int Total;
    }

    private Pager pager;

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
