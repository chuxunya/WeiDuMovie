package com.bw.movie.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.presenter.HomePresenter;
import com.bw.mvp.base.BaseFragment;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * @describe(描述)：FragMy
 * @data（日期）: 2019/11/11
 * @time（时间）: 21:23
 * @author（作者）: xin
 **/
public class FragMy extends BaseFragment<HomePresenter> {

    @BindView(R.id.message)
    ImageView message;
    @BindView(R.id.head)
    ImageView head;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.zhankai)
    ImageView zhankai;
    @BindView(R.id.rela)
    RelativeLayout rela;
    @BindView(R.id.more_piao)
    ImageView morePiao;
    @BindView(R.id.myguan)
    RelativeLayout myguan;
    @BindView(R.id.myyu)
    RelativeLayout myyu;
    @BindView(R.id.mybuy)
    RelativeLayout mybuy;
    @BindView(R.id.over)
    RelativeLayout over;
    @BindView(R.id.myping)
    RelativeLayout myping;
    @BindView(R.id.yijian)
    RelativeLayout yijian;
    @BindView(R.id.setting)
    RelativeLayout setting;
    @BindView(R.id.piao)
    RelativeLayout piao;
    private SharedPreferences movie;
    private String img;
    private SharedPreferences.Editor edit;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_my;
    }


    @Override
    protected void initView() {
        super.initView();
        movie = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        edit = movie.edit();
        img = movie.getString("img", null);
        if (img!=null){
            Glide.with(getContext()).load(img).circleCrop().into(head);
        }
        String name = movie.getString("name", null);
        if (name!=null){
            username.setText(name);
        }
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intent, 300);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SheZhiActivity.class);
                startActivityForResult(intent,555);
            }
        });
        mybuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReCordActivity.class);
                startActivity(intent);
            }
        });
        myguan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyGuanZhuActivity.class);
                startActivity(intent);
            }
        });
        myping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CxplActivity.class);
                startActivity(intent);
            }
        });
        piao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoViePiaoActivity.class);
                startActivity(intent);
            }
        });
        over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HistoryMovieActivity.class);
                startActivity(intent);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EmailMessageActivity.class);
                startActivity(intent);
            }
        });
        rela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyActivity.class);
                startActivityForResult(intent,222);
            }
        });
        yijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FanKuiActivity.class);
                startActivity(intent);
            }
        });
        myyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YuYueActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==222&&resultCode==123){
            img = data.getStringExtra("img");
            Glide.with(getContext()).load(img).circleCrop().into(head);
            edit.putString("img",img).commit();
        }
        if (requestCode==555&&resultCode==545){
            img = R.drawable.icontest+"";
            edit.putString("img",img).commit();
            username.setText("电影故事");
        }
    }
}
