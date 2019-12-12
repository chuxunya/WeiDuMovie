package com.bw.movie.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.SearchYYBean;
import com.bw.movie.view.YyxiangqingActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王可欣
 *@Date: 2019/12/8
 *@Time:19:05
 *@Description:影院搜索适配器
 **/
public class SouSuoYYAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<SearchYYBean.ResultBean> list;
    private View inflate;


    public SouSuoYYAdapter(Context context, List<SearchYYBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = View.inflate(context, R.layout.sousuo_recy_layout, null);
        return new MyList(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyList) {
            ((MyList) viewHolder).simpleDraweeView.setImageURI(list.get(i).getLogo());
            ((MyList) viewHolder).name.setText(list.get(i).getName());
            ((MyList) viewHolder).yanyuan.setText(list.get(i).getAddress());
            ((MyList)viewHolder).btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, YyxiangqingActivity.class);
                    intent.putExtra("cinemaId",list.get(i).getId());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyList extends RecyclerView.ViewHolder {


        private final SimpleDraweeView simpleDraweeView;
        private final TextView name;
        private final TextView yanyuan;
        private final LinearLayout btn;

        public MyList(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.img_sousuo);
            name = itemView.findViewById(R.id.sousuo_name);
            yanyuan = itemView.findViewById(R.id.sousuo_yanyuan);
            btn = itemView.findViewById(R.id.line);
        }
    }

}
