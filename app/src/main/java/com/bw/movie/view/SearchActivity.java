package com.bw.movie.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.bw.movie.utils.RecyclerDyssgAdapter;
import com.bw.mvp.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：首页搜索
 * @data（日期）: 2019/12/2
 * @time（时间）: 17:18
 * @author（作者）: xin
 **/
public class SearchActivity extends BaseActivity<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "SearchActivity";
    @BindView(R.id.image_dy_ss)
    ImageView imageDySs;
    @BindView(R.id.edit_dy_sousuo)
    EditText editDySousuo;
    @BindView(R.id.recycler_dy_sousuo)
    RecyclerView recyclerDySousuo;
    @BindView(R.id.nosearch)
    ImageView nosearch;
    @BindView(R.id.nono)
    TextView nono;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initData() {
        super.initData();
        editDySousuo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i(TAG, "afterTextChanged: " + editable);
                mPresenter.getDyssPresenter(editable.toString(), "1", "20");
            }
        });
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
        Log.d(TAG, "onDyssSuccess: " + bean);
        if (bean.getMessage().equals("未查到相关电影")) {
            nono.setVisibility(View.VISIBLE);
            nosearch.setVisibility(View.VISIBLE);
            recyclerDySousuo.setVisibility(View.GONE);
        }else {
            nono.setVisibility(View.GONE);
            nosearch.setVisibility(View.GONE);
            recyclerDySousuo.setVisibility(View.VISIBLE);
            List<SearchBean.ResultBean> list = new ArrayList<>();
            for (int i = 0; i < bean.getResult().size(); i++) {
                list.add(bean.getResult().get(i));
            }
            RecyclerDyssgAdapter adapter = new RecyclerDyssgAdapter(list, SearchActivity.this);
            recyclerDySousuo.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
            recyclerDySousuo.setAdapter(adapter);
        }
    }

    @Override
    public void onDyssFailure(Throwable e) {
        Log.d(TAG, "onDyssFailure: " + e.getMessage().toString());
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

    @OnClick(R.id.image_dy_ss)
    public void onViewClicked() {
        finish();
    }
}
