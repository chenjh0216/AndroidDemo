package com.jyh.androiddemo.net.retrofit;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpInterceptor implements Interceptor {

    private static final long CACHE_CONTROL_CACHE = 60 * 60 * 24 * 1;

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        return chain.proceed(request);
    }

}
