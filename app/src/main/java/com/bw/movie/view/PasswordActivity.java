package com.bw.movie.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.bw.movie.utils.EncryptUtil;
import com.bw.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：修改密码
 * @data（日期）: 2019/12/7
 * @time（时间）: 13:52
 * @author（作者）: xin
 **/
public class PasswordActivity extends BaseActivity<HomePresenter3> implements IContract3.IView {

    private static final String TAG = "PasswordActivity";
    @BindView(R.id.img_yp_back)
    ImageView imgYpBack;
    @BindView(R.id.pwd_oldpwd)
    EditText pwdOldpwd;
    @BindView(R.id.pwd_newpwd)
    EditText pwdNewpwd;
    @BindView(R.id.pwd_newpwd2)
    EditText pwdNewpwd2;
    @BindView(R.id.pwd_buttton)
    Button pwdButtton;
    private SharedPreferences sp;
    private String sessionId;
    private int userId;

    @Override
    protected HomePresenter3 providePresenter() {
        return new HomePresenter3();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_password;
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

    }

    @Override
    public void onFKFailure(Throwable e) {

    }

    @Override
    public void onMyYuSuccess(MyYuBean myYuBean) {

    }

    @Override
    public void onMyYuFailure(Throwable e) {

    }

    @Override
    public void onPWDSuccess(PwdBean pwdBean) {
        Log.d(TAG, "onPWDSuccess: " + pwdBean);
        if (pwdBean.getStatus().equals("1001")) {
            Toast.makeText(this, "密码修改失败", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onPWDFailure(Throwable e) {
        Log.d(TAG, "onPWDFailure: " + e.getMessage().toString());
    }

    @Override
    public void onYYSSSuccess(SearchYYBean searchYYBean) {

    }

    @Override
    public void onYYSSFailure(Throwable e) {

    }

    @OnClick({R.id.img_yp_back, R.id.pwd_buttton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_yp_back:
                finish();
                break;
            case R.id.pwd_buttton:
                //获取输入框的值
                String oldPwd = pwdOldpwd.getText().toString().trim();
                String newPwd = pwdNewpwd.getText().toString().trim();
                String newPwd2 = pwdNewpwd2.getText().toString().trim();
                //加密后
                String oldencrypt = EncryptUtil.encrypt(oldPwd);
                String newencrypt = EncryptUtil.encrypt(newPwd);
                String new2encrypt = EncryptUtil.encrypt(newPwd2);
                if (oldencrypt.isEmpty() && newencrypt.isEmpty()&&new2encrypt.isEmpty()){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    if (newencrypt.equals(new2encrypt)){
                        mPresenter.getPWDData(userId,sessionId,oldencrypt,newencrypt,new2encrypt);
                    }else{
                        Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}
