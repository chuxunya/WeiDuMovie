package com.bw.movie.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.XTBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/12/5
 *@Time:20:46
 *@Description:系统信息
 **/
public class EmailMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<XTBean.ResultBean> list;
    private Context context;

    public EmailMessageAdapter(List<XTBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.email_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            ((MyViewHolder) holder).text_name.setText(list.get(position).getTitle());
            Date date =new Date(list.get(position).getPushTime());
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日mm分ss秒");
            ((MyViewHolder) holder).text_address.setText(format.format(date)+"");
            ((MyViewHolder) holder).textViewZY.setText(list.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView text_name;
        private final TextView text_address;
        private final TextView textViewZY;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_name=itemView.findViewById(R.id.text_message);
            text_address=itemView.findViewById(R.id.text_message2);
            textViewZY = itemView.findViewById(R.id.text_message3);

        }
    }

}
