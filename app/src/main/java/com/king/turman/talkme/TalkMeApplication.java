package com.king.turman.talkme;

import android.app.Application;
import cn.jpush.android.api.JPushInterface;

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
