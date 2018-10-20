package com.king.turman.talkme;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected static String TAG;


    //permission tags
    protected static final int REQUEST_PHONE_STATUS_PERMISSION = 1;  //手机状态权限

    private PermissionAction currentAction;  //当前权限请求行为

    public abstract String setTag();

    public boolean checkPermission(String permission, PermissionAction action, int request_code) {
        boolean flag = false;
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            //已有权限
            flag = true;
            if (action != null) {
                action.action();
            }
        } else {
            //申请权限
            currentAction = action;
            ActivityCompat.requestPermissions(this, new String[]{permission}, request_code);
        }

        return flag;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PHONE_STATUS_PERMISSION: //手机状态
                if (permissions.length != 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    //失败
                    AppUtil.showToast("请允许获取手机状态权限后再试", this);
                } else {
                    //成功
                    if (currentAction != null) {
                        currentAction.action();
                        currentAction = null;
                    }
                }
                break;
        }
    }



    public interface PermissionAction {
        void action();
    }
}
