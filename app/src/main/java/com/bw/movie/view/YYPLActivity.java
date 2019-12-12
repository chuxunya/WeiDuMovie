package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.FKBean;
import com.bw.movie.bean.GCinemaBeam;
import com.bw.movie.bean.GMovieBean;
import com.bw.movie.bean.GZCBean;
import com.bw.movie.bean.HeadBean;
import com.bw.movie.bean.LookedBean;
import com.bw.movie.bean.MovieXBean;
import com.bw.movie.bean.MyBean;
import com.bw.movie.bean.MyPBean;
import com.bw.movie.bean.MyYuBean;
import com.bw.movie.bean.OrderBean;
import com.bw.movie.bean.PJBean;
import com.bw.movie.bean.PJYYBean;
import com.bw.movie.bean.PayBean;
import com.bw.movie.bean.PiaoBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.PwdBean;
import com.bw.movie.bean.QGZCBean;
import com.bw.movie.bean.QGZMBean;
import com.bw.movie.bean.ReCodeBean;
import com.bw.movie.bean.SchedulerBean;
import com.bw.movie.bean.SearchBean;
import com.bw.movie.bean.SearchYYBean;
import com.bw.movie.bean.SeatBean;
import com.bw.movie.bean.XTBean;
import com.bw.movie.bean.YPBean;
import com.bw.movie.bean.YYPJBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.bean.YYPQBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.contract.IContract2;
import com.bw.movie.contract.IContract3;
import com.bw.movie.presenter.HomePresenter2;
import com.bw.movie.presenter.HomePresenter3;
import com.bw.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：看过的电影评论
 * @data（日期）: 2019/12/7
 * @time（时间）: 23:03
 * @author（作者）: xin
 **/
public class YYPLActivity extends BaseActivity<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "YYPLActivity";
    @BindView(R.id.img_yp_back)
    ImageView imgYpBack;
    @BindView(R.id.tv_yp_name)
    TextView tvYpName;
    @BindView(R.id.tv_pingfen)
    TextView tvPingfen;
    @BindView(R.id.rb_yp_pingfen)
    RatingBar rbYpPingfen;
    @BindView(R.id.et_yp_movie)
    EditText etYpMovie;
    @BindView(R.id.et_yp_cni)
    EditText etYpCni;
    @BindView(R.id.bt_yp_push)
    Button btYpPush;
    private int movieId;
    private int cinemaId;
    private SharedPreferences sp;
    private String sessionId;
    private int userId;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_yypl;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 0);
        movieId = intent.getIntExtra("movieId", 0);
        sp = getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        rbYpPingfen.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvPingfen.setText("我的评分("+rating+"分)");
            }
        });
    }

    @OnClick({R.id.img_yp_back, R.id.bt_yp_push})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_yp_back:
                finish();
                break;
            case R.id.bt_yp_push:
                String moviePing = etYpMovie.getText().toString().trim();
                String cinemaPing = etYpCni.getText().toString().trim();
                double rating = rbYpPingfen.getRating();
                mPresenter.getXYPData(userId,sessionId,movieId,moviePing,rating);
                mPresenter.getYYPLData(userId,sessionId,cinemaId,cinemaPing);
                break;
        }
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

    }

    @Override
    public void onPayFailure(Throwable e) {

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
        Log.d(TAG, "onXYPSuccess: "+ypBean);
    }

    @Override
    public void onXYPFailure(Throwable e) {
        Log.d(TAG, "onXYPFailure: "+e.getMessage());
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
        Log.d(TAG, "onYYPLSuccess: "+yyplBean);
        if (yyplBean.getStatus().equals("0000")){
            Toast.makeText(this,"评论成功",Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this,yyplBean.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onYYPLFailure(Throwable e) {
        Log.d(TAG, "onYYPLFailure: "+e.getMessage().toString());
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
}
