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
import com.bw.movie.bean.NowReBean;
import com.bw.movie.view.ChooseCinemaActivity;
import com.bw.movie.view.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
/**
 *@describe(描述)：MyYingAdapter
 *@data（日期）: 2019/11/15
 *@time（时间）: 19:33
 *@author（作者）: xin
 **/
public class MyYingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NowReBean.ResultBean> list;
    private Context context;
    private View inflate;

    public MyYingAdapter(List<NowReBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(context).inflate(R.layout.ying_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof  MyViewHolder){
                ((MyViewHolder) holder).textView.setText(list.get(position).getName());
                ((MyViewHolder) holder).imageView.setImageURI(list.get(position).getImageUrl());
                ((MyViewHolder) holder).ping.setText(list.get(position).getScore()+"分");
                ((MyViewHolder) holder).ying_lin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, XiangActivity.class);
                        intent.putExtra("movieId",list.get(position).getMovieId());
                        context.startActivity(intent);
                    }
                });
                ((MyViewHolder) holder).rm_gp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ChooseCinemaActivity.class);
                        int movieId = list.get(position).getMovieId();
                        intent.putExtra("movieId",movieId);
                        context.startActivity(intent);
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView imageView;
        private final TextView textView,ping;
        private final RelativeLayout ying_lin;
        private final Button rm_gp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_ying);
            textView = itemView.findViewById(R.id.text_name_ying);
            ping=itemView.findViewById(R.id.ping);
            ying_lin=itemView.findViewById(R.id.ying_lin);
            rm_gp = itemView.findViewById(R.id.rm_gp);
        }
    }

    //图片点击事件接口回调
    setChangeClick setChangeClick;

    public void setSetChangeClick(setChangeClick setChangeClick) {
        this.setChangeClick = setChangeClick;
    }

    public interface setChangeClick {
        void click(int movieid);
    }

}
