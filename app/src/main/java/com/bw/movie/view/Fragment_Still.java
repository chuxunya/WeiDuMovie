package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.bw.movie.utils.myRecyAdapter_still;
import com.bw.mvp.base.BaseFragment;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import static android.content.Context.MODE_PRIVATE;

/*
 *@auther:王可欣
 *@Date: 2019/11/19
 *@Time:16:31
 *@Description:剧照
 **/
public class Fragment_Still extends BaseFragment<HomePresenter> implements IContract.IView {
    private static final String TAG = "剧照";
    @BindView(R.id.recy_still)
    RecyclerView recyStill;
    private List<String> posterList;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 1);
        SharedPreferences sp = getActivity().getSharedPreferences("movie", MODE_PRIVATE);
        String sessionId = sp.getString("s", "");
        int userId = sp.getInt("u", 0);
        mPresenter.getXiangP(userId,sessionId,movieId);

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_still;
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
        Log.d(TAG, "onXiangSuccess: " + xiangBean);
        if (xiangBean.getResult()==null){
            Toast.makeText(getActivity(),"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            posterList = xiangBean.getResult().getPosterList();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
            recyStill.setLayoutManager(gridLayoutManager);
            myRecyAdapter_still myRecyAdapter_still = new myRecyAdapter_still(posterList, getActivity());
            recyStill.setAdapter(myRecyAdapter_still);
        }
    }

    @Override
    public void onXiangFailure(Throwable e) {
        Log.d(TAG, "onXiangFailure: " + e.getMessage().toString());
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
