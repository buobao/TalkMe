package com.king.turman.talkme;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * Created by diaoqf on 2018/10/19.
 */

public class TalkMeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //极光初始化
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

}
