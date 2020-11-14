package com.jyh.androiddemo.entity.wx;

public class AccessTokenEntity extends BaseWxResponse {

    private String access_token;
    private int expires_in; //默认7200毫秒 == 720秒 == 120分 == 2小时

    private long createdTimestamp = System.currentTimeMillis();

    public String getAccess_token() {
        return access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public boolean isExpired(){
        return (System.currentTimeMillis() - createdTimestamp) >= expires_in;
    }
}
