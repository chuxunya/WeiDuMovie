package com.bw.movie.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.mvp.base.BaseActivity;
import com.bw.mvp.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @describe(描述)：我的
 * @data（日期）: 2019/11/28
 * @time（时间）: 10:15
 * @author（作者）: xin
 **/
public class Mine2Activity extends BaseActivity {

    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mine2;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        String a = intent.getStringExtra("a");
        if (a.contains("1")) {
            textView.setVisibility(View.VISIBLE);
        }else {
            textView.setVisibility(View.INVISIBLE);

        }
        detailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(200);
                finish();
            }
        });
    }
}
