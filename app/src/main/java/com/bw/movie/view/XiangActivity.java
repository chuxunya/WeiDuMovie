package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.bw.movie.bean.GZMBean;
import com.bw.movie.bean.JiUpBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.NowReBean;
import com.bw.movie.bean.Price_Cinema_Bean;
import com.bw.movie.bean.QGZMBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.RemenBean;
import com.bw.movie.bean.TuiBean;
import com.bw.movie.bean.WXBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.YYBean;
import com.bw.movie.contract.IContract;
import com.bw.movie.presenter.HomePresenter;
import com.bw.mvp.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:王可欣
 *@Date: 2019/11/18
 *@Time:20:51
 *@Description:xiangqing 
 **/
public class XiangActivity extends BaseActivity<HomePresenter> implements IContract.IView {

    private static final String TAG = "XiangActivity";
    @BindView(R.id.xiang_img)
    SimpleDraweeView xiangImg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.details_name)
    TextView detailsName;
    @BindView(R.id.details_type)
    TextView detailsType;
    @BindView(R.id.details_time)
    TextView detailsTime;
    @BindView(R.id.guanzhu_img)
    ImageView guanzhuImg;
    @BindView(R.id.guanzhu_img2)
    ImageView guanzhuImg2;
    @BindView(R.id.gz)
    TextView gz;
    @BindView(R.id.gz2)
    TextView gz2;
    @BindView(R.id.xiang_tab)
    TabLayout xiangTab;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.xiang_vp)
    ViewPager xiangVp;
    @BindView(R.id.btn_reviews)
    Button btnReviews;
    @BindView(R.id.btn_seat)
    Button btnSeat;
    @BindView(R.id.details_back)
    ImageView detailsBack;

    private XiangBean.ResultBean result;
    private int movieId;
    private String sessionId;
    private int userId;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xiang_a;
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
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        mPresenter.getXiangP(userId, sessionId, movieId);
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void onLoginFailure(Throwable e) {

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
        Log.d("xiangactivity", "onXiangSuccess: " + xiangBean);
        if (xiangBean.getResult() == null) {
            Toast.makeText(this, "暂无数据", Toast.LENGTH_SHORT).show();
        } else {
            result = xiangBean.getResult();
            int whetherFollow = result.getWhetherFollow();
            if (whetherFollow == 1) {
                //关注
                guanzhuImg.setVisibility(View.GONE);
                guanzhuImg2.setVisibility(View.VISIBLE);
                gz.setVisibility(View.GONE);
                gz2.setVisibility(View.VISIBLE);
                guanzhuImg2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.getQGZMData(userId, sessionId, result.getMovieId());
                    }
                });
            } else {
                //未关注
                guanzhuImg.setVisibility(View.VISIBLE);
                guanzhuImg2.setVisibility(View.GONE);
                gz.setVisibility(View.VISIBLE);
                gz2.setVisibility(View.GONE);
                guanzhuImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.getGZMData(userId, sessionId, result.getMovieId());
                    }
                });
            }

        }
        xiangImg.setImageURI(result.getImageUrl());
        detailsName.setText(result.getName());
        detailsType.setText(result.getMovieType());
        long time = result.getReleaseTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(time);
        detailsTime.setText(format);

        toolbar.setTitle(xiangBean.getResult().getName());
        btnSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(XiangActivity.this, ChooseCinemaActivity.class);
                intent.putExtra("movieId", result.getMovieId());
                startActivity(intent);
            }
        });
        btnReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XiangActivity.this, YingPingActivity.class);
                intent.putExtra("movieId", movieId);
                intent.putExtra("name", result.getName());
                startActivityForResult(intent, 123);
            }
        });

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Fragment_Introduced());
        list.add(new Fragment_Notice());
        list.add(new Fragment_Still());
        list.add(new Fragment_critics());
        ArrayList<String> tablist = new ArrayList<>();
        tablist.add("介绍");
        tablist.add("预告");
        tablist.add("剧照");
        tablist.add("影评");

        xiangVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tablist.get(position);
            }
        });
        xiangTab.setupWithViewPager(xiangVp);
        xiangVp.setOffscreenPageLimit(4);
    }

    @Override
    public void onXiangFailure(Throwable e) {
        Log.d("xiangactivity", "onXiangFailure: " + e.getMessage().toString());
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
        Log.d(TAG, "onGZMSuccess: " + gzmBean);
        if (gzmBean.getMessage().equals("关注成功")) {
            guanzhuImg.setVisibility(View.GONE);
            guanzhuImg2.setVisibility(View.VISIBLE);
            gz.setVisibility(View.GONE);
            gz2.setVisibility(View.VISIBLE);
            Toast.makeText(this, gzmBean.getMessage(), Toast.LENGTH_SHORT).show();
            guanzhuImg2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.getQGZMData(userId, sessionId, result.getMovieId());
                }
            });
        } else {
            Toast.makeText(this, gzmBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGZMFailure(Throwable e) {

    }

    @Override
    public void onQGZMSuccess(QGZMBean qgzmBean) {
        Log.d(TAG, "onQGZMSuccess: " + qgzmBean);
        if (qgzmBean.getMessage().equals("取消关注成功")) {
            guanzhuImg.setVisibility(View.VISIBLE);
            guanzhuImg2.setVisibility(View.GONE);
            gz.setVisibility(View.VISIBLE);
            gz2.setVisibility(View.GONE);
            Toast.makeText(this, qgzmBean.getMessage(), Toast.LENGTH_SHORT).show();
            guanzhuImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.getGZMData(userId, sessionId, result.getMovieId());
                }
            });
        } else {
            Toast.makeText(this, qgzmBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onQGZMFailure(Throwable e) {
        Log.d(TAG, "onQGZMFailure: " + e.getMessage().toString());
    }

    @Override
    public void onYYSuccess(YYBean yyBean) {

    }

    @Override
    public void onYYFailure(Throwable e) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 222) {
            mPresenter.getXiangP(userId, sessionId, movieId);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
