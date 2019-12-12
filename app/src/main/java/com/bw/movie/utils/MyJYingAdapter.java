package com.bw.movie.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.JiUpBean;
import com.bw.movie.view.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 *@describe(描述)：MyJYingAdapter
 *@data（日期）: 2019/11/15
 *@time（时间）: 19:35
 *@author（作者）: xin
 **/
public class MyJYingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<JiUpBean.ResultBean> list;
    private Context context;
    private View inflate;

    public MyJYingAdapter(List<JiUpBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(context).inflate(R.layout.ji_ying_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof  MyViewHolder){
                int whetherReserve = list.get(position).getWhetherReserve();
                if (whetherReserve==1){
                    ((MyViewHolder) holder).btn.setVisibility(View.GONE);
                    ((MyViewHolder) holder).btn1.setVisibility(View.VISIBLE);
                }
                ((MyViewHolder) holder).textView.setText(list.get(position).getName());
                Date date = new Date(list.get(position).getReleaseTime());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                ((MyViewHolder) holder).textView1.setText(simpleDateFormat.format(date)+"上映");
                ((MyViewHolder) holder).textView2.setText(list.get(position).getWantSeeNum()+"人想看");
                ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getImageUrl());
                int movieId = list.get(position).getMovieId();

                ((MyViewHolder) holder).jylin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, XiangActivity.class);
                        intent.putExtra("movieId",movieId);
                        context.startActivity(intent);
                    }
                });

                ((MyViewHolder) holder).btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.click(list.get(position).getMovieId());
                        Log.d("aaa", "onClick: "+movieId);
                        /*((MyViewHolder) holder).btn.setVisibility(View.GONE);
                        ((MyViewHolder) holder).btn1.setVisibility(View.VISIBLE);*/
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private View jylin;
        private final SimpleDraweeView simpleDraweeView;
        private final TextView textView;
        private final TextView textView1;
        private final TextView textView2;
        private final Button btn,btn1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.image_jijing);
            textView = itemView.findViewById(R.id.text_name);
            textView1 = itemView.findViewById(R.id.text_time);
            textView2 = itemView.findViewById(R.id.text_guankan);
            jylin=itemView.findViewById(R.id.jy_lin);
            btn=itemView.findViewById(R.id.yuy);
            btn1=itemView.findViewById(R.id.yuy2);
        }
    }

    //图片点击事件接口回调
    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void click(int movieId);
    }

}
