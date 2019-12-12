package com.bw.movie.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MyPBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/12/4
 *@Time:13:42
 *@Description:我的电影票
 **/
public class MyMoviePiaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<MyPBean.ResultBean> result;
    public MyMoviePiaoAdapter(Context context, List<MyPBean.ResultBean> result) {
        this.result=result;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_piao, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).piao_name.setText(result.get(position).getMovieName());
            ((ViewHolder1) holder).piao_ting_name.setText(result.get(position).getScreeningHall());
            ((ViewHolder1) holder).piao_zuowei.setText(result.get(position).getSeat());
            ((ViewHolder1) holder).piao_cinema_name.setText(result.get(position).getCinemaName());
            ((ViewHolder1) holder).piao_movie_time.setText(result.get(position).getBeginTime()+"-"+result.get(position).getEndTime());
            Date date = new Date(result.get(position).getCreateTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ((ViewHolder1) holder).piao_time.setText(simpleDateFormat.format(date));
            ((ViewHolder1) holder).piao_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = result.get(position).getId();
                    onItemPiaoClickListener.onItem(id);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView piao_name;
        private final TextView piao_zuowei;
        private final Button piao_btn;
        private final TextView piao_movie_time;
        private final TextView piao_time;
        private final TextView piao_ting_name;
        private final TextView piao_cinema_name;

        public ViewHolder1(View view) {
            super(view);
            piao_name = view.findViewById(R.id.piao_name);
            piao_zuowei = view.findViewById(R.id.piao_zuowei);
            piao_cinema_name = view.findViewById(R.id.piao_cinema_name);
            piao_ting_name = view.findViewById(R.id.piao_ting_name);
            piao_time = view.findViewById(R.id.piao_time);
            piao_movie_time = view.findViewById(R.id.piao_movie_time);
            piao_btn = view.findViewById(R.id.piao_btn);
        }
    }

    OnItemPiaoClickListener onItemPiaoClickListener;

    public void setOnItemPiaoClickListener(OnItemPiaoClickListener onItemPiaoClickListener){
        this.onItemPiaoClickListener=onItemPiaoClickListener;
    }

    public interface OnItemPiaoClickListener{
        void onItem(int recordId);
    }

}
