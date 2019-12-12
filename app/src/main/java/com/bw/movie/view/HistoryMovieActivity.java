package com.bw.movie.view;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.FKBean;
import com.bw.movie.bean.HeadBean;
import com.bw.movie.bean.LookedBean;
import com.bw.movie.bean.MyBean;
import com.bw.movie.bean.MyPBean;
import com.bw.movie.bean.MyYuBean;
import com.bw.movie.bean.PJBean;
import com.bw.movie.bean.PJYYBean;
import com.bw.movie.bean.PiaoBean;
import com.bw.movie.bean.PwdBean;
import com.bw.movie.bean.SearchYYBean;
import com.bw.movie.bean.XTBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.contract.IContract3;
import com.bw.movie.presenter.HomePresenter3;
import com.bw.movie.utils.MyHistoryAdapter;
import com.bw.mvp.base.BaseActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;
/**
 *@describe(描述)：看过的电影
 *@data（日期）: 2019/12/4
 *@time（时间）: 19:45
 *@author（作者）: xin
 **/
public class HistoryMovieActivity extends BaseActivity<HomePresenter3> implements IContract3.IView {

    private static final String TAG = "HistoryMovieActivity";
    @BindView(R.id.img_back_history_movie)
    ImageView imgBackHistoryMovie;
    @BindView(R.id.x_recycler_history)
    XRecyclerView xRecyclerHistory;
    private String sessionId;
    private int userId;

    @Override
    protected HomePresenter3 providePresenter() {
        return new HomePresenter3();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_history_movie;
    }

    @Override
    protected void initView() {
        super.initView();
        //下拉刷新,上拉加载
        xRecyclerHistory.setPullRefreshEnabled(true);

        xRecyclerHistory.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getLookedP(userId,sessionId);
                xRecyclerHistory.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xRecyclerHistory.loadMoreComplete();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        mPresenter.getLookedP(userId, sessionId);
    }

    @Override
    public void onMPJSuccess(PJBean pjBean) {

    }

    @Override
    public void onMPJFailure(Throwable e) {

    }

    @Override
    public void onCPJSuccess(PJYYBean pjyyBean) {

    }

    @Override
    public void onCPJFailure(Throwable e) {

    }

    @Override
    public void onPiaoSuccess(PiaoBean piaoBean) {

    }

    @Override
    public void onPiaoFailure(Throwable e) {

    }

    @Override
    public void onMyPiaoSuccess(MyPBean myPBean) {

    }

    @Override
    public void onMyPiaoFailure(Throwable e) {

    }

    @Override
    public void onLookedSuccess(LookedBean lookedBean) {
        Log.d(TAG, "onLookedSuccess: "+lookedBean);
        if (lookedBean.getStatus().equals("9999")){
            Toast.makeText(this,"请先登录",Toast.LENGTH_SHORT).show();
        }else if (lookedBean.getStatus().equals("0000")){
            if (lookedBean.getResult()==null){
                Toast.makeText(this,"暂无看过电影",Toast.LENGTH_SHORT).show();
            }else {
                List<LookedBean.ResultBean> result = lookedBean.getResult();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                xRecyclerHistory.setLayoutManager(linearLayoutManager);
                MyHistoryAdapter myHistoryAdapter = new MyHistoryAdapter(this,result);
                xRecyclerHistory.setAdapter(myHistoryAdapter);
            }
        }
    }

    @Override
    public void onLookedFailure(Throwable e) {
        Log.d(TAG, "onLookedFailure: "+e.getMessage().toString());
    }

    @Override
    public void onXTXXSuccess(XTBean xtBean) {

    }

    @Override
    public void onXTXXFailure(Throwable e) {

    }

    @Override
    public void onMySuccess(MyBean myBean) {

    }

    @Override
    public void onMyFailure(Throwable e) {

    }

    @Override
    public void onHeadSuccess(HeadBean headBean) {

    }

    @Override
    public void onHeadFailure(Throwable e) {

    }

    @Override
    public void onBirthSuccess(BirthBean birthBean) {

    }

    @Override
    public void onBirthFailure(Throwable e) {

    }

    @Override
    public void onFKSuccess(FKBean fkBean) {

    }

    @Override
    public void onFKFailure(Throwable e) {

    }

    @Override
    public void onMyYuSuccess(MyYuBean myYuBean) {

    }

    @Override
    public void onMyYuFailure(Throwable e) {

    }

    @Override
    public void onPWDSuccess(PwdBean pwdBean) {

    }

    @Override
    public void onPWDFailure(Throwable e) {

    }

    @Override
    public void onYYSSSuccess(SearchYYBean searchYYBean) {

    }

    @Override
    public void onYYSSFailure(Throwable e) {

    }

    @OnClick(R.id.img_back_history_movie)
    public void onViewClicked() {
        finish();
    }
}
