package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.SchedulerBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/11/21
 *@Time:14:03
 *@Description:选择影厅适配器
 **/
public class MyAdapter_Seat extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<SchedulerBean.ResultBean> list;
    private Context context;

    public MyAdapter_Seat(List<SchedulerBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_seat, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder)holder).yingting.setText(list.get(position).getScreeningHall());
            ((MyHolder)holder).start.setText(list.get(position).getBeginTime());
            ((MyHolder)holder).end.setText(list.get(position).getEndTime());
            ((MyHolder)holder).seat_rela.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onclickListener.onclick(list.get(position).getHallId(),list.get(position).getFare(),list.get(position).getId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private RelativeLayout seat_rela;
        private TextView yingting,start,end;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            seat_rela=itemView.findViewById(R.id.seat_rela);
            yingting=itemView.findViewById(R.id.yingting);
            start=itemView.findViewById(R.id.start);
            end=itemView.findViewById(R.id.end);
        }
    }

    OnclickListener onclickListener;

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

    public interface OnclickListener{
        void onclick(int hallId,double fare,int id);
    }
}
