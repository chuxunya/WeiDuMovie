package com.bw.movie.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.LookedBean;
import com.bw.movie.view.YYPLActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/12/4
 *@Time:19:47
 *@Description:看过的电影
 **/
public class MyHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<LookedBean.ResultBean> result;
    public MyHistoryAdapter(Context context, List<LookedBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_movie, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {

            ((ViewHolder1) holder).kanguo_name.setText(result.get(position).getMovieName());
            Date date = new Date(result.get(position).getBeginTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ((ViewHolder1) holder).kanguo_time.setText(simpleDateFormat.format(date)+"观影");
            Uri parse = Uri.parse(result.get(position).getImageUrl());
            ((ViewHolder1) holder).kanguo_img.setImageURI(parse);
            ((ViewHolder1) holder).kanguo_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, YYPLActivity.class);
                    intent.putExtra("cinemaId",result.get(position).getCinemaId());
                    intent.putExtra("movieId",result.get(position).getMovieId());
                    context.startActivity(intent);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView kanguo_img;
        private final Button kanguo_btn;
        private final TextView kanguo_time;
        private final TextView kanguo_name;

        public ViewHolder1(View view) {
            super(view);
            kanguo_img = view.findViewById(R.id.kanguo_img);
            kanguo_name = view.findViewById(R.id.kanguo_name);
            kanguo_time = view.findViewById(R.id.kanguo_time);
            kanguo_btn = view.findViewById(R.id.kanguo_btn);
        }
    }
}
