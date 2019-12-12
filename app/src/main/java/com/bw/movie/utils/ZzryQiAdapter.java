package com.bw.movie.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.NowReBean;
import com.bw.movie.view.ChooseCinemaActivity;
import com.bw.movie.view.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/12/4
 *@Time:21:10
 *@Description:正在热映更多适配器
 **/
public class ZzryQiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NowReBean.ResultBean> list;
    private Context context;

    public ZzryQiAdapter(List<NowReBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.zzry_show, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getImageUrl());
            ((MyViewHolder) holder).text_name.setText(list.get(position).getName());
            ((MyViewHolder) holder).text_address.setText("导演："+list.get(position).getDirector().trim());
            ((MyViewHolder) holder).textViewZY.setText("主演:"+list.get(position).getStarring());
            ((MyViewHolder) holder).textViewPF.setText("评分："+list.get(position).getScore()+"分");
            ((MyViewHolder) holder).line.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, XiangActivity.class);
                    intent.putExtra("movieId",list.get(position).getMovieId());
                    context.startActivity(intent);
                }
            });
            ((MyViewHolder) holder).butt_show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChooseCinemaActivity.class);
                    intent.putExtra("movieId",list.get(position).getMovieId());
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
        private final SimpleDraweeView simpleDraweeView;
        private final TextView text_name;
        private final TextView text_address;
        private final TextView textViewZY;
        private final TextView textViewPF;
        private final LinearLayout line;
        private final Button butt_show;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.image_more);
            text_name=itemView.findViewById(R.id.text_show_more);
            text_address=itemView.findViewById(R.id.text_show_2_more);
            textViewZY = itemView.findViewById(R.id.text_show_3_more);
            textViewPF = itemView.findViewById(R.id.text_show_4_more);
            line=itemView.findViewById(R.id.line);
            butt_show=itemView.findViewById(R.id.butt_show);
        }
    }
}
