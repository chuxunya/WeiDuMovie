package com.bw.movie.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.GMovieBean;
import com.bw.movie.view.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/12/3
 *@Time:9:14
 *@Description:关注电影适配器
 **/
public class MyGuanZhuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GMovieBean.ResultBean> list;
    private Context context;

    public MyGuanZhuAdapter(List<GMovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.movie_show_gz, null);
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
            ((MyViewHolder) holder).rela.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, XiangActivity.class);
                    intent.putExtra("movieId",list.get(position).getMovieId());
                    context.startActivity(intent);
                }
            });
            ((MyViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onclick(list.get(position).getMovieId());
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
        private final RelativeLayout rela;
        private final TextView delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.image_more_gz);
            text_name=itemView.findViewById(R.id.text_show_more_gz);
            text_address=itemView.findViewById(R.id.text_show_2_more_gz);
            textViewZY = itemView.findViewById(R.id.text_show_3_more_gz);
            textViewPF = itemView.findViewById(R.id.text_show_4_more_gz);
            rela = itemView.findViewById(R.id.linear_guan_movie);
            delete = itemView.findViewById(R.id.guan_tv_delete);
        }
    }

    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onclick(int id);
    }
}
