package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
import com.bw.movie.utils.MyAdapter_notice;
import com.bw.movie.utils.MyRecyAdapter01_day;
import com.bw.movie.utils.MyRecyAdapter01_qy;
import com.bw.movie.utils.MyShopAdapter_day;
import com.bw.movie.utils.MyShopAdapter_price;
import com.bw.movie.utils.MyShopAdapter_qy;
import com.bw.mvp.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
/**
 *@describe(描述)：选择影院
 *@data（日期）: 2019/12/5
 *@time（时间）: 21:50
 *@author（作者）: xin
 **/
public class ChooseCinemaActivity extends BaseActivity<HomePresenter> implements IContract.IView {

    private static final String TAG = "ChooseCinemaActivity";
    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.jc_choose)
    JCVideoPlayerStandard jcChoose;
    @BindView(R.id.movie_name)
    TextView movieName;
    @BindView(R.id.movie_tiime)
    TextView movieTime;
    @BindView(R.id.score_tiime)
    TextView scoreTime;
    @BindView(R.id.director_tiime)
    TextView directorTime;
    @BindView(R.id.search_choose)
    ImageView searchChoose;
    @BindView(R.id.recy_choose)
    RecyclerView recyChoose;
    @BindView(R.id.area_choose)
    TextView areaChoose;
    @BindView(R.id.day_choose)
    TextView dayChoose;
    @BindView(R.id.price_choose)
    TextView priceChoose;

    private String name = "";
    private List<AreaBean.ResultBean> result2;
    private List<Choose_qy_Bean.ResultBean> result1;
    private List<String> result3;
    private List<Choose_day_bean.ResultBean> result4;
    private List<Price_Cinema_Bean.ResultBean> result5;
    private XiangBean.ResultBean result;
    private String sessionId;
    private int userId;
    private int movieId;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

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
        searchChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseCinemaActivity.this,SearchYYActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId",0);
        mPresenter.getXiangP(userId, sessionId, movieId);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_choose_cinema;
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
        Log.d(TAG, "onAreaSuccess: "+areaBean);
        if (areaBean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChooseCinemaActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyChoose.setLayoutManager(linearLayoutManager);
            result2 = areaBean.getResult();
            MyRecyAdapter01_qy myRecyAdapter01 = new MyRecyAdapter01_qy(result2, ChooseCinemaActivity.this);
            recyChoose.setAdapter(myRecyAdapter01);
            myRecyAdapter01.setOnClickListener2(new MyRecyAdapter01_qy.onClickListener2() {
                @Override
                public void click(int regionId, String text) {
                    areaChoose.setText(text);
                    mPresenter.getQYData(movieId,regionId,1,10);
                }
            });
        }
    }

    @Override
    public void onAreaFailure(Throwable e) {
        Log.d(TAG, "onAreaFailure: "+e.getMessage().toString());
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
        Log.d(TAG, "onXiangSuccess: " + xiangBean);
        if (xiangBean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            result = xiangBean.getResult();
            List<XiangBean.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList();
            jcChoose.setUp(shortFilmList.get(0).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, "");
            Glide.with(this).load(shortFilmList.get(0).getImageUrl()).into(jcChoose.thumbImageView);
            movieName.setText(result.getName());
            movieTime.setText(result.getDuration());
            scoreTime.setText(result.getScore() + "分");
            List<XiangBean.ResultBean.MovieDirectorBean> movieDirector = result.getMovieDirector();
            for (int i = 0; i < movieDirector.size(); i++) {
                name += movieDirector.get(i).getName() + " ";
            }
            directorTime.setText(name);
            areaChoose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.getAreaData();
                }
            });
            dayChoose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.getDayP();
                }
            });
            priceChoose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.getPriceData(result.getMovieId(),1,10);
                }
            });
            EventBus.getDefault().postSticky(xiangBean);
        }
    }

    @Override
    public void onXiangFailure(Throwable e) {
        Log.d(TAG, "onXiangFailure: " + e.getMessage().toString());
    }

    @Override
    public void onQYSuccess(Choose_qy_Bean choose_qy_bean) {
        Log.d(TAG, "onQYSuccess: "+choose_qy_bean);
        if (choose_qy_bean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            result1 = choose_qy_bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChooseCinemaActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyChoose.setLayoutManager(linearLayoutManager);
            MyShopAdapter_qy myRecyAdapter01 = new MyShopAdapter_qy(result1, ChooseCinemaActivity.this);
            recyChoose.setAdapter(myRecyAdapter01);
            myRecyAdapter01.setOnClickListener(new MyShopAdapter_qy.OnClickListener() {
                @Override
                public void onclick(int cinemaId) {
                    Intent intent = new Intent(ChooseCinemaActivity.this, SeatActivity.class);
                    intent.putExtra("cinemaId",cinemaId);
                    intent.putExtra("movieId",movieId);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onQYFailure(Throwable e) {
        Log.d(TAG, "onQYFailure: "+e.getMessage().toString());
    }

    @Override
    public void onDaySuccess(DayBean dayBean) {
        Log.d(TAG, "onDaySuccess: "+dayBean);
        if (dayBean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            result3 = dayBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChooseCinemaActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyChoose.setLayoutManager(linearLayoutManager);
            MyRecyAdapter01_day myRecyAdapter01 = new MyRecyAdapter01_day(result3, ChooseCinemaActivity.this);
            recyChoose.setAdapter(myRecyAdapter01);
            myRecyAdapter01.setOnClickListener2(new MyRecyAdapter01_day.onClickListener2() {
                @Override
                public void click(String text) {
                    dayChoose.setText(text);
                    mPresenter.getDP(movieId,text,1,10);
                }
            });
        }
    }

    @Override
    public void onDayFailure(Throwable e) {
        Log.d(TAG, "onDayFailure: "+e.getMessage().toString());
    }

    @Override
    public void onDSuccess(Choose_day_bean dayBean) {
        Log.d(TAG, "onDSuccess: "+dayBean);
        if (dayBean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            result4 = dayBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChooseCinemaActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyChoose.setLayoutManager(linearLayoutManager);
            MyShopAdapter_day myRecyAdapter01 = new MyShopAdapter_day(result4, ChooseCinemaActivity.this);
            recyChoose.setAdapter(myRecyAdapter01);
            myRecyAdapter01.setOnClickListener(new MyShopAdapter_day.OnClickListener() {
                @Override
                public void onclick(int cinemaId) {
                    Intent intent = new Intent(ChooseCinemaActivity.this, SeatActivity.class);
                    intent.putExtra("cinemaId",cinemaId);
                    intent.putExtra("movieId",movieId);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onDFailure(Throwable e) {
        Log.d(TAG, "onDFailure: "+e.getMessage().toString());
    }

    @Override
    public void onPriceSuccess(Price_Cinema_Bean price_cinema_bean) {
        Log.d(TAG, "onPriceSuccess: "+ price_cinema_bean);
        if (price_cinema_bean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            result5 = price_cinema_bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChooseCinemaActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyChoose.setLayoutManager(linearLayoutManager);
            MyShopAdapter_price myRecyAdapter01 = new MyShopAdapter_price(result5, ChooseCinemaActivity.this);
            recyChoose.setAdapter(myRecyAdapter01);
            myRecyAdapter01.setOnClickListener(new MyShopAdapter_price.OnClickListener() {
                @Override
                public void onclick(int cinemaId) {
                    Intent intent = new Intent(ChooseCinemaActivity.this, SeatActivity.class);
                    intent.putExtra("cinemaId",cinemaId);
                    intent.putExtra("movieId",movieId);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onPriceFailure(Throwable e) {
        Log.d(TAG, "onPriceFailure: "+e.getMessage().toString());
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
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
