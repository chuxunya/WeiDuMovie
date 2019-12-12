package com.bw.movie.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
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
import com.bw.mvp.base.BaseActivity;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@describe(描述)：RegisterActivity
 *@data（日期）: 2019/11/11
 *@time（时间）: 21:23
 *@author（作者）: xin
 **/
public class RegisterActivity extends BaseActivity<HomePresenter> implements IContract.IView {

    private static final String TAG = "RegisterActivity";
    @BindView(R.id.nickName)
    EditText nickName;
    @BindView(R.id.email_reg)
    EditText emailReg;
    @BindView(R.id.pwd_reg)
    EditText pwdReg;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.getcode)
    Button getcode;
    @BindView(R.id.login_text)
    TextView loginText;
    @BindView(R.id.register)
    Button register;
    private String name;
    private String email;
    private String pass;

    //邮箱正则验证
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private String code1;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void onLoginFailure(Throwable e) {

    }

    @Override
    public void onResSuccess(RegisterBean registerBean) {
        Log.d(TAG, "onResSuccess: " + registerBean.toString());
        if (registerBean.getStatus().contains("0000")){
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
            finish();
        }else {
            if (registerBean.getStatus().contains("1004")){
                Toast.makeText(this,"请输入正确的邮箱",Toast.LENGTH_SHORT).show();
            }else if (registerBean.getStatus().contains("1001")){
                Toast.makeText(this,"验证码已过期",Toast.LENGTH_SHORT).show();
            }else if (registerBean.getStatus().contains("1005")){
                Toast.makeText(this,"注册失败,邮箱已存在",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onResFailure(Throwable e) {
        Log.d(TAG, "onResFailure: " + e.getMessage().toString());
    }

    @Override
    public void onCodeSuccess(CodeBean codeBean) {
        Log.d(TAG, "onCodeSuccess: "+codeBean);
        if (codeBean.getStatus().contains("0000")){
            Toast.makeText(this,"发送成功",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCodeFailure(Throwable e) {
        Log.d(TAG, "onCodeFailure: "+e.getMessage().toString());
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

    }

    @Override
    public void onWXFailure(Throwable e) {

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
    }

    @OnClick({R.id.getcode, R.id.login_text, R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.getcode:
                email = emailReg.getText().toString();
                if (!email.isEmpty()){
                    boolean email_boo = isEmail(email);
                    if (email_boo==true){
                        mPresenter.getCodePresenter(email);
                    }else {
                        Toast.makeText(this,"邮箱格式有误",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this,"邮箱不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.login_text:
                finish();
                break;
            case R.id.register:
                name = nickName.getText().toString();
                email = emailReg.getText().toString();
                pass = pwdReg.getText().toString();
                code1 = code.getText().toString();
                if (!name.isEmpty()&&!email.isEmpty()&&!pass.isEmpty()&&!code1.isEmpty()){
                    boolean email1 = isEmail(email);
                    String encrypt = EncryptUtil.encrypt(pass);
                    if (email1==false){
                        Toast.makeText(this,"邮箱格式有误",Toast.LENGTH_SHORT).show();
                    }else{
                        mPresenter.ResPresenter(name,encrypt,email,code1);
                    }
                }else {
                    Toast.makeText(this,"输入不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    //校验邮箱
    public static boolean isEmail(String email){
        return Pattern.matches(REGEX_EMAIL, email);
    }
}
