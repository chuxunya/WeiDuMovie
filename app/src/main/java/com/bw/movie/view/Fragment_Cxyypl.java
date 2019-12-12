package com.bw.movie.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
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
import com.bw.movie.bean.WXBean;
import com.bw.movie.bean.XTBean;
import com.bw.movie.bean.YYPJBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.contract.IContract3;
import com.bw.movie.presenter.HomePresenter3;
import com.bw.movie.utils.RecyclerCxyyplAdapter;
import com.bw.mvp.base.BaseFragment;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @describe(描述)：影院评价
 * @data（日期）: 2019/12/4
 * @time（时间）: 11:31
 * @author（作者）: xin
 **/
public class Fragment_Cxyypl extends BaseFragment<HomePresenter3> implements IContract3.IView {

    private static final String TAG = "Fragment_Cxyypl";
    @BindView(R.id.recycler_cxyypl)
    RecyclerView recyclerCxyypl;
    private List<PJYYBean.ResultBean> result;

    @Override
    protected HomePresenter3 providePresenter() {
        return new HomePresenter3();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_fragment__cxyypl;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        String sessionId = sp.getString("s", "");
        int userId = sp.getInt("u", 0);
        mPresenter.getCPJp(userId, sessionId, 1, 10);
    }

    @Override
    public void onMPJSuccess(PJBean pjBean) {

    }

    @Override
    public void onMPJFailure(Throwable e) {

    }

    @Override
    public void onCPJSuccess(PJYYBean pjyyBean) {
        Log.d(TAG, "onCPJSuccess: " + pjyyBean);
        if (pjyyBean.getStatus().equals("9999")){
            Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
        }else if (pjyyBean.getStatus().equals("0000")){
            if (pjyyBean.getResult()==null){
                Toast.makeText(getActivity(),"暂无影院评论",Toast.LENGTH_SHORT).show();
            }else {
                result = pjyyBean.getResult();
                RecyclerCxyyplAdapter adapter = new RecyclerCxyyplAdapter(pjyyBean.getResult(), getActivity());
                recyclerCxyypl.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerCxyypl.setAdapter(adapter);
            }
        }
    }

    @Override
    public void onCPJFailure(Throwable e) {
        Log.d(TAG, "onCPJFailure: " + e.getMessage().toString());
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

    }

    @Override
    public void onYYSSFailure(Throwable e) {

    }
}
