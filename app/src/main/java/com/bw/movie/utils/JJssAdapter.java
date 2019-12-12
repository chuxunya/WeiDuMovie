package com.bw.movie.utils;
/**
 *@describe(描述)：JJssAdapter
 *@data（日期）: 2019/12/5
 *@time（时间）: 18:59
 *@author（作者）: xin
 **/
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
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

public class JJssAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<JiUpBean.ResultBean>list;
    private Context context;

    public JJssAdapter(List<JiUpBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.jjss_show, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyViewHolder){
                int whetherReserve = list.get(position).getWhetherReserve();
                if (whetherReserve==1){
                    //已预约
                    ((MyViewHolder) holder).butt_show.setVisibility(View.GONE);
                    ((MyViewHolder) holder).butt_show2.setVisibility(View.VISIBLE);
                }
                ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getImageUrl());
              ((MyViewHolder) holder).text_name.setText(list.get(position).getName());
                Date date = new Date(list.get(position).getReleaseTime());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                ((MyViewHolder) holder).text_address.setText(simpleDateFormat.format(date)+"上映");
                ((MyViewHolder) holder).textViewZY.setText(list.get(position).getWantSeeNum()+"想看");
                ((MyViewHolder) holder).jy_lin.setOnClickListener(new View.OnClickListener() {
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
                        onCliickLiistener.onclick(list.get(position).getMovieId());
                        /*((MyViewHolder) holder).butt_show.setVisibility(View.GONE);
                        ((MyViewHolder) holder).butt_show2.setVisibility(View.VISIBLE);*/
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
        private final RelativeLayout jy_lin;
        private final Button butt_show,butt_show2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.image_more_jjss);
            text_name=itemView.findViewById(R.id.text_show_more_jjss);
            text_address=itemView.findViewById(R.id.text_show_2_more_jjss);
            textViewZY = itemView.findViewById(R.id.text_show_3_more_jjss);
            jy_lin = itemView.findViewById(R.id.jy_lin);
            butt_show=itemView.findViewById(R.id.butt_show);
            butt_show2=itemView.findViewById(R.id.butt_show2);
        }
    }

    OnCliickLiistener onCliickLiistener;

    public void setOnCliickLiistener(OnCliickLiistener onCliickLiistener) {
        this.onCliickLiistener = onCliickLiistener;
    }

    public interface OnCliickLiistener{
        void onclick(int movieId);
    }
}
