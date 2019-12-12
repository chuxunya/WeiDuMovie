package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.bean.XiangBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/11/20
 *@Time:13:50
 *@Description:剧照适配器
 **/
public class myRecyAdapter_still extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<XiangBean.ResultBean> list;
    private Context context;
    private List<String> posterList;

    public myRecyAdapter_still(List<String> posterList, Context context) {
        this.posterList = posterList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_still, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder)holder).sim.setImageURI(posterList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return posterList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView sim;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            sim=itemView.findViewById(R.id.sim_still);
        }
    }
}
