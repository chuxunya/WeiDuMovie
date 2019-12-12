package com.bw.movie.view;

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
import com.bw.movie.utils.ZzryQiAdapter;
import com.bw.mvp.base.BaseFragment;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @describe(描述)：FragZzry
 * @data（日期）: 2019/12/4
 * @time（时间）: 21:03
 * @author（作者）: xin
 **/
public class FragZzry extends BaseFragment<HomePresenter> implements IContract.IView {

    private static final String TAG = "FragZzry";
    @BindView(R.id.recy_zzry)
    RecyclerView recyZzry;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_zzry;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getNowData(1,10);
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
        Log.d(TAG, "onNowSuccess: "+nowReBean);
        if (nowReBean.getStatus().equals("0000")){
            if (nowReBean.getResult()==null){
                Toast.makeText(getActivity(),"暂无数据",Toast.LENGTH_SHORT).show();
            }else {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyZzry.setLayoutManager(linearLayoutManager);
                List<NowReBean.ResultBean> result = nowReBean.getResult();
                recyZzry.setAdapter(new ZzryQiAdapter(result,getActivity()));
            }
        }else {
            Toast.makeText(getActivity(), ""+nowReBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNowFailure(Throwable e) {
        Log.d(TAG, "onNowFailure: "+e.getMessage().toString());
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
