package com.bw.movie.view;

import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.bw.movie.utils.EmailMessageAdapter;
import com.bw.mvp.base.BaseActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：系统信息
 * @data（日期）: 2019/12/5
 * @time（时间）: 20:42
 * @author（作者）: xin
 **/
public class EmailMessageActivity extends BaseActivity<HomePresenter3> implements IContract3.IView {
    private static final String TAG = "EmailMessageActivity";
    int page = 1;
    @BindView(R.id.write_relation)
    ImageView writeRelation;
    @BindView(R.id.xrecy_email)
    XRecyclerView xrecyEmail;

    @Override
    protected HomePresenter3 providePresenter() {
        return new HomePresenter3();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_email_message;
    }

    @Override
    protected void initView() {
        super.initView();
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        String sessionId = sp.getString("s", "");
        int userId = sp.getInt("u", 0);
        mPresenter.getXTXXP(userId, sessionId, page, 10);
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

    }

    @Override
    public void onLookedFailure(Throwable e) {

    }

    @Override
    public void onXTXXSuccess(XTBean xtBean) {
        Log.d(TAG, "onXTXXSuccess: " + xtBean);
        if (xtBean.getStatus().equals("9999")) {
            Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
        }
        if (xtBean.getStatus().equals("0000")) {
            if (xtBean.getResult() == null) {
                Toast.makeText(this, "暂无系统消息", Toast.LENGTH_SHORT).show();
            } else {
                List<XTBean.ResultBean> result = xtBean.getResult();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(EmailMessageActivity.this);
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                xrecyEmail.setLayoutManager(linearLayoutManager);
                xrecyEmail.setAdapter(new EmailMessageAdapter(result, EmailMessageActivity.this));
                xrecyEmail.setPullRefreshEnabled(true);
                xrecyEmail.setLoadingMoreEnabled(true);
                xrecyEmail.setLoadingListener(new XRecyclerView.LoadingListener() {
                    @Override
                    public void onRefresh() {
                        page = 1;
                        xrecyEmail.refreshComplete();
                    }

                    @Override
                    public void onLoadMore() {
                        page++;
                        xrecyEmail.loadMoreComplete();
                    }
                });
            }
        } else {
            Toast.makeText(this, "" + xtBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onXTXXFailure(Throwable e) {
        Log.d(TAG, "onXTXXFailure: " + e.getMessage().toString());
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

    @OnClick(R.id.write_relation)
    public void onViewClicked() {
        finish();
    }
}
