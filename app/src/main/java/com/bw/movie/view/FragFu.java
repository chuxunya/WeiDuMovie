package com.bw.movie.view;

import android.content.Intent;
import android.util.Log;
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
import com.bw.movie.utils.MyShopAdapter;
import com.bw.movie.utils.MyShopAdapter2;
import com.bw.mvp.base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/*
 *@auther:王可欣
 *@Date: 2019/11/13
 *@Time:20:52
 *@Description:附近影院
 **/
public class FragFu extends BaseFragment<HomePresenter> implements IContract.IView {
    private static final String TAG = "fragfu";
    @BindView(R.id.xrecy_fu)
    RecyclerView xrecyFu;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;

    private int page = 1;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragfu;
    }

    @Override
    protected void initView() {
        super.initView();
        smart.setEnableRefresh(true);
        smart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                mPresenter.getFuCinemaPresenter(page, 10);
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getFuCinemaPresenter(page, 10);
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
        Log.d(TAG, "onFuCinemaSuccess: " + fuBean);
        if (fuBean.getResult() == null) {
            Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            xrecyFu.setLayoutManager(linearLayoutManager);
            List<FuBean.ResultBean> result = fuBean.getResult();
            MyShopAdapter2 myShopAdapter = new MyShopAdapter2(result, getContext());
            xrecyFu.setAdapter(myShopAdapter);
            myShopAdapter.setOnclickListener(new MyShopAdapter.OnclickListener() {
                @Override
                public void onclick(int cinemaId) {
                    Intent intent = new Intent(getActivity(), YyxiangqingActivity.class);
                    intent.putExtra("cinemaId", cinemaId);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onFuCinemaFailure(Throwable e) {
        Log.d(TAG, "onFuCinemaFailure: " + e);
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
