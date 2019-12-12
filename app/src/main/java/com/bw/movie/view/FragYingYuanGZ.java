package com.bw.movie.view;

import android.content.Context;
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
import com.bw.movie.utils.MyYingYuanGuanZhuAdapter;
import com.bw.mvp.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @describe(描述)：关注的影院
 * @data（日期）: 2019/12/2
 * @time（时间）: 21:24
 * @author（作者）: xin
 **/
public class FragYingYuanGZ extends BaseFragment<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "FragYingYuanGZ";
    @BindView(R.id.yingyuan_gz)
    XRecyclerView yingyuanGz;
    @BindView(R.id.nolike)
    ImageView nolike;
    @BindView(R.id.nono)
    TextView nono;
    int page =1;
    private String sessionId;
    private int userId;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_frag_ying_yuan_gz;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        mPresenter.getGCP(userId, sessionId, page, 10);
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

    }

    @Override
    public void onGMFailure(Throwable e) {

    }

    @Override
    public void onGcSuccess(GCinemaBeam gCinemaBeam) {
        Log.d(TAG, "onGcSuccess: " + gCinemaBeam);
        if (gCinemaBeam.getStatus().equals("9999")){
            Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
        }else if (gCinemaBeam.getStatus().equals("0000")){
            if (gCinemaBeam.getResult()==null){
                nolike.setVisibility(View.VISIBLE);
                nono.setVisibility(View.VISIBLE);
            }else {
                List<GCinemaBeam.ResultBean> result = gCinemaBeam.getResult();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                yingyuanGz.setLayoutManager(linearLayoutManager);
                MyYingYuanGuanZhuAdapter myYingYuanGuanZhuAdapter = new MyYingYuanGuanZhuAdapter(result, getActivity());
                yingyuanGz.setAdapter(myYingYuanGuanZhuAdapter);
                yingyuanGz.setLoadingMoreEnabled(true);
                yingyuanGz.setPullRefreshEnabled(true);
                yingyuanGz.setLoadingListener(new XRecyclerView.LoadingListener() {
                    @Override
                    public void onRefresh() {
                        page=1;
                        yingyuanGz.refreshComplete();
                    }

                    @Override
                    public void onLoadMore() {
                        page++;
                        yingyuanGz.loadMoreComplete();
                    }
                });
                myYingYuanGuanZhuAdapter.setOnClickListener(new MyYingYuanGuanZhuAdapter.OnClickListener() {
                    @Override
                    public void onclick(int id) {
                        mPresenter.getQGZCData(userId,sessionId,id);
                    }
                });

            }
        }
    }

    @Override
    public void onGcFailure(Throwable e) {
        Log.d(TAG, "onGcFailure: " + e.getMessage().toString());
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
        Log.d(TAG, "onQGZCSuccess: "+qgzcBean);
        if (qgzcBean.getStatus().equals("0000")){
            mPresenter.getGCP(userId, sessionId, page, 10);
        }
    }

    @Override
    public void onQGZCFailure(Throwable e) {
        Log.d(TAG, "onQGZCFailure: "+e.getMessage());
    }
}
