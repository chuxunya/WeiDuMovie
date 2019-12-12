package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.XiangBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/11/19
 *@Time:19:31
 *@Description:演员适配器
 **/
public class MyRecyAdapter_actor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<XiangBean.ResultBean.MovieActorBean> list;
    private Context context;

    public MyRecyAdapter_actor(List<XiangBean.ResultBean.MovieActorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_actor, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder)holder).actor_item.setImageURI(list.get(position).getPhoto());
            ((MyHolder)holder).actor_name.setText(list.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView actor_item;
        private TextView actor_name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            actor_item=itemView.findViewById(R.id.actor_item);
            actor_name=itemView.findViewById(R.id.direc_name_itme);
        }
    }
}
