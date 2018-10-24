package com.king.turman.talkme.network;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by diaoqf on 2018/10/23.
 */

public class NetUtils {
    private static String appKey = "3c7106cc2b27e3e56170be0b";
    private static String masterSecret = "2d26158e8dda73de13d57fe9";
    private static String token;

    public static String getJpushToken() {
        if (token == null) {
            try {
                String encodeWord = Base64.encodeToString((appKey+":"+masterSecret).getBytes("utf-8"), Base64.NO_WRAP);
                token = "Basic "+encodeWord;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return token;
    }

}
