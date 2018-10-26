package com.king.turman.talkme;

import android.*;
import android.Manifest;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;

import com.king.turman.talkme.database.DatabaseUtil;
import com.king.turman.talkme.viewbeans.TaskBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageView recorder;
    private RecyclerView recyclerView;
    private MainListAdapter mainListAdapter;

    private List<TaskBean> taskBeans;

    MediaRecorder mRecorder;

    String filePath ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_layout);
        recyclerView = findViewById(R.id.recycler_list);
        recorder = findViewById(R.id.recorder);

        initListView();
        checkPermission(Manifest.permission.RECORD_AUDIO,()-> {
            checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,()->initRecorderView(),REQUEST_PHONE_READ_FILE_PERMISSION);
        },REQUEST_PHONE_AUDIO_PERMISSION);

//        TaskBean bean1 = new TaskBean();
//        bean1.setSender("buobao");
//        bean1.setReceivers(new ArrayList(){
//            {
//                add("MMMMMMM");
//                add("NNNNNNN");
//                add("OOOOOOO");
//            }
//        });
//        DatabaseUtil.getInstance(this).insertTask(bean1);
//        TaskBean bean2 = new TaskBean();
//        DatabaseUtil.getInstance(this).queryTask(bean2);
//        AppUtil.showToast(bean2.getSender(),this);
    }

    private void initRecorderView() {
        recorder.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    AppUtil.showToast("action down", this);
                    mRecorder = new MediaRecorder();
                    mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
                    filePath = getExternalCacheDir().getAbsolutePath() + File.separator + System.currentTimeMillis();
                    mRecorder.setOutputFile(filePath);
                    mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    try {
                        mRecorder.prepare();
                        mRecorder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    AppUtil.showToast("action up", this);
                    mRecorder.stop();
                    mRecorder.reset();
                    mRecorder = null;

                    MediaPlayer mMediaPlayer = new MediaPlayer();
                    try {
                        mMediaPlayer.setDataSource(filePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mMediaPlayer.prepareAsync();
                    mMediaPlayer.start();
//                    mMediaPlayer.release();
                    break;
            }

            return true;
        });
    }

    private void initListView() {
        taskBeans = new ArrayList<>();
        taskBeans.add(new TaskBean());
        taskBeans.add(new TaskBean());
        mainListAdapter = new MainListAdapter(taskBeans);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainListAdapter);

        swipeRefreshLayout.setRefreshing(true);

        swipeRefreshLayout.postDelayed(() -> {
            // TODO: 2018/10/22 拉取数据
            swipeRefreshLayout.setRefreshing(false);
            TaskBean bean = new TaskBean();
            bean.setSender("buobao");
            taskBeans.add(0,bean);
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fall_down);
            recyclerView.setLayoutAnimation(controller);
            mainListAdapter.notifyItemRangeChanged(0,1);
            recyclerView.scheduleLayoutAnimation();

//            Intent intent = new Intent(this, WebActivity.class);
//            startActivity(intent);
        }, 3000);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.appColor));



        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(() -> {
            AppUtil.showToast("setOnRefreshListener",this);
            swipeRefreshLayout.setRefreshing(false);
        });

        //加载动画


    }

    @Override
    public String setTag() {
        return MainActivity.class.getName();
    }
}

































