package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.PingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/11/20
 *@Time:14:53
 *@Description:影评
 **/
public class MyAdapter_yp extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PingBean.ResultBean> list;
    private Context context;

    public MyAdapter_yp(List<PingBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_yp, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder)holder).head.setImageURI(list.get(position).getCommentHeadPic());
            ((MyHolder)holder).name.setText(list.get(position).getCommentUserName());
            ((MyHolder)holder).score.setText(list.get(position).getScore()+"分");
            long time = list.get(position).getCommentTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
            String format = simpleDateFormat.format(time);
            ((MyHolder)holder).time.setText(format);
            ((MyHolder)holder).ping.setText(list.get(position).getCommentContent());
            ((MyHolder)holder).zan.setText(list.get(position).getGreatNum()+"");
            ((MyHolder)holder).fu.setText(list.get(position).getReplyNum()+"w+人进行了回复");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView name,score,time,ping,zan,fu;
        private ImageView zan_ping;
        private SimpleDraweeView head;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_ping);
            score=itemView.findViewById(R.id.score_ping);
            time=itemView.findViewById(R.id.time_ping);
            ping=itemView.findViewById(R.id.ping);
            zan=itemView.findViewById(R.id.zan_num_ping);
            zan_ping=itemView.findViewById(R.id.zan_ping);
            fu=itemView.findViewById(R.id.fu_num);
            head=itemView.findViewById(R.id.head_ping);
        }
    }
}
