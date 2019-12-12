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

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @describe(描述)：写影评
 * @data（日期）: 2019/12/1
 * @time（时间）: 19:40
 * @author（作者）: xin
 **/
public class YingPingActivity extends BaseActivity<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "YingPingActivity";
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
    @BindView(R.id.bt_yp_push)
    Button btYpPush;
    private String trim;
    private int movieId;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ying_ping;
    }

    @Override
    protected void initView() {
        super.initView();
        imgYpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        String name = intent.getStringExtra("name");
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        String sessionId = sp.getString("s", "");
        int userId = sp.getInt("u", 0);
        tvYpName.setText(name);
        rbYpPingfen.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvPingfen.setText("我的评分("+rating+"分)");
            }
        });
        btYpPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double rating = rbYpPingfen.getRating();
                String trim = etYpMovie.getText().toString();
                if (trim!=null){
                    mPresenter.getXYPData(userId, sessionId, movieId, trim, rating);
                }else {
                    Toast.makeText(YingPingActivity.this,"评价不能为空",Toast.LENGTH_SHORT).show();
                }
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
        Log.d(TAG, "onXYPSuccess: " + ypBean);
        String message = ypBean.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        if (ypBean.getStatus().contains("0000")) {
            setResult(222);
            finish();
        }
    }

    @Override
    public void onXYPFailure(Throwable e) {
        Log.d(TAG, "onXYPFailure: " + e.getMessage().toString());
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
