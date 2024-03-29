package com.bw.movie.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.YYPJBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/12/2
 *@Time:11:31
 *@Description:影院评价适配器
 **/
public class RecyclerYYYingPingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<YYPJBean.ResultBean> list;
    private Context context;

    public RecyclerYYYingPingAdapter(List<YYPJBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_yy_yingping, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).simpleDraweeView.setImageURI(list.get(position).getCommentHeadPic());
            ((MyViewHolder) holder).textView_name.setText(list.get(position).getCommentUserName());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
            String sd = sdf.format(new Date(list.get(position).getCommentTime())); // 时间戳转换成时间     (这里也是毫秒时间戳)
            ((MyViewHolder) holder).textView_time.setText(sd);
            ((MyViewHolder) holder).textView_yp.setText(list.get(position).getCommentContent());
            ((MyViewHolder) holder).textView_dianzan.setText(list.get(position).getCommentUserId() + "");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView simpleDraweeView;
        private final TextView textView_name;
        private final TextView textView_pf;
        private final TextView textView_time;
        private final TextView textView_yp;
        private final TextView textView_dianzan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simp_xiangqing_yingping_1);
            textView_name = itemView.findViewById(R.id.text_yingping_name);
            textView_pf = itemView.findViewById(R.id.text_yingping_fen);
            textView_time = itemView.findViewById(R.id.text_yingping_time);
            textView_yp = itemView.findViewById(R.id.text_yingping_yp);
            textView_dianzan = itemView.findViewById(R.id.text_dianzan);
        }
    }
}