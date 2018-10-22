package com.king.turman.talkme;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;


import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

public class LauncherActivity extends BaseActivity {

    private static final int JPUSH_SET_ALIAS = 1;

    /**
     * 极光别名 标签设置回调
     */
    private final TagAliasCallback mAliasCallback = (code, alias, tags) -> {
        String logs ;
        switch (code) {
            case 0:
                logs = "Set tag and alias success";
                Log.i(TAG, logs);
                //保存别名设置成功状态
                AppCurrentStatus.getInstance().setJPushAliasSet(true);
                AppCurrentStatus.getInstance().setjPushAlias(alias);
                break;
            case 6002:
                logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                Log.i(TAG, logs);
                // 延迟 60 秒来调用 Handler 设置别名
                // TODO: 18-10-20 这里需要一个service
                //mHandler.sendMessageDelayed(mHandler.obtainMessage(JPUSH_SET_ALIAS, alias), 1000 * 60);
                break;
            default:
                logs = "Failed with errorCode = " + code;
                Log.e(TAG, logs);
        }
        AppUtil.showToast(logs, getApplicationContext());
    };

    /**
     * 异步设置
     */
    private final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case JPUSH_SET_ALIAS:
                    JPushInterface.setAliasAndTags(getApplicationContext(),
                            (String) msg.obj,
                            null,
                            mAliasCallback);
                    break;
                default:
                    Log.i(TAG, "Unhandled msg - " + msg.what);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        setContentView(R.layout.activity_launcher);
        //设置别名
        setJpushAlias();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LauncherActivity.this, MainActivity.class));
                finish();
            }
        },800);
    }


    /**
     * 设置极光别名
     */
    public void setJpushAlias() {
        checkPermission(android.Manifest.permission.READ_PHONE_STATE,
                () -> mHandler.sendMessage(mHandler.obtainMessage(JPUSH_SET_ALIAS, AppUtil.getImei(LauncherActivity.this, "any_one"))), REQUEST_PHONE_STATUS_PERMISSION);
    }


    @Override
    public String setTag() {
        return LauncherActivity.class.getName();
    }
}
