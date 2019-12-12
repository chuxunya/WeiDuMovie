package com.bw.movie.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.PJBean;
import com.bw.movie.view.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:王可欣
 *@Date: 2019/12/4
 *@Time:11:55
 *@Description:我对电影的评价适配器
 **/
public class RecyclerCxdyplAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PJBean.ResultBean> list;
    private Context context;

    public RecyclerCxdyplAdapter(List<PJBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_item_cxdypl, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            Date date = new Date(list.get(position).getCommentTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ((MyViewHolder) holder).dianuingTime.setText(simpleDateFormat.format(date));
            ((MyViewHolder) holder).dianyingDaoyan.setText(list.get(position).getDirector());
            ((MyViewHolder) holder).dianyingImg.setImageURI(list.get(position).getImageUrl());
            ((MyViewHolder) holder).dianyingName.setText(list.get(position).getMovieName());
            ((MyViewHolder) holder).ratFilmcinecism.setRating((float) list.get(position).getMyCommentScore());
            ((MyViewHolder) holder).dianyingPingfen.setText(list.get(position).getMovieScore()+"");
            ((MyViewHolder) holder).dianyingZhuyan.setText(list.get(position).getStarring());
            ((MyViewHolder) holder).dingyingPinglun.setText(list.get(position).getMyCommentContent());
            ((MyViewHolder) holder).yingpingFenshu.setText("("+list.get(position).getMyCommentScore()+")");
            ((MyViewHolder) holder).line.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int movieId = list.get(position).getMovieId();
                    Intent intent = new Intent(context, XiangActivity.class);
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

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dianying_img)
        SimpleDraweeView dianyingImg;
        @BindView(R.id.dianying_name)
        TextView dianyingName;
        @BindView(R.id.dianying_daoyan)
        TextView dianyingDaoyan;
        @BindView(R.id.dianying_zhuyan)
        TextView dianyingZhuyan;
        @BindView(R.id.dianying_pingfen)
        TextView dianyingPingfen;
        @BindView(R.id.dingying_pinglun)
        TextView dingyingPinglun;
        @BindView(R.id.rat_filmcinecism)
        RatingBar ratFilmcinecism;
        @BindView(R.id.yingping_fenshu)
        TextView yingpingFenshu;
        @BindView(R.id.dianuing_time)
        TextView dianuingTime;
        @BindView(R.id.line)
        LinearLayout line;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private onClickCallBack onClickCallBack;

    public void getonClickCallBack(onClickCallBack onClickCallBack) {
        this.onClickCallBack = onClickCallBack;
    }
    public interface onClickCallBack {
        void getMovieId(int id);
    }
}
