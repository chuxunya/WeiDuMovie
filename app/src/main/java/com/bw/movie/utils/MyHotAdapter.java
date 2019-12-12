package com.bw.movie.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.RemenBean;
import com.bw.movie.view.ChooseCinemaActivity;
import com.bw.movie.view.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
/**
 *@describe(描述)：MyHotAdapter
 *@data（日期）: 2019/11/15
 *@time（时间）: 19:36
 *@author（作者）: xin
 **/
public class MyHotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<RemenBean.ResultBean> list;
    private Context context;
    private View inflate;

    public MyHotAdapter(List<RemenBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(context).inflate(R.layout.hot_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof  MyViewHolder){
                ((MyViewHolder) holder).textView.setText(list.get(position+1).getName());
                ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position+1).getImageUrl());
                ((MyViewHolder) holder).score_reitem.setText(list.get(position+1).getScore()+"分");
                ((MyViewHolder) holder).hot_lin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, XiangActivity.class);
                        intent.putExtra("movieId",list.get(position+1).getMovieId());
                        context.startActivity(intent);
                    }
                });
                ((MyViewHolder) holder).rm_gp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ChooseCinemaActivity.class);
                        int movieId = list.get(position+1).getMovieId();
                        intent.putExtra("movieId",movieId);
                        context.startActivity(intent);
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return list.size()-1;
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;
        private final TextView textView,score_reitem;
        private final RelativeLayout hot_lin;
        private final Button rm_gp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.image_ying);
            textView = itemView.findViewById(R.id.text_name_ying);
            score_reitem=itemView.findViewById(R.id.score_reitem);
            hot_lin=itemView.findViewById(R.id.hot_lin);
            rm_gp=itemView.findViewById(R.id.rm_gp);
        }
    }
}
