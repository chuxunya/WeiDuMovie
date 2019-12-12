package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.mvp.base.BaseActivity;
import com.bw.mvp.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：设置
 * @data（日期）: 2019/12/7
 * @time（时间）: 12:46
 * @author（作者）: xin
 **/
public class SheZhiActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.mysetting_clear)
    TextView mysettingClear;
    @BindView(R.id.mysetting_number)
    TextView mysettingNumber;
    @BindView(R.id.shezhi_qingchu)
    LinearLayout shezhiQingchu;
    @BindView(R.id.shezhi_gengxin)
    LinearLayout shezhiGengxin;
    @BindView(R.id.shezhi_chongzhipassword)
    LinearLayout shezhiChongzhipassword;
    @BindView(R.id.shezhi_button)
    Button shezhiButton;
    private SharedPreferences sp;
    private SharedPreferences sps;
    private SharedPreferences spss;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_she_zhi;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("movie", MODE_PRIVATE);
        sps = getSharedPreferences("position", MODE_PRIVATE);
        spss = getSharedPreferences("xin", MODE_PRIVATE);
    }

    @OnClick({R.id.back, R.id.shezhi_qingchu, R.id.shezhi_gengxin, R.id.shezhi_chongzhipassword, R.id.shezhi_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.shezhi_qingchu:
                mysettingNumber.setText(0+"m");
                Toast.makeText(this,"清除成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.shezhi_gengxin:
                startActivity(new Intent(SheZhiActivity.this, UpDataActivity.class));
                break;
            case R.id.shezhi_chongzhipassword:
                Intent intent = new Intent(SheZhiActivity.this,PasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.shezhi_button:
                sp.edit().clear().commit();
                sps.edit().clear().commit();
                spss.edit().clear().commit();
                Toast.makeText(this,"退出成功",Toast.LENGTH_SHORT).show();
                setResult(545);
                finish();
                break;
        }
    }
}
