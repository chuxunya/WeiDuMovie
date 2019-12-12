package com.bw.movie.view;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.movie.R;
import com.bw.movie.bean.AreaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Choose_day_bean;
import com.bw.movie.bean.Choose_qy_Bean;
import com.bw.movie.bean.CinemaBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.DayBean;
import com.bw.movie.bean.FuBean;
import com.bw.movie.bean.GZMBean;
import com.bw.movie.bean.JiUpBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.NowReBean;
import com.bw.movie.bean.Price_Cinema_Bean;
import com.bw.movie.bean.QGZMBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.RemenBean;
import com.bw.movie.bean.TuiBean;
import com.bw.movie.bean.WXBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.YYBean;
import com.bw.movie.contract.IContract;
import com.bw.movie.presenter.HomePresenter;
import com.bw.movie.utils.MyAdapter;
import com.bw.mvp.base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import static android.content.Context.MODE_PRIVATE;
import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * @describe(描述)：FragMovie
 * @data（日期）: 2019/11/15
 * @time（时间）: 14:10
 * @author（作者）: xin
 **/
public class FragMovie extends BaseFragment<HomePresenter> implements IContract.IView {
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private int GPS_REQUEST_CODE = 10;
    @BindView(R.id.position)
    ImageView position;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.xrecycler_movie)
    RecyclerView xrecyclerMovie;
    private List<NowReBean.ResultBean> yingBeanResult;
    private List<JiUpBean.ResultBean> jyresult;
    private List<RemenBean.ResultBean> hotresult;
    private List<BannerBean.ResultBean> bannerBeanResult;
    private String district;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    int page = 1;
    private String sessionId;
    private int userId;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_movie;
    }

    @Override
    protected void initView() {
        super.initView();
        SharedPreferences sp = getActivity().getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        mPresenter.getBannerData();
        mPresenter.getNowData(page, 10);
        mPresenter.getUpPresenter(userId, sessionId, page, 3);
        mPresenter.getRemenData(page, 4);
        sp = getActivity().getSharedPreferences("position", MODE_PRIVATE);
        edit = sp.edit();

        if (sp != null) {
            city.setText(sp.getString("district", "") + "");
        }
        position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
                    //开启定位权限,200是标识码
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
                } else {
                    MyLocation(getActivity());//开始定位
                }

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

        smart.setEnableRefresh(true);

        smart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                mPresenter.getBannerData();
                mPresenter.getNowData(page, 10);
                mPresenter.getUpPresenter(userId,sessionId,page, 3);
                mPresenter.getRemenData(page, 4);
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void onLoginFailure(Throwable e) {

    }

    @Override
    public void onResSuccess(RegisterBean registerBean) {

    }

    @Override
    public void onResFailure(Throwable e) {

    }

    @Override
    public void onCodeSuccess(CodeBean codeBean) {

    }

    @Override
    public void onCodeFailure(Throwable e) {

    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {
        bannerBeanResult = bannerBean.getResult();
        Log.d("asasas", "onBannerSuccess: " + bannerBean.getMessage());
        if (bannerBean.getResult() == null) {
            Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            xrecyclerMovie.setLayoutManager(linearLayoutManager);
            MyAdapter myAdapter = new MyAdapter(bannerBeanResult, yingBeanResult, jyresult, hotresult, getActivity());
            xrecyclerMovie.setAdapter(myAdapter);
        }
    }

    @Override
    public void onBannerFailure(Throwable e) {
        Log.d(TAG, "onBannerFailure: " + e);
    }

    @Override
    public void onNowSuccess(NowReBean nowReBean) {
        yingBeanResult = nowReBean.getResult();
        if (nowReBean.getResult() == null) {
            Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            xrecyclerMovie.setLayoutManager(linearLayoutManager);
            MyAdapter myAdapter = new MyAdapter(bannerBeanResult, yingBeanResult, jyresult, hotresult, getActivity());
            xrecyclerMovie.setAdapter(myAdapter);

        }
    }

    @Override
    public void onNowFailure(Throwable e) {
        Log.d(TAG, "onNowFailure: " + e);
    }

    @Override
    public void onUpSuccess(JiUpBean jiUpBean) {
        Log.d(TAG, "onUpSuccess: " + jiUpBean);
        jyresult = jiUpBean.getResult();
        if (jiUpBean.getResult() == null) {
            Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            xrecyclerMovie.setLayoutManager(linearLayoutManager);
            MyAdapter myAdapter = new MyAdapter(bannerBeanResult, yingBeanResult, jyresult, hotresult, getActivity());
            xrecyclerMovie.setAdapter(myAdapter);
            myAdapter.setOnClickListener(new MyAdapter.OnClickListener() {
                @Override
                public void click(int position) {
                    mPresenter.getYYData(userId, sessionId, position);
                }
            });
        }
    }

    @Override
    public void onUpFailure(Throwable e) {
        Log.d(TAG, "onUpFailure: " + e);
    }

    @Override
    public void onRemenSuccess(RemenBean remenBean) {
        hotresult = remenBean.getResult();
        if (remenBean.getResult() == null) {
            Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            xrecyclerMovie.setLayoutManager(linearLayoutManager);
            MyAdapter myAdapter = new MyAdapter(bannerBeanResult, yingBeanResult, jyresult, hotresult, getActivity());
            xrecyclerMovie.setAdapter(myAdapter);
        }
    }

    @Override
    public void onRemenFailure(Throwable e) {

    }

    @Override
    public void onAreaSuccess(AreaBean areaBean) {

    }

    @Override
    public void onAreaFailure(Throwable e) {

    }

    @Override
    public void onCinemaByRegionSuccess(CinemaBean cinemaBean) {

    }

    @Override
    public void onCinemaByRegionFailure(Throwable e) {

    }

    @Override
    public void onTuiCinemaSuccess(TuiBean tuiBean) {

    }

    @Override
    public void onTuiCinemaFailure(Throwable e) {

    }

    @Override
    public void onFuCinemaSuccess(FuBean fuBean) {

    }

    @Override
    public void onFuCinemaFailure(Throwable e) {

    }

    @Override
    public void onXiangSuccess(XiangBean xiangBean) {
        Log.d(TAG, "onXiangSuccess: " + xiangBean);
    }

    @Override
    public void onXiangFailure(Throwable e) {
        Log.d(TAG, "onXiangFailure: " + e.getMessage().toString());
    }

    @Override
    public void onQYSuccess(Choose_qy_Bean choose_qy_bean) {

    }

    @Override
    public void onQYFailure(Throwable e) {

    }

    @Override
    public void onDaySuccess(DayBean dayBean) {

    }

    @Override
    public void onDayFailure(Throwable e) {

    }

    @Override
    public void onDSuccess(Choose_day_bean dayBean) {

    }

    @Override
    public void onDFailure(Throwable e) {

    }

    @Override
    public void onPriceSuccess(Price_Cinema_Bean price_cinema_bean) {

    }

    @Override
    public void onPriceFailure(Throwable e) {

    }

    @Override
    public void onWXSuccess(WXBean wxBean) {

    }

    @Override
    public void onWXFailure(Throwable e) {

    }

    @Override
    public void onGZMSuccess(GZMBean gzmBean) {

    }

    @Override
    public void onGZMFailure(Throwable e) {

    }

    @Override
    public void onQGZMSuccess(QGZMBean qgzmBean) {

    }

    @Override
    public void onQGZMFailure(Throwable e) {

    }

    @Override
    public void onYYSuccess(YYBean yyBean) {
        Log.d(TAG, "onYYSuccess: " + yyBean);
        Toast.makeText(getActivity(), yyBean.getMessage(), Toast.LENGTH_SHORT).show();
        mPresenter.getUpPresenter(userId, sessionId, page, 3);
    }

    @Override
    public void onYYFailure(Throwable e) {
        Log.d(TAG, "onYYFailure: " + e);
    }

    /*
     * 定位 判断是否开启权限
     * 有 执行
     * 无 弹框提示进入设置开启权限
     * */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200://刚才的识别码
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//用户同意权限,执行我们的操作
                    MyLocation(getActivity());//开始定位
                } else {//用户拒绝之后,当然我们也可以弹出一个窗口,直接跳转到系统设置页面
                    Toast.makeText(getActivity(), "未开启定位权限,请手动到设置去开启权限", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    /*
     * 定位成功回调信息，设置相关消息
     * */
    public void MyLocation(Context context) {
        mlocationClient = new AMapLocationClient(context);
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                try {
                    if (amapLocation != null) {
                        if (amapLocation.getErrorCode() == 0) {
                            //定位成功回调信息，设置相关消息

                            //获取当前定位结果来源，如网络定位结果，详见定位类型表
                            Log.i("定位类型", amapLocation.getLocationType() + "");
                            Log.i("获取纬度", amapLocation.getLatitude() + "");
                            Log.i("获取经度", amapLocation.getLongitude() + "");
                            Log.i("获取精度信息", amapLocation.getAccuracy() + "");
                            //如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                            Log.i("地址", amapLocation.getAddress());
                            Log.i("国家信息", amapLocation.getCountry());
                            Log.i("省信息", amapLocation.getProvince());
                            Log.i("城市信息", amapLocation.getCity());
                            Log.i("城区信息", amapLocation.getDistrict());
                            Log.i("街道信息", amapLocation.getStreet());
                            Log.i("街道门牌号信息", amapLocation.getStreetNum());
                            Log.i("城市编码", amapLocation.getCityCode());
                            Log.i("地区编码", amapLocation.getAdCode());
                            Log.i("获取当前定位点的AOI信息", amapLocation.getAoiName());
                            Log.i("获取当前室内定位的建筑物Id", amapLocation.getBuildingId());
                            Log.i("获取当前室内定位的楼层", amapLocation.getFloor());
                            Log.i("获取GPS的当前状态", amapLocation.getGpsAccuracyStatus() + "");
                            //获取定位时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date(amapLocation.getTime());
                            Log.i("获取定位时间", df.format(date));
                            district = amapLocation.getStreet() + " " + amapLocation.getStreetNum();
                            city.setText(district);
                            edit.putString("district", district).commit();
                            // 停止定位
                            mlocationClient.stopLocation();
                        } else {
                            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                            Log.e("AmapError", "location Error, ErrCode:"
                                    + amapLocation.getErrorCode() + ", errInfo:"
                                    + amapLocation.getErrorInfo());
                            Toast.makeText(getActivity(), "没有权限，请打开权限...", Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("定位服务未开启")
                                    .setMessage("请在系统设置中开启定位服务\n" +
                                            "以便为您提供更好的服务")
                                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivityForResult(intent, GPS_REQUEST_CODE);
                                        }
                                    })
                                    .show();
                        }
                    }
                } catch (Exception e) {
                }

            }
        });
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(5000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        //启动定位
        mlocationClient.startLocation();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);

        } else {
            MyLocation(getActivity());//开始定位
            //Toast.makeText(getActivity(),"已开启定位权限",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // 停止定位
        if (null != mlocationClient) {
            mlocationClient.stopLocation();
        }

    }

    //内存泄露和定位
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mlocationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            mlocationClient.onDestroy();
            mlocationClient = null;
        }
    }
}
