package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
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
import com.bw.movie.utils.MyRecyAdapterD;
import com.bw.movie.utils.MyRecyAdapterO;
import com.bw.mvp.base.BaseFragment;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import static android.content.Context.MODE_PRIVATE;

/**
 * @describe(描述)：OverFragment
 * @data（日期）: 2019/11/29
 * @time（时间）: 16:09
 * @author（作者）: xin
 **/
public class OverFragment extends BaseFragment<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "OverFragment";
    @BindView(R.id.recy_dai)
    RecyclerView recyDai;
    @BindView(R.id.text)
    TextView text;
    private List<ReCodeBean.ResultBean> list;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_over;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("movie", MODE_PRIVATE);
        String sessionId = sp.getString("s", "");
        int userId = sp.getInt("u", 0);
        mPresenter.getRecodeP(userId, sessionId, 1, 10, 2);
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
        Log.d(TAG, "onRecodeSuccess: " + reCodeBean);
        if (reCodeBean.getStatus().equals("9999")){
            Toast.makeText(getActivity(),"请先登录",Toast.LENGTH_SHORT).show();
        }else if (reCodeBean.getStatus().equals("0000")){
            if (reCodeBean.getMessage().contains("无购票记录")) {
                text.setVisibility(View.VISIBLE);
            } else {
                list = reCodeBean.getResult();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyDai.setLayoutManager(linearLayoutManager);
                MyRecyAdapterO myRecyAdaptero = new MyRecyAdapterO(list, getActivity());
                recyDai.setAdapter(myRecyAdaptero);
                myRecyAdaptero.setOnClickListener(new MyRecyAdapterO.OnClickListener() {
                    @Override
                    public void onclick(String orderId) {
                        Intent intent = new Intent(getActivity(),MXiangActivity.class);
                        intent.putExtra("orderId",orderId);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public void onRecodeFailure(Throwable e) {
        Log.d(TAG, "onRecodeFailure: " + e.getMessage().toString());
    }
    @Override
    public void onPaySuccess(PayBean payBean) {

    }

    @Override
    public void onPayFailure(Throwable e) {

    }

    @Override
    public void onMXSuccess(MovieXBean movieXBean) {
        Log.d(TAG, "onMXSuccess: "+movieXBean);
    }

    @Override
    public void onMXFailure(Throwable e) {
        Log.d(TAG, "onMXFailure: "+e.getMessage().toString());
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
