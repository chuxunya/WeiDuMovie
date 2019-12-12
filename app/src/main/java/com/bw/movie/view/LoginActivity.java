package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.app.MainApplication;
import com.bw.movie.bean.AreaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Choose_day_bean;
import com.bw.movie.bean.Choose_qy_Bean;
import com.bw.movie.bean.CinemaBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.DayBean;
import com.bw.movie.bean.FuBean;
import com.bw.movie.bean.GZCBean;
import com.bw.movie.bean.GZMBean;
import com.bw.movie.bean.JiUpBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.NowReBean;
import com.bw.movie.bean.Price_Cinema_Bean;
import com.bw.movie.bean.QGZCBean;
import com.bw.movie.bean.QGZMBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.RemenBean;
import com.bw.movie.bean.TuiBean;
import com.bw.movie.bean.WXBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.YYBean;
import com.bw.movie.contract.IContract;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.utils.EncryptUtil;
import com.bw.movie.utils.SendAuth;
import com.bw.mvp.base.BaseActivity;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：LoginActivity
 * @data（日期）: 2019/11/11
 * @time（时间）: 21:23
 * @author（作者）: xin
 **/
public class LoginActivity extends BaseActivity<HomePresenter> implements IContract.IView {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.line)
    LinearLayout line;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.forget)
    Button forget;
    @BindView(R.id.relay)
    LinearLayout relay;
    @BindView(R.id.reg_text)
    TextView regText;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.wxlogin)
    Button wxlogin;
    private String myemail;
    private String pass;

    //邮箱正则验证
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private SharedPreferences sp2;
    private SharedPreferences.Editor edit1;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        if (code!=null){
            Log.d(TAG, "initData: "+code);
            mPresenter.getWxP(code);
        }
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Log.d(TAG, "onLoginSuccess: " + loginBean.toString());
        if (loginBean.getStatus().contains("0000")) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            edit.putString("email", myemail).commit();
            edit.putString("pwd", pass).commit();
            edit1 = sp2.edit();
            edit1.putInt("u", loginBean.getResult().getUserId());
            edit1.putString("s", loginBean.getResult().getSessionId());
            edit1.putString("img", loginBean.getResult().getUserInfo().getHeadPic());
            edit1.putString("name", loginBean.getResult().getUserInfo().getNickName());
            edit1.putString("email", loginBean.getResult().getUserInfo().getEmail());
            edit1.putInt("sex", loginBean.getResult().getUserInfo().getSex());
            edit1.commit();
            setResult(300);
            finish();
        }
        if (loginBean.getStatus().contains("1001")) {
            Toast.makeText(LoginActivity.this, "登陆失败,账号或密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoginFailure(Throwable e) {
        Log.d(TAG, "onLoginFailure: " + e.getMessage().toString());
    }

    @Override
    public void onResSuccess(RegisterBean registerBean) {

    }

    @Override
    public void onResFailure(Throwable e) {

    }

    @Override
    public void onCodeSuccess(CodeBean codeBean) {

    }

    @Override
    public void onCodeFailure(Throwable e) {

    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {

    }

    @Override
    public void onBannerFailure(Throwable e) {

    }

    @Override
    public void onNowSuccess(NowReBean nowReBean) {

    }

    @Override
    public void onNowFailure(Throwable e) {

    }

    @Override
    public void onUpSuccess(JiUpBean jiUpBean) {

    }

    @Override
    public void onUpFailure(Throwable e) {

    }

    @Override
    public void onRemenSuccess(RemenBean remenBean) {

    }

    @Override
    public void onRemenFailure(Throwable e) {

    }

    @Override
    public void onAreaSuccess(AreaBean areaBean) {

    }

    @Override
    public void onAreaFailure(Throwable e) {

    }

    @Override
    public void onCinemaByRegionSuccess(CinemaBean cinemaBean) {

    }

    @Override
    public void onCinemaByRegionFailure(Throwable e) {

    }

    @Override
    public void onTuiCinemaSuccess(TuiBean tuiBean) {

    }

    @Override
    public void onTuiCinemaFailure(Throwable e) {

    }

    @Override
    public void onFuCinemaSuccess(FuBean fuBean) {

    }

    @Override
    public void onFuCinemaFailure(Throwable e) {

    }

    @Override
    public void onXiangSuccess(XiangBean xiangBean) {

    }

    @Override
    public void onXiangFailure(Throwable e) {

    }

    @Override
    public void onQYSuccess(Choose_qy_Bean choose_qy_bean) {

    }

    @Override
    public void onQYFailure(Throwable e) {

    }

    @Override
    public void onDaySuccess(DayBean dayBean) {

    }

    @Override
    public void onDayFailure(Throwable e) {

    }

    @Override
    public void onDSuccess(Choose_day_bean dayBean) {

    }

    @Override
    public void onDFailure(Throwable e) {

    }

    @Override
    public void onPriceSuccess(Price_Cinema_Bean price_cinema_bean) {

    }

    @Override
    public void onPriceFailure(Throwable e) {

    }

    @Override
    public void onWXSuccess(WXBean wxBean) {
        Log.d(TAG, "onWXSuccess: "+wxBean);
        if (wxBean.getStatus().contains("0000")) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            edit.putString("email", myemail).commit();
            edit.putString("pwd", pass).commit();
            edit1 = sp2.edit();
            edit1.putInt("u", wxBean.getResult().getUserId());
            edit1.putString("s", wxBean.getResult().getSessionId());
            edit1.putString("img", wxBean.getResult().getUserInfo().getHeadPic());
            edit1.putString("name", wxBean.getResult().getUserInfo().getNickName());
            edit1.putInt("sex", wxBean.getResult().getUserInfo().getSex());
            edit1.commit();
            setResult(300);
            finish();
            startActivity(new Intent(LoginActivity.this,MapActivity.class));
        }
        if (wxBean.getStatus().contains("1001")) {
            Toast.makeText(LoginActivity.this, "登陆失败,账号或密码错误", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onWXFailure(Throwable e) {
        Log.d(TAG, "onWXFailure: "+e.getMessage().toString());
    }

    @Override
    public void onGZMSuccess(GZMBean gzmBean) {

    }

    @Override
    public void onGZMFailure(Throwable e) {

    }

    @Override
    public void onQGZMSuccess(QGZMBean qgzmBean) {

    }

    @Override
    public void onQGZMFailure(Throwable e) {

    }

    @Override
    public void onYYSuccess(YYBean yyBean) {

    }

    @Override
    public void onYYFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        sp = getSharedPreferences("xin", MODE_PRIVATE);
        edit = sp.edit();
        email.setText(sp.getString("email", ""));
        pwd.setText(sp.getString("pwd", ""));
        sp2 = getSharedPreferences("movie", MODE_PRIVATE);
    }

    @OnClick({R.id.forget, R.id.reg_text, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget:
                break;
            case R.id.reg_text:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 200);
                break;
            case R.id.login:
                myemail = email.getText().toString();
                pass = pwd.getText().toString();
                if (!myemail.isEmpty() && !pass.isEmpty()) {
                    boolean email = isEmail(myemail);
                    if (email == false) {
                        Toast.makeText(this, "邮箱格式有误", Toast.LENGTH_SHORT).show();
                    } else {
                        String encrypt = EncryptUtil.encrypt(pass);
                        mPresenter.loginPresenter(myemail, encrypt);
                    }
                }
                break;
        }
    }

    //校验邮箱
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }


    @OnClick(R.id.wxlogin)
    public void onViewClicked() {
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        MainApplication.api.sendReq(req);
    }
}
