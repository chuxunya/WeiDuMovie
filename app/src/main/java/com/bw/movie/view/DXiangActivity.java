package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.app.MainApplication;
import com.bw.movie.bean.GCinemaBeam;
import com.bw.movie.bean.GMovieBean;
import com.bw.movie.bean.GZCBean;
import com.bw.movie.bean.MovieXBean;
import com.bw.movie.bean.OrderBean;
import com.bw.movie.bean.PayBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.QGZCBean;
import com.bw.movie.bean.QGZMBean;
import com.bw.movie.bean.ReCodeBean;
import com.bw.movie.bean.SchedulerBean;
import com.bw.movie.bean.SearchBean;
import com.bw.movie.bean.SeatBean;
import com.bw.movie.bean.YPBean;
import com.bw.movie.bean.YYPJBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.bean.YYPQBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.contract.IContract2;
import com.bw.movie.presenter.HomePresenter2;
import com.bw.mvp.base.BaseActivity;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：DXiangActivity
 * @data（日期）: 2019/12/1
 * @time（时间）: 19:39
 * @author（作者）: xin
 **/
public class DXiangActivity extends BaseActivity<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "MXiangActivity";
    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.position)
    TextView position;
    @BindView(R.id.home)
    TextView home;
    @BindView(R.id.count)
    TextView count;
    @BindView(R.id.seat)
    TextView seat;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.orderId)
    TextView orderId;
    @BindView(R.id.createtime)
    TextView createtime;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.pay)
    Button pay;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.wechat)
    CheckBox wechat;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.zfb)
    CheckBox zfb;
    @BindView(R.id.paybck)
    LinearLayout paybck;
    @BindView(R.id.pay_btn)
    Button payBtn;
    @BindView(R.id.line)
    LinearLayout line;
    @BindView(R.id.rela)
    RelativeLayout rela;
    private MovieXBean.ResultBean result;
    private String orderId1;
    int id;
    private int userId;
    private String sessionId;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_dxiang;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        String sessionId = sp.getString("s", "");
        int userId = sp.getInt("u", 0);
        Intent intent = getIntent();
        orderId1 = intent.getStringExtra("orderId");
        mPresenter.getMXP(userId, sessionId, orderId1);
    }

    @Override
    protected void initView() {
        super.initView();
        detailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onPingSuccess(PingBean pingBean) {

    }

    @Override
    public void onPingFailure(Throwable e) {

    }

    @Override
    public void onSchedulerSuccess(SchedulerBean schedulerBean) {

    }

    @Override
    public void onSchedulerFailure(Throwable e) {

    }

    @Override
    public void onSeatSuccess(SeatBean seatBean) {

    }

    @Override
    public void onSeatFailure(Throwable e) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void onOrderFailure(Throwable e) {

    }

    @Override
    public void onRecodeSuccess(ReCodeBean reCodeBean) {

    }

    @Override
    public void onRecodeFailure(Throwable e) {

    }

    @Override
    public void onPaySuccess(PayBean payBean) {
        Log.d(TAG, "onPaySuccess: " + payBean);
        if (payBean.getStatus().equals("0000")) {
            PayReq payReq = new PayReq();
            payReq.appId = payBean.getAppId();
            payReq.nonceStr = payBean.getNonceStr();
            payReq.partnerId = payBean.getPartnerId();
            payReq.prepayId = payBean.getPrepayId();
            payReq.sign = payBean.getSign();
            payReq.timeStamp = payBean.getTimeStamp();
            payReq.packageValue = payBean.getPackageValue();
            payReq.extData = "app data";
            MainApplication.api.sendReq(payReq);
            paybck.setVisibility(View.GONE);
            payBtn.setVisibility(View.GONE);
            Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onPayFailure(Throwable e) {
        Log.d(TAG, "onPayFailure: " + e.getMessage());
    }

    @Override
    public void onMXSuccess(MovieXBean movieXBean) {
        Log.d(TAG, "onMXSuccess: " + movieXBean);
        if (movieXBean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            result = movieXBean.getResult();
            name.setText(result.getMovieName());
            position.setText(result.getCinemaName());
            home.setText(result.getScreeningHall());
            count.setText(result.getAmount() + "张");
            seat.setText(result.getSeat());
            time.setText(result.getBeginTime() + "-" + result.getEndTime());
            orderId.setText(orderId1);
            Date date = new Date(result.getCreateTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            createtime.setText(simpleDateFormat.format(date));
            price.setText("￥" + result.getPrice());
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    paybck.setVisibility(View.VISIBLE);
                    payBtn.setVisibility(View.VISIBLE);
                    payBtn.setText("￥" + result.getPrice());
                    wechat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wechat.setChecked(true);
                            zfb.setChecked(false);
                            id = 1;
                            payBtn.setText("微信支付￥ " + result.getPrice());
                        }
                    });
                    zfb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            zfb.setChecked(true);
                            wechat.setChecked(false);
                            id = 2;
                            payBtn.setText("支付宝支付￥ " + result.getPrice());
                        }
                    });
                    SharedPreferences movie = getSharedPreferences("movie", MODE_PRIVATE);
                    sessionId = movie.getString("s", "");
                    userId = movie.getInt("u", 0);
                    payBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPresenter.getPayP(userId, sessionId, id, result.getOrderId());
                        }
                    });
                }
            });
        }
    }

    @Override
    public void onMXFailure(Throwable e) {
        Log.d(TAG, "onMXFailure: " + e.getMessage().toString());
    }

    @Override
    public void onDyssSuccess(SearchBean bean) {

    }

    @Override
    public void onDyssFailure(Throwable e) {

    }

    @Override
    public void onXYPSuccess(YPBean ypBean) {

    }

    @Override
    public void onXYPFailure(Throwable e) {

    }

    @Override
    public void onYYXQSuccess(YYXQBean yyxqBean) {

    }

    @Override
    public void onYYXQFailure(Throwable e) {

    }

    @Override
    public void onYYPJSuccess(YYPJBean yypjBean) {

    }

    @Override
    public void onYYPJFailure(Throwable e) {

    }

    @Override
    public void onYYPQSuccess(YYPQBean yypqBean) {

    }

    @Override
    public void onYYPQFailure(Throwable e) {

    }

    @Override
    public void onGMSuccess(GMovieBean gMovieBean) {

    }

    @Override
    public void onGMFailure(Throwable e) {

    }

    @Override
    public void onGcSuccess(GCinemaBeam gCinemaBeam) {

    }

    @Override
    public void onGcFailure(Throwable e) {

    }

    @Override
    public void onQGZMSuccess(QGZMBean qgzmBean) {

    }

    @Override
    public void onQGZMFailure(Throwable e) {

    }

    @Override
    public void onYYPLSuccess(YYPLBean yyplBean) {

    }

    @Override
    public void onYYPLFailure(Throwable e) {

    }

    @Override
    public void onGZCSuccess(GZCBean gzcBean) {

    }

    @Override
    public void onGZCFailure(Throwable e) {

    }

    @Override
    public void onQGZCSuccess(QGZCBean qgzcBean) {

    }

    @Override
    public void onQGZCFailure(Throwable e) {

    }

    @OnClick(R.id.rela)
    public void onViewClicked() {
        paybck.setVisibility(View.GONE);
        payBtn.setVisibility(View.GONE);
    }
}
