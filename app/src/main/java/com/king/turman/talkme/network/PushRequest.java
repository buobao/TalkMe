package com.king.turman.talkme.network;

import com.king.turman.talkme.network.netEntity.PushRequestBean;
import com.king.turman.talkme.network.netEntity.PushResponseBean;

import io.reactivex.Observable;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by diaoqf on 2018/10/23.
 */

public interface PushRequest {

    @POST("push")
    Observable<PushResponseBean> pushMessage(@Header("Authorization") String authorization, PushRequestBean bean);

}
