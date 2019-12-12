package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.TuiBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
/**
 *@describe(描述)：MyShopAdapter
 *@data（日期）: 2019/11/14
 *@time（时间）: 20:52
 *@author（作者）: xin
 **/
public class MyShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TuiBean.ResultBean> list;
    private Context context;
    private View inflate;

    public MyShopAdapter(List<TuiBean.ResultBean> list, Context context) {
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
            ((MyViewHolder) holder).rela.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickListener.onclick(list.get(position).getId());
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
        private RelativeLayout rela;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.image_view_tj);
            textViewName = itemView.findViewById(R.id.text_name_tj);
            textViewAddress = itemView.findViewById(R.id.text_address_tj);
            rela=itemView.findViewById(R.id.rela_tj);
        }
    }

    OnclickListener onclickListener;

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

    public interface OnclickListener{
        void onclick(int cinemaId);
    }
}
