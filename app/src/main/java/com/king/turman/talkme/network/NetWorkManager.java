package com.king.turman.talkme.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diaoqf on 2018/10/22.
 */
public class NetWorkManager {

    private static NetWorkManager mInstance;

    private static Retrofit pushRetrofit;
    private static volatile PushRequest pushRequest;

    public static NetWorkManager getInstance() {
        if (mInstance == null) {
            synchronized (NetWorkManager.class) {
                if (mInstance == null) {
                    mInstance = new NetWorkManager();
                }
            }
        }
        return mInstance;
    }

    public NetWorkManager() {
        init();
    }

    /**
     * 初始化必要对象和参数
     */
    public void init() {
        // 初始化okhttp
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        // 初始化Retrofit
        pushRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(NetContent.URL_JPUSH)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 推送请求request
     * @return
     */
    public static PushRequest getPushRequest() {
        if (pushRequest == null) {
            synchronized (PushRequest.class) {
                pushRequest = pushRetrofit.create(PushRequest.class);
            }
        }
        return pushRequest;
    }



}
