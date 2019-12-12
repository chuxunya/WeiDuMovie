package com.bw.movie.view;
/**
 *@describe(描述)：Fragment_yypq
 *@data（日期）: 2019/12/2
 *@time（时间）: 13:57
 *@author（作者）: xin
 **/
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.bw.movie.utils.RecyclerYypqgAdapter;
import com.bw.mvp.base.BaseFragment;

import java.util.List;

import butterknife.BindView;

public class Fragment_yypq extends BaseFragment<HomePresenter2> implements IContract2.IView {
    private static final String TAG = "Fragment_yypq";
    @BindView(R.id.recycler_yypq)
    RecyclerView recyclerYypq;
    private List<YYPQBean.ResultBean> result;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_yypq;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("id", 0);
        mPresenter.getYYPQP(id,1,10);
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
        Log.d(TAG, "onYYPQSuccess: "+yypqBean);
        if (yypqBean.getMessage().equals("查询数据为空")){
            Toast.makeText(getActivity(), "查询数据为空", Toast.LENGTH_SHORT).show();
        }else {
            result = yypqBean.getResult();
            RecyclerYypqgAdapter adapter = new RecyclerYypqgAdapter(result, getActivity());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerYypq.setLayoutManager(linearLayoutManager);
            recyclerYypq.setAdapter(adapter);
            adapter.getonClickCallBack(new RecyclerYypqgAdapter.onClickCallBack() {
                @Override
                public void getMovieId(int id) {
                    Intent intent1 = new Intent(getActivity(), XiangActivity.class);
                    intent1.putExtra("movieId",id);
                    getActivity().startActivity(intent1);
                }
            });
        }
    }

    @Override
    public void onYYPQFailure(Throwable e) {
        Log.d(TAG, "onYYPQFailure: "+e.getMessage().toString());
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
