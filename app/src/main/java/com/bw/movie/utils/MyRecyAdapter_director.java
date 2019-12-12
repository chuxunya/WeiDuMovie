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
 *@Time:19:08
 *@Description:导演适配器
 **/
public class MyRecyAdapter_director extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<XiangBean.ResultBean.MovieDirectorBean> list;
    private Context context;

    public MyRecyAdapter_director(List<XiangBean.ResultBean.MovieDirectorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_director, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder)holder).dire_item.setImageURI(list.get(position).getPhoto());
            ((MyHolder)holder).name_direc.setText(list.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView dire_item;
        private TextView name_direc;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            dire_item=itemView.findViewById(R.id.dire_item);
            name_direc=itemView.findViewById(R.id.direc_name_itme);
        }
    }
}
