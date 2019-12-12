package com.bw.movie.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.FKBean;
import com.bw.movie.bean.HeadBean;
import com.bw.movie.bean.LookedBean;
import com.bw.movie.bean.MyBean;
import com.bw.movie.bean.MyPBean;
import com.bw.movie.bean.MyYuBean;
import com.bw.movie.bean.PJBean;
import com.bw.movie.bean.PJYYBean;
import com.bw.movie.bean.PiaoBean;
import com.bw.movie.bean.PwdBean;
import com.bw.movie.bean.SearchYYBean;
import com.bw.movie.bean.XTBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.contract.IContract3;
import com.bw.movie.presenter.HomePresenter3;
import com.bw.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
/**
 *@describe(描述)：FanKuiActivity
 *@data（日期）: 2019/12/7
 *@time（时间）: 13:48
 *@author（作者）: xin
 **/
public class FanKuiActivity extends BaseActivity<HomePresenter3> implements IContract3.IView {

    private static final String TAG = "FanKuiActivity";
    @BindView(R.id.img_back_pinglun)
    ImageView imgBackPinglun;
    @BindView(R.id.et_fankui)
    EditText etFankui;
    @BindView(R.id.bt_fankui_tijiao)
    Button btFankuiTijiao;
    @BindView(R.id.relative_one)
    RelativeLayout relativeOne;
    @BindView(R.id.relative_fankui)
    RelativeLayout relativeFankui;
    private String sessionId;
    private int userId;
    private SharedPreferences sp;

    @Override
    protected HomePresenter3 providePresenter() {
        return new HomePresenter3();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_fan_kui;
    }

    @Override
    protected void initView() {
        super.initView();
        relativeFankui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeFankui.setVisibility(View.GONE);
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
    }

    @Override
    public void onMPJSuccess(PJBean pjBean) {

    }

    @Override
    public void onMPJFailure(Throwable e) {

    }

    @Override
    public void onCPJSuccess(PJYYBean pjyyBean) {

    }

    @Override
    public void onCPJFailure(Throwable e) {

    }

    @Override
    public void onPiaoSuccess(PiaoBean piaoBean) {

    }

    @Override
    public void onPiaoFailure(Throwable e) {

    }

    @Override
    public void onMyPiaoSuccess(MyPBean myPBean) {

    }

    @Override
    public void onMyPiaoFailure(Throwable e) {

    }

    @Override
    public void onLookedSuccess(LookedBean lookedBean) {

    }

    @Override
    public void onLookedFailure(Throwable e) {

    }

    @Override
    public void onXTXXSuccess(XTBean xtBean) {

    }

    @Override
    public void onXTXXFailure(Throwable e) {

    }

    @Override
    public void onMySuccess(MyBean myBean) {

    }

    @Override
    public void onMyFailure(Throwable e) {

    }

    @Override
    public void onHeadSuccess(HeadBean headBean) {

    }

    @Override
    public void onHeadFailure(Throwable e) {

    }

    @Override
    public void onBirthSuccess(BirthBean birthBean) {

    }

    @Override
    public void onBirthFailure(Throwable e) {

    }

    @Override
    public void onFKSuccess(FKBean fkBean) {
        Log.d(TAG, "onFKSuccess: "+fkBean );
        if (fkBean.equals("0000")){
            Toast.makeText(this,fkBean.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFKFailure(Throwable e) {
        Log.d(TAG, "onFKFailure: "+e.getMessage().toString());
    }

    @Override
    public void onMyYuSuccess(MyYuBean myYuBean) {

    }

    @Override
    public void onMyYuFailure(Throwable e) {

    }

    @Override
    public void onPWDSuccess(PwdBean pwdBean) {

    }

    @Override
    public void onPWDFailure(Throwable e) {

    }

    @Override
    public void onYYSSSuccess(SearchYYBean searchYYBean) {

    }

    @Override
    public void onYYSSFailure(Throwable e) {

    }

    @OnClick({R.id.img_back_pinglun, R.id.bt_fankui_tijiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_pinglun:
                finish();
                break;
            case R.id.bt_fankui_tijiao:
                String content = btFankuiTijiao.getText().toString();
                if (!content.isEmpty()){
                    mPresenter.getFKP(userId,sessionId,content);
                    relativeFankui.setVisibility(View.VISIBLE);
                    relativeOne.setVisibility(View.GONE);
                }else {
                    Toast.makeText(this,"输入不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
