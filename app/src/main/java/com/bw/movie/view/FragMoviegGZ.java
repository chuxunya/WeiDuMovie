package com.bw.movie.view;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
import com.bw.movie.utils.MyGuanZhuAdapter;
import com.bw.mvp.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @describe(描述)：关注电影
 * @data（日期）: 2019/12/2
 * @time（时间）: 21:24
 * @author（作者）: xin
 **/
public class FragMoviegGZ extends BaseFragment<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "FragMoviegGZ";
    @BindView(R.id.movie_gz)
    XRecyclerView movieGz;
    @BindView(R.id.nolike)
    ImageView nolike;
    @BindView(R.id.nono)
    TextView nono;
    int page=1;
    private String sessionId;
    private int userId;
    private SharedPreferences sp;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_frag_movieg_gz;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        mPresenter.getGMP(userId, sessionId, page, 10);
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
        Log.d(TAG, "onGMSuccess: " + gMovieBean);
        if (gMovieBean.getStatus().equals("9999")){
            Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
        }else if (gMovieBean.getStatus().equals("0000")){
            if (gMovieBean.getResult()==null){
                nolike.setVisibility(View.VISIBLE);
                nono.setVisibility(View.VISIBLE);
            }else {
                List<GMovieBean.ResultBean> result = gMovieBean.getResult();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                movieGz.setLayoutManager(linearLayoutManager);
                movieGz.setLoadingMoreEnabled(true);
                movieGz.setPullRefreshEnabled(true);
                MyGuanZhuAdapter myGuanZhuAdapter = new MyGuanZhuAdapter(result, getActivity());
                movieGz.setAdapter(myGuanZhuAdapter);
                movieGz.setLoadingListener(new XRecyclerView.LoadingListener() {
                    @Override
                    public void onRefresh() {
                        page=1;
                        movieGz.refreshComplete();
                    }

                    @Override
                    public void onLoadMore() {
                        page++;
                        movieGz.loadMoreComplete();
                    }
                });
                myGuanZhuAdapter.setOnClickListener(new MyGuanZhuAdapter.OnClickListener() {
                    @Override
                    public void onclick(int id) {
                        mPresenter.getQGZMData(userId,sessionId,id);
                    }
                });
            }
        }
    }

    @Override
    public void onGMFailure(Throwable e) {
        Log.d(TAG, "onGMFailure: " + e.getMessage().toString());
    }

    @Override
    public void onGcSuccess(GCinemaBeam gCinemaBeam) {

    }

    @Override
    public void onGcFailure(Throwable e) {

    }

    @Override
    public void onQGZMSuccess(QGZMBean qgzmBean) {
        Log.d(TAG, "onQGZMSuccess: "+qgzmBean);
        if (qgzmBean.getMessage().equals("取消关注成功")){
            mPresenter.getGMP(userId, sessionId, page, 10);
        }
    }

    @Override
    public void onQGZMFailure(Throwable e) {
        Log.d(TAG, "onQGZMFailure: "+e.getMessage().toString());
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
}
