package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.bean.SeatBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/11/21
 *@Time:15:04
 *@Description:选择座位
 **/
public class Myadapter_Seat_Choose extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<SeatBean.ResultBean> list;
    private Context context;

    public Myadapter_Seat_Choose(List<SeatBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_seat_choose, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            String row = list.get(position).getRow();
            String seat = list.get(position).getSeat();
            int status = list.get(position).getStatus();

            if (status==1){
                ((MyHolder) holder).zuo_che.setChecked(false);
                ((MyHolder) holder).zuo_che.setVisibility(View.VISIBLE);
                ((MyHolder) holder).zuo_che2.setVisibility(View.INVISIBLE);
            }else if(status==2){
                ((MyHolder) holder).zuo_che2.setVisibility(View.VISIBLE);
                ((MyHolder) holder).zuo_che.setEnabled(false);
                ((MyHolder) holder).zuo_che.setVisibility(View.INVISIBLE);
            }
            ((MyHolder) holder).zuo_che.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    onclickListener.onclick(row,seat,b);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private CheckBox zuo_che,zuo_che2;
        private RelativeLayout relay_choose_seat;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            zuo_che = itemView.findViewById(R.id.zuo_che);
            zuo_che2=itemView.findViewById(R.id.zuo_che2);
            relay_choose_seat=itemView.findViewById(R.id.relay_choose_seat);
        }
    }

    OnclickListener onclickListener;

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

    public interface OnclickListener{
        void onclick(String row,String seat,boolean ischecked);
    }
}
