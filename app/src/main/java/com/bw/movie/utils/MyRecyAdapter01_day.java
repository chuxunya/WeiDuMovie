package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/11/13
 *@Time:21:21
 *@Description:影院地区recy适配器
 **/
public class MyRecyAdapter01_day extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private List<String> list;
    private Context context;

    public MyRecyAdapter01_day(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item01_qy, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder)holder).name.setText(list.get(position));
            ((MyHolder)holder).rela.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String day = list.get(position);
                    onClickListener2.click(day);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private RelativeLayout rela;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.areaname01);
            rela=itemView.findViewById(R.id.rela0_item01);
        }
    }

    onClickListener2 onClickListener2;

    public void setOnClickListener2(MyRecyAdapter01_day.onClickListener2 onClickListener2) {
        this.onClickListener2 = onClickListener2;
    }

    public interface onClickListener2{
        void click(String text);
    }
}
