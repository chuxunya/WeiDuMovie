package com.bw.movie.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.GCinemaBeam;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/12/3
 *@Time:9:40
 *@Description:关注的影院适配器
 **/
public class MyYingYuanGuanZhuAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GCinemaBeam.ResultBean> list;
    private Context context;

    public MyYingYuanGuanZhuAdapter(List<GCinemaBeam.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.yingyaun_show_gz, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getLogo());
            ((MyViewHolder) holder).text_name.setText(list.get(position).getName());
            ((MyViewHolder) holder).text_address.setText(list.get(position).getAddress());
            ((MyViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onclick(list.get(position).getCinemaId());
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
        private final TextView delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.image_more_gzyy);
            text_name=itemView.findViewById(R.id.text_show_more_gzyy);
            text_address=itemView.findViewById(R.id.text_show_2_more_gzyy);
            delete=itemView.findViewById(R.id.guan_tv_delete);
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
