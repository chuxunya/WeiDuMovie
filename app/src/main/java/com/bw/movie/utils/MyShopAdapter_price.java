package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.Price_Cinema_Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 *@describe(描述)：MyShopAdapter
 *@data（日期）: 2019/11/14
 *@time（时间）: 20:52
 *@author（作者）: xin
 **/
public class MyShopAdapter_price extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Price_Cinema_Bean.ResultBean> list;
    private Context context;
    private View inflate;

    public MyShopAdapter_price(List<Price_Cinema_Bean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        inflate = LayoutInflater.from(context).inflate(R.layout.tj_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            ((MyViewHolder) holder).textViewName.setText(list.get(position).getName());
            ((MyViewHolder) holder).textViewAddress.setText(list.get(position).getAddress());
            ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getLogo());
            ((MyViewHolder) holder).rela_tj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onclick(list.get(position).getCinemaId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView simpleDraweeView;
        private final TextView textViewName;
        private final TextView textViewAddress;
        private final RelativeLayout rela_tj;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.image_view_tj);
            textViewName = itemView.findViewById(R.id.text_name_tj);
            textViewAddress = itemView.findViewById(R.id.text_address_tj);
            rela_tj= itemView.findViewById(R.id.rela_tj);
        }
    }

    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onclick(int cinemaId);
    }
}
