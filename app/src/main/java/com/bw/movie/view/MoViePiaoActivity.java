package com.bw.movie.view;

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.bw.movie.utils.MyMoviePiaoAdapter;
import com.bw.mvp.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：电影票
 * @data（日期）: 2019/12/4
 * @time（时间）: 13:37
 * @author（作者）: xin
 **/
public class MoViePiaoActivity extends BaseActivity<HomePresenter3> implements IContract3.IView {

    private static final String TAG = "MoViePiaoActivity";

    @BindView(R.id.x_recycler_moviepiao)
    XRecyclerView xRecyclerMoviepiao;
    @BindView(R.id.img_qupiao)
    SimpleDraweeView imgQupiao;
    @BindView(R.id.bt_qupiao)
    Button btQupiao;
    @BindView(R.id.linear_qupiao)
    LinearLayout linearQupiao;
    @BindView(R.id.relay01)
    RelativeLayout relay01;
    @BindView(R.id.relay02)
    RelativeLayout relay02;
    @BindView(R.id.details_back)
    ImageView detailsBack;
    private List<MyPBean.ResultBean> result;
    private String sessionId;
    private int userId;
    int page=1;

    @Override
    protected HomePresenter3 providePresenter() {
        return new HomePresenter3();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mo_vie_piao;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        mPresenter.getMyPiaoP(userId, sessionId);

        //下拉刷新,上拉加载
        xRecyclerMoviepiao.setPullRefreshEnabled(true);

        xRecyclerMoviepiao.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.getMyPiaoP(userId, sessionId);
                xRecyclerMoviepiao.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getMyPiaoP(userId, sessionId);
                xRecyclerMoviepiao.loadMoreComplete();
            }
        });
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
        Log.d(TAG, "onPiaoSuccess: " + piaoBean.getMessage().toString());
        if (piaoBean.getResult()==null){
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }else {
            Uri parse = Uri.parse(piaoBean.getResult().getExchangeCode());
            imgQupiao.setImageURI(parse);
        }
    }

    @Override
    public void onPiaoFailure(Throwable e) {
        Log.d(TAG, "onPiaoFailure: " + e.getMessage().toString());
    }

    @Override
    public void onMyPiaoSuccess(MyPBean myPBean) {
        Log.d(TAG, "onMyPiaoSuccess: " + myPBean);
        if (myPBean.getStatus().equals("9999")){
            Toast.makeText(this,"请先登录",Toast.LENGTH_SHORT).show();
        }else if (myPBean.getStatus().equals("0000")){
            if (myPBean.getResult()==null){
                Toast.makeText(this,"暂无我的电影票",Toast.LENGTH_SHORT).show();
            }else {
                result = myPBean.getResult();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                xRecyclerMoviepiao.setLayoutManager(linearLayoutManager);
                MyMoviePiaoAdapter myMoviePiao = new MyMoviePiaoAdapter(this, result);
                xRecyclerMoviepiao.setAdapter(myMoviePiao);
                myMoviePiao.setOnItemPiaoClickListener(new MyMoviePiaoAdapter.OnItemPiaoClickListener() {
                    @Override
                    public void onItem(int recordId) {
                        mPresenter.getPiaoP(userId, sessionId, recordId);
                        linearQupiao.setVisibility(View.VISIBLE);
                        relay02.setVisibility(View.GONE);
                    }
                });
                btQupiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        linearQupiao.setVisibility(View.GONE);
                        relay02.setVisibility(View.VISIBLE);
                    }
                });
            }
        }
    }

    @Override
    public void onMyPiaoFailure(Throwable e) {
        Log.d(TAG, "onMyPiaoFailure: " + e.getMessage().toString());
    }

    @Override
    public void onLookedSuccess(LookedBean lookedBean) {

    }

    @Override
    public void onLookedFailure(Throwable e) {

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

    @OnClick(R.id.details_back)
    public void onViewClicked() {
        finish();
    }
}
