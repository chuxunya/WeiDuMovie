package com.bw.movie.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.PJYYBean;
import com.bw.movie.bean.YYPJBean;
import com.bw.movie.view.YyxiangqingActivity;
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
 *@Time:12:09
 *@Description:我的评论影院
 **/
public class RecyclerCxyyplAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<PJYYBean.ResultBean> list;
    private Context context;

    public RecyclerCxyyplAdapter(List<PJYYBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_item_cxyypl, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            Date date = new Date(list.get(position).getCommentTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ((MyViewHolder) holder).chayingpingTime.setText(simpleDateFormat.format(date));
            ((MyViewHolder) holder).chayingpingName.setText(list.get(position).getCinemaName());
            ((MyViewHolder) holder).chayingpingImg.setImageURI(list.get(position).getLogo());
            ((MyViewHolder) holder).chayingpingDizhi.setText(list.get(position).getAddress());
            ((MyViewHolder) holder).chayingpingPinglun.setText(list.get(position).getMyCommentContent());
            ((MyViewHolder) holder).line.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, YyxiangqingActivity.class);
                    intent.putExtra("cinemaId", list.get(position).getCinemaId());
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
        @BindView(R.id.chayingping_img)
        SimpleDraweeView chayingpingImg;
        @BindView(R.id.chayingping_name)
        TextView chayingpingName;
        @BindView(R.id.chayingping_dizhi)
        TextView chayingpingDizhi;
        @BindView(R.id.chayingping_juli)
        TextView chayingpingJuli;
        @BindView(R.id.chayingping_pinglun)
        TextView chayingpingPinglun;
        @BindView(R.id.chayingping_time)
        TextView chayingpingTime;
        @BindView(R.id.line)
        LinearLayout line;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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
