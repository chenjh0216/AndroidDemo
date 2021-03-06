package com.jyh.androiddemo.entity.wx;

public class BaseWxResponse {

    private int errcode;
    private String errmsg;

    public boolean isAvailable(){
        return getErrcode() == 0;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
