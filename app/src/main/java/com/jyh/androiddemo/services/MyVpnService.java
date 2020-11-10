package com.jyh.androiddemo.services;

import android.content.Intent;
import android.net.VpnService;

import com.jyh.androiddemo.presenters.IBaseLogger;
import com.jyh.androiddemo.presenters.impl.DefaultLogger;

public class MyVpnService extends VpnService {

    private IBaseLogger logger;

    public MyVpnService(){
        logger = new DefaultLogger(this.getClass().getSimpleName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        logger.debug("onStartCommand flags:" + flags + " startId:" + startId);
        return super.onStartCommand(intent, flags, startId);
    }
}
