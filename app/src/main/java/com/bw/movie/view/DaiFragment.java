package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.app.MainApplication;
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
import com.bw.mvp.base.BaseFragment;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

/**
 * @describe(描述)：DaiFragment
 * @data（日期）: 2019/11/29
 * @time（时间）: 16:08
 * @author（作者）: xin
 **/
public class DaiFragment extends BaseFragment<HomePresenter2> implements IContract2.IView {

    private static final String TAG = "DaiFragment";
    @BindView(R.id.recy_dai)
    RecyclerView recyDai;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.wechat)
    CheckBox wechat;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.zfb)
    CheckBox zfb;
    @BindView(R.id.pay)
    LinearLayout pay;
    @BindView(R.id.pay_btn)
    Button payBtn;
    @BindView(R.id.rela)
    RelativeLayout rela;

    private List<ReCodeBean.ResultBean> list;
    int id;
    private String sessionId;
    private int userId;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_dai;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        mPresenter.getRecodeP(userId, sessionId, 1, 10, 1);
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
                MyRecyAdapterD myRecyAdapterD = new MyRecyAdapterD(list, getActivity());
                recyDai.setAdapter(myRecyAdapterD);

                myRecyAdapterD.setOnClickListener(new MyRecyAdapterD.OnClickListener() {
                    @Override
                    public void onclick(String orderId, double price, int id2) {
                        if (id2 == 2) {
                            pay.setVisibility(View.VISIBLE);
                            payBtn.setVisibility(View.VISIBLE);
                            payBtn.setText("￥" + price);
                            wechat.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    wechat.setChecked(true);
                                    zfb.setChecked(false);
                                    id = 1;
                                    payBtn.setText("微信支付￥ " + price);
                                }
                            });
                            zfb.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    zfb.setChecked(true);
                                    wechat.setChecked(false);
                                    id = 2;
                                    payBtn.setText("支付宝支付￥ " + price);
                                }
                            });
                            SharedPreferences movie = getActivity().getSharedPreferences("movie", MODE_PRIVATE);
                            String sessionId = movie.getString("s", "");
                            int userId = movie.getInt("u", 0);
                            payBtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mPresenter.getPayP(userId, sessionId, id, orderId);
                                }
                            });
                        } else {
                            pay.setVisibility(View.GONE);
                            payBtn.setVisibility(View.GONE);
                            Intent intent = new Intent(getActivity(), DXiangActivity.class);
                            intent.putExtra("orderId", orderId);
                            startActivity(intent);
                        }
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
        Log.d(TAG, "onPaySuccess: " + payBean);
        if (payBean.getStatus().equals("0000")) {
            PayReq payReq = new PayReq();
            payReq.appId = payBean.getAppId();
            payReq.nonceStr = payBean.getNonceStr();
            payReq.partnerId = payBean.getPartnerId();
            payReq.prepayId = payBean.getPrepayId();
            payReq.sign = payBean.getSign();
            payReq.timeStamp = payBean.getTimeStamp();
            payReq.packageValue = payBean.getPackageValue();
            payReq.extData = "app data";
            MainApplication.api.sendReq(payReq);
            pay.setVisibility(View.GONE);
            payBtn.setVisibility(View.GONE);
            mPresenter.getRecodeP(userId, sessionId, 1, 5, 1);
            Toast.makeText(getActivity(), "支付成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPayFailure(Throwable e) {
        Log.d(TAG, "onPayFailure: " + e.getMessage());
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

    @OnClick(R.id.rela)
    public void onViewClicked() {
        pay.setVisibility(View.GONE);
        payBtn.setVisibility(View.GONE);
    }
}
