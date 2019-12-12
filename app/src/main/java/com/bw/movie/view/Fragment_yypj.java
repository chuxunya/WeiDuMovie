package com.bw.movie.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
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
import com.bw.movie.utils.RecyclerYYYingPingAdapter;
import com.bw.mvp.base.BaseFragment;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @describe(描述)：影院评价
 * @data（日期）: 2019/12/1
 * @time（时间）: 21:40
 * @author（作者）: xin
 **/
public class Fragment_yypj extends BaseFragment<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "Fragment_yypj";
    @BindView(R.id.recycler_yy_pl)
    RecyclerView recyclerYyPl;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_fragment_yypj;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        int cinemaId = intent.getIntExtra("cinemaId", 0);
        SharedPreferences sp = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        String sessionId = sp.getString("s", "");
        int userId = sp.getInt("u", 0);
        mPresenter.getYYpjP(userId,sessionId,cinemaId,1,10);
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
        Log.d(TAG, "onYYPJSuccess: " + yypjBean);
        if (yypjBean.getResult()==null){
            Toast.makeText(getActivity(),"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            List<YYPJBean.ResultBean> result = yypjBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerYyPl.setLayoutManager(linearLayoutManager);
            RecyclerYYYingPingAdapter adapter=new RecyclerYYYingPingAdapter(result,getActivity());
            recyclerYyPl.setAdapter(adapter);
        }
    }

    @Override
    public void onYYPJFailure(Throwable e) {
        Log.d(TAG, "onYYPJFailure: " + e.getMessage().toString());
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
}
