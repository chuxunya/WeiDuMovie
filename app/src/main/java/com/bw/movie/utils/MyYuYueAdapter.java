package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MyYuBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/12/6
 *@Time:21:44
 *@Description:我的预约
 **/
/*jjss_show.xml*/
public class MyYuYueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<MyYuBean.ResultBean> result;
    public MyYuYueAdapter(Context context, List<MyYuBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jjss_show, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).tv_name.setText(result.get(position).getName());
            Date date = new Date(result.get(position).getReleaseTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd");
            ((ViewHolder1) holder).tv_data.setText(simpleDateFormat.format(date)+"上映");
            int wantSeeNum = result.get(position).getWantSeeNum();
            ((ViewHolder1) holder).tv_look.setText(wantSeeNum+"人想看");
            ((ViewHolder1) holder).img_bi.setImageURI(result.get(position).getImageUrl());
            ((ViewHolder1) holder).btn.setVisibility(View.GONE);
            ((ViewHolder1) holder).linear_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int movieId = result.get(position).getMovieId();
                    onItemClickListener.onItemClick(movieId);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        private final SimpleDraweeView img_bi;
        private final TextView tv_name;
        private final TextView tv_data;
        private final TextView tv_look;
        private final RelativeLayout linear_two;
        private final Button btn;
        public ViewHolder1(View view) {
            super(view);
            img_bi = view.findViewById(R.id.image_more_jjss);
            tv_name = view.findViewById(R.id.text_show_more_jjss);
            tv_data = view.findViewById(R.id.text_show_2_more_jjss);
            tv_look = view.findViewById(R.id.text_show_3_more_jjss);
            linear_two = view.findViewById(R.id.jy_lin);
            btn = view.findViewById(R.id.butt_show);
        }
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int id);
    }
}
