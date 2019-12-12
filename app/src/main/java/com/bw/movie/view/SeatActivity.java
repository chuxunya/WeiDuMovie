package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.YPBean;
import com.bw.movie.bean.YYPJBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.bean.YYPQBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.contract.IContract2;
import com.bw.movie.presenter.HomePresenter2;
import com.bw.movie.utils.MD5;
import com.bw.movie.utils.MyAdapter_Seat;
import com.bw.movie.utils.Myadapter_Seat_Choose;
import com.bw.mvp.base.BaseActivity;
import com.tencent.mm.opensdk.modelpay.PayReq;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
/**
 *@describe(描述)：SeatActivity
 *@data（日期）: 2019/12/7
 *@time（时间）: 13:51
 *@author（作者）: xin
 **/
public class SeatActivity extends BaseActivity<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "SeatActivity";
    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.movie_name_seat)
    TextView movieNameSeat;
    @BindView(R.id.jc_seat)
    JCVideoPlayerStandard jcSeat;
    @BindView(R.id.recy_seat)
    RecyclerView recySeat;
    @BindView(R.id.liner)
    LinearLayout liner;
    @BindView(R.id.TSsize)
    TextView TSsize;
    @BindView(R.id.rect_YS_seat)
    RecyclerView rectYSSeat;
    @BindView(R.id.choose_seat)
    TextView chooseSeat;
    @BindView(R.id.wechat)
    CheckBox wechat;
    @BindView(R.id.zfb)
    CheckBox zfb;
    @BindView(R.id.pay)
    LinearLayout pay;
    @BindView(R.id.pay_seat)
    TextView paySeat;
    @BindView(R.id.rela)
    RelativeLayout rela;

    private XiangBean.ResultBean result;
    private int cinemaId;
    private List<SchedulerBean.ResultBean> result2;
    private List<SeatBean.ResultBean> result1;
    double money = 0;
    int id;
    private double fare1;
    private ArrayList<String> list;
    private int scheduleId;
    private String format;
    private int userId;
    private String sessionId;
    private Myadapter_Seat_Choose myadapter_seat_choose;
    private int hall;

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        detailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void evevt(XiangBean xiangBean) {
        result = xiangBean.getResult();
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(this);
        Intent intent = getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 1);
        mPresenter.getSchedulerData(result.getMovieId(), cinemaId);
        XiangBean.ResultBean.ShortFilmListBean shortFilmListBean = result.getShortFilmList().get(0);
        movieNameSeat.setText(result.getName());
        jcSeat.setUp(shortFilmListBean.getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, "");
        Glide.with(this).load(shortFilmListBean.getImageUrl()).into(jcSeat.thumbImageView);
        list = new ArrayList<>();
    }


    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_seat;
    }

    @Override
    public void onPingSuccess(PingBean pingBean) {

    }

    @Override
    public void onPingFailure(Throwable e) {

    }

    @Override
    public void onSchedulerSuccess(SchedulerBean schedulerBean) {
        Log.d(TAG, "ccccc: " + schedulerBean);
        if (schedulerBean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SeatActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            rectYSSeat.setLayoutManager(linearLayoutManager);
            result2 = schedulerBean.getResult();
            MyAdapter_Seat myAdapter_seat = new MyAdapter_Seat(result2, SeatActivity.this);
            rectYSSeat.setAdapter(myAdapter_seat);
            myAdapter_seat.setOnclickListener(new MyAdapter_Seat.OnclickListener() {

                @Override
                public void onclick(int hallId, double fare, int id) {
                    hall = hallId;
                    mPresenter.getSeatData(hall);
                    fare1 = fare;
                    money = 0;
                    chooseSeat.setText("￥ " + money);
                    scheduleId = id;
                }
            });
            hall = schedulerBean.getResult().get(0).getHallId();
            mPresenter.getSeatData(hall);
            fare1=schedulerBean.getResult().get(0).getFare();
            money = 0;
            chooseSeat.setText("￥ " + money);
            scheduleId=schedulerBean.getResult().get(0).getId();
        }
    }

    @Override
    public void onSchedulerFailure(Throwable e) {
        Log.d(TAG, "onSchedulerFailure: " + e.getMessage().toString());
    }

    @Override
    public void onSeatSuccess(SeatBean seatBean) {
        Log.d(TAG, "onSeatSuccess: " + seatBean);
        if (seatBean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            result1 = seatBean.getResult();
            int seat = Integer.parseInt(result1.get(result1.size() - 1).getSeat());
            Log.d("座位", "onSeatSuccess: " + seat);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(SeatActivity.this, seat);
            recySeat.setLayoutManager(gridLayoutManager);
            myadapter_seat_choose = new Myadapter_Seat_Choose(result1, SeatActivity.this);
            recySeat.setAdapter(myadapter_seat_choose);
            myadapter_seat_choose.setOnclickListener(new Myadapter_Seat_Choose.OnclickListener() {

                private String soft;

                @Override
                public void onclick(String row, String seat, boolean ischecked) {
                    if (ischecked == true) {
                        soft = row + "-" + seat;
                        list.add(soft);
                        Toast.makeText(SeatActivity.this, row + "排" + seat + "座", Toast.LENGTH_SHORT).show();
                        money = money + fare1;
                        DecimalFormat df = new DecimalFormat("0.00");
                        format = df.format(money);
                        chooseSeat.setText("￥ " + format);
                    } else {
                        soft = row + "-" + seat;
                        list.remove(soft);
                        money = money - fare1;
                        DecimalFormat df = new DecimalFormat("0.00");
                        format = df.format(money);
                        chooseSeat.setText("￥ " + format);
                    }
                }
            });

            chooseSeat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences movie = getSharedPreferences("movie", MODE_PRIVATE);
                    sessionId = movie.getString("s", "");
                    if (sessionId == null) {
                        Toast.makeText(SeatActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                    } else {
                        userId = movie.getInt("u", 0);
                        String join = TextUtils.join(",", list);
                        String qian = userId + "" + scheduleId + "movie";
                        String md5 = MD5.MD5(qian);
                        mPresenter.getOrderP(userId, sessionId, scheduleId, join, md5);
                    }
                }
            });
        }
    }

    @Override
    public void onSeatFailure(Throwable e) {
        Log.d(TAG, "onSeatFailure: " + e.getMessage().toString());
    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {
        Log.d(TAG, "onOrderSuccess: " + orderBean);
        if (orderBean.getStatus().contains("0000")) {
            Toast.makeText(SeatActivity.this, "下单成功", Toast.LENGTH_SHORT).show();
            chooseSeat.setVisibility(View.GONE);
            paySeat.setVisibility(View.VISIBLE);
            pay.setVisibility(View.VISIBLE);
            paySeat.setText("￥ " + format);
            wechat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wechat.setChecked(true);
                    zfb.setChecked(false);
                    id = 1;
                    paySeat.setText("微信支付￥ " + format);
                }
            });
            zfb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    zfb.setChecked(true);
                    wechat.setChecked(false);
                    id = 2;
                    paySeat.setText("支付宝支付￥ " + format);
                }
            });
            paySeat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.getPayP(userId, sessionId, id, orderBean.getOrderId());
                }
            });
        }else if (orderBean.getStatus().contains("9999")){
            Toast.makeText(SeatActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onOrderFailure(Throwable e) {
        Log.d(TAG, "onOrderFailure: " + e.getMessage().toString());
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
            pay.setVisibility(View.GONE);
            chooseSeat.setVisibility(View.VISIBLE);
            paySeat.setVisibility(View.GONE);
            mPresenter.getSeatData(hall);
            money = 0;
            chooseSeat.setText("￥" + money);
        }
    }

    @Override
    public void onPayFailure(Throwable e) {
        Log.d(TAG, "onPayFailure: " + e.getMessage());
    }

    @Override
    public void onMXSuccess(MovieXBean movieXBean) {

    }

    @Override
    public void onMXFailure(Throwable e) {

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
        pay.setVisibility(View.GONE);
        chooseSeat.setVisibility(View.VISIBLE);
        paySeat.setVisibility(View.GONE);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
