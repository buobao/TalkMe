package com.king.turman.talkme;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.king.turman.talkme.viewbeans.TaskBean;

import java.util.List;

/**
 * Created by diaoqf on 2018/10/22.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainListAdapterHolder> {

    private List<TaskBean> tasks;

    public MainListAdapter(List<TaskBean> tasks) {
        this.tasks = tasks;
    }

    @Override
    public MainListAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_task, parent, false);
        MainListAdapterHolder holder = new MainListAdapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MainListAdapterHolder holder, int position) {
        if (!TextUtils.isEmpty(tasks.get(position).getSender())) {
            holder.sender.setText(tasks.get(position).getSender());
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class MainListAdapterHolder extends RecyclerView.ViewHolder {

        private TextView sender;

        public MainListAdapterHolder(View itemView) {
            super(itemView);
            sender = itemView.findViewById(R.id.sender);


        }
    }
}
