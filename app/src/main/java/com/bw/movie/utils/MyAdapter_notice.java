package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.XiangBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/*
 *@auther:王可欣
 *@Date: 2019/11/19
 *@Time:20:04
 *@Description:预告适配器
 **/
public class MyAdapter_notice extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<XiangBean.ResultBean.ShortFilmListBean> list;
    private Context context;

    public MyAdapter_notice(List<XiangBean.ResultBean.ShortFilmListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_notice, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder)holder).jc.setUp(list.get(position).getVideoUrl(),JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"");
            Glide.with(context).load(list.get(position).getImageUrl()).into(((MyHolder) holder).jc.thumbImageView);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        private JCVideoPlayerStandard jc;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            jc=itemView.findViewById(R.id.jc_notice);
        }
    }


}
