package com.bw.movie.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.bw.movie.utils.MyRecyAdapter01;
import com.bw.movie.utils.MyRecyAdapter02;
import com.bw.mvp.base.BaseFragment;
import com.bw.mvp.utils.NetUtil;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/*
 *@auther:王可欣
 *@Date: 2019/11/13
 *@Time:20:52
 *@Description:区域
 **/
public class FragArea extends BaseFragment<HomePresenter> implements IContract.IView {
    private static final String TAG = "FragArea";
    @BindView(R.id.recy1_area)
    RecyclerView recy1Area;
    @BindView(R.id.recy2_area)
    RecyclerView recy2Area;
    private List<AreaBean.ResultBean> result;
    private List<CinemaBean.ResultBean> result1;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragarea;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getAreaData();
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
        Log.d(TAG, "onAreaSuccess: " + areaBean);
        if (areaBean.getResult()==null){
            Toast.makeText(getActivity(),"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recy1Area.setLayoutManager(linearLayoutManager);
            result = areaBean.getResult();
            MyRecyAdapter01 myRecyAdapter01 = new MyRecyAdapter01(result, getContext());
            recy1Area.setAdapter(myRecyAdapter01);
            myRecyAdapter01.setmOnClickListener(new MyRecyAdapter01.onClickListener() {
                @Override
                public void click(int regionId) {
                    mPresenter.getCinemaByRegionData(regionId);
                }
            });
        }
    }

    @Override
    public void onAreaFailure(Throwable e) {
        Log.d(TAG, "onAreaFailure: " + e);
    }

    @Override
    public void onCinemaByRegionSuccess(CinemaBean cinemaBean) {
        Log.d(TAG, "onCinemaByRegionSuccess: " + cinemaBean);
        if (cinemaBean.getResult()==null){
            Toast.makeText(getActivity(),"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recy2Area.setLayoutManager(linearLayoutManager);
            result1 = cinemaBean.getResult();
            MyRecyAdapter02 myRecyAdapter02 = new MyRecyAdapter02(result1, getContext());
            recy2Area.setAdapter(myRecyAdapter02);
            myRecyAdapter02.setmOnClickListener(new MyRecyAdapter02.onClickListener() {
                @Override
                public void click(int id) {
                    Intent intent = new Intent(getActivity(), YyxiangqingActivity.class);
                    intent.putExtra("cinemaId", id);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onCinemaByRegionFailure(Throwable e) {
        Log.d(TAG, "onCinemaByRegionFailure: " + e.getMessage().toString());
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
}
