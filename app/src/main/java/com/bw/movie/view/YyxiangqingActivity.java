package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：影院详情
 * @data（日期）: 2019/12/1
 * @time（时间）: 21:26
 * @author（作者）: xin
 **/
public class YyxiangqingActivity extends BaseActivity<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "YyxiangqingActivity";
    @BindView(R.id.simp_yy_gh)
    ImageView simpYyGh;
    @BindView(R.id.relat1)
    RelativeLayout relat1;
    @BindView(R.id.xiangqing_name)
    TextView xiangqingName;
    @BindView(R.id.checkbox_xin)
    ImageView checkboxXin;
    @BindView(R.id.relat2)
    RelativeLayout relat2;
    @BindView(R.id.xiangqing_yanjin)
    TextView xiangqingYanjin;
    @BindView(R.id.tohere_cinemadetail)
    LinearLayout tohereCinemadetail;
    @BindView(R.id.relat3)
    RelativeLayout relat3;
    @BindView(R.id.xiangqing_tab)
    TabLayout xiangqingTab;
    @BindView(R.id.xiangqing_vp)
    ViewPager xiangqingVp;
    @BindView(R.id.button_paiqi)
    Button buttonPaiqi;
    @BindView(R.id.checkbox_xin2)
    ImageView checkboxXin2;
    private ArrayList<String> list;
    private ArrayList<Fragment> list1;
    private int cinemaId;
    private String sessionId;
    private int userId;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_yyxiangqing;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 0);
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);

        mPresenter.getYYXQp(userId, sessionId, cinemaId);
        list = new ArrayList<>();
        list1 = new ArrayList<Fragment>();
        list.add("影院详情");
        list.add("影院评价");
        list1.add(new Fragment_yyxq());
        list1.add(new Fragment_yypj());
        xiangqingVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list1.get(position);
            }

            @Override
            public int getCount() {
                return list1.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        xiangqingTab.setupWithViewPager(xiangqingVp);
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

    }

    @Override
    public void onXYPFailure(Throwable e) {

    }

    @Override
    public void onYYXQSuccess(YYXQBean yyxqBean) {
        Log.d(TAG, "onYYXQSuccess: " + yyxqBean);
        if (yyxqBean.getResult() == null) {
            Toast.makeText(this, "暂无数据", Toast.LENGTH_SHORT).show();
        } else {
            xiangqingName.setText(yyxqBean.getResult().getName());
            int followCinema = yyxqBean.getResult().getFollowCinema();
            if (followCinema==1){
                //已关注
                checkboxXin.setVisibility(View.GONE);
                checkboxXin2.setVisibility(View.VISIBLE);
            }else {
                //nono
                checkboxXin.setVisibility(View.VISIBLE);
                checkboxXin2.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onYYXQFailure(Throwable e) {
        Log.d(TAG, "onYYXQFailure: " + e.getMessage().toString());
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
        Log.d(TAG, "onGZCSuccess: "+gzcBean);
        checkboxXin.setVisibility(View.GONE);
        checkboxXin2.setVisibility(View.VISIBLE);
        Toast.makeText(this,gzcBean.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGZCFailure(Throwable e) {
        Log.d(TAG, "onGZCFailure: "+e.getMessage());
    }

    @Override
    public void onQGZCSuccess(QGZCBean qgzcBean) {
        Log.d(TAG, "onQGZCSuccess: "+qgzcBean );
        Toast.makeText(this,qgzcBean.getMessage(),Toast.LENGTH_SHORT).show();
        checkboxXin.setVisibility(View.VISIBLE);
        checkboxXin2.setVisibility(View.GONE);
    }

    @Override
    public void onQGZCFailure(Throwable e) {
        Log.d(TAG, "onQGZCFailure: "+e.getMessage());
    }

    @OnClick({R.id.simp_yy_gh, R.id.button_paiqi,R.id.checkbox_xin,R.id.checkbox_xin2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.simp_yy_gh:
                finish();
                break;
            case R.id.button_paiqi:
                Intent intent = new Intent(this, YyDypqActivity.class);
                intent.putExtra("id", cinemaId);
                startActivity(intent);
                break;
            case R.id.checkbox_xin:
                mPresenter.getGZCData(userId,sessionId,cinemaId);
                break;
            case R.id.checkbox_xin2:
                mPresenter.getQGZMData(userId,sessionId,cinemaId);
                break;
        }
    }
}
