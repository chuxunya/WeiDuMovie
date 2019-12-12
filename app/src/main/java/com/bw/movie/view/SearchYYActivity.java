package com.bw.movie.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.bw.movie.utils.SouSuoYYAdapter;
import com.bw.mvp.base.BaseActivity;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @describe(描述)：影院模糊查询
 * @data（日期）: 2019/12/7
 * @time（时间）: 22:36
 * @author（作者）: xin
 **/
public class SearchYYActivity extends BaseActivity<HomePresenter3> implements IContract3.IView {

    private static final String TAG = "SearchYYActivity";
    @BindView(R.id.nosearch)
    ImageView nosearch;
    @BindView(R.id.nono)
    TextView nono;
    @BindView(R.id.image_dy_ss)
    ImageView imageDySs;
    @BindView(R.id.edit_dy_sousuo)
    EditText editDySousuo;
    @BindView(R.id.recycler_dy_sousuo)
    RecyclerView recyclerDySousuo;

    @Override
    protected HomePresenter3 providePresenter() {
        return new HomePresenter3();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_search_yy;
    }

    @Override
    protected void initView() {
        super.initView();
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
                mPresenter.getYYSSData(1,20,editable.toString());
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
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
        Log.d(TAG, "onYYSSSuccess: "+searchYYBean);
        if (searchYYBean.getResult()!=null){
            nono.setVisibility(View.GONE);
            nosearch.setVisibility(View.GONE);
            List<SearchYYBean.ResultBean> result = searchYYBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchYYActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerDySousuo.setLayoutManager(linearLayoutManager);
            recyclerDySousuo.setAdapter(new SouSuoYYAdapter(SearchYYActivity.this, result));
        }else {
            Toast.makeText(this,"暂无相关信息",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onYYSSFailure(Throwable e) {
        Log.d(TAG, "onYYSSFailure: "+e.getMessage().toString());
    }

    @OnClick(R.id.image_dy_ss)
    public void onViewClicked() {
        finish();
    }
}
