package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
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
import com.bw.movie.utils.ImageUtil;
import com.bw.mvp.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @describe(描述)：我的信息
 * @data（日期）: 2019/12/6
 * @time（时间）: 9:51
 * @author（作者）: xin
 **/
public class MyActivity extends BaseActivity<HomePresenter3> implements IContract3.IView {

    private static final String TAG = "MyActivity";
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.sView_user_mine)
    SimpleDraweeView sViewUserMine;
    @BindView(R.id.tv_name_user_mine)
    TextView tvNameUserMine;
    @BindView(R.id.tv_sex_user_mine)
    TextView tvSexUserMine;
    @BindView(R.id.tv_data_user_mine)
    TextView tvDataUserMine;
    @BindView(R.id.tv_email_user_mine)
    TextView tvEmailUserMine;
    private int userId;
    private String sessionId;
    private SharedPreferences sp;
    private MultipartBody.Part image1;
    private String headPic;
    private SharedPreferences sps;
    private SharedPreferences.Editor edit;
    private static SimpleDateFormat format;

    @Override
    protected HomePresenter3 providePresenter() {
        return new HomePresenter3();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("movie", MODE_PRIVATE);
        sessionId = sp.getString("s", "");
        userId = sp.getInt("u", 0);
        if (sessionId.isEmpty() && userId == 0) {
            Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
        } else {
            mPresenter.getMyP(userId, sessionId);
        }
        sps = getSharedPreferences("sex",MODE_PRIVATE);
        edit = sps.edit();
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
        Log.d(TAG, "onMySuccess: " + myBean);
        if (myBean.getResult() == null) {
            Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
        } else {
            MyBean.ResultBean result = myBean.getResult();
            headPic = result.getHeadPic();
            sViewUserMine.setImageURI(headPic);
            tvNameUserMine.setText(result.getNickName());
            tvDataUserMine.setText("2019-12-07");

            if (sps.getString("birth", "")!=null){
                String birth = sps.getString("birth", "");
                tvDataUserMine.setText(birth);
            }
            tvSexUserMine.setText("男");
            if (sps.getInt("sex",0) == 1) {
                tvSexUserMine.setText("男");
            } else {
                tvSexUserMine.setText("女");
            }
            String s = String.valueOf(result.getLastLoginTime());

            tvEmailUserMine.setText(result.getEmail());
            sViewUserMine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, 10);
                }
            });
            tvDataUserMine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimePickerView timePickerView = new TimePickerView(MyActivity.this, TimePickerView.Type.YEAR_MONTH_DAY);
                    // 设置是否循环
                    timePickerView.setCyclic(true);
                    timePickerView.setTime(new Date());
                    timePickerView.setCyclic(false);
                    timePickerView.setCancelable(true);
                    //时间选择后回调
                    timePickerView.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

                        @Override
                        public void onTimeSelect(Date date) {
                            edit.putString("birth",getTime(date)).commit();
                            tvDataUserMine.setText(getTime(date));

                            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
                            SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
                            String sessionId = sp.getString("s", "");
                            int userId = sp.getInt("u", 0);
                            mPresenter.getBirthP(userId,sessionId,dateStr);
                        }
                    });
                    timePickerView.show();
                }
            });
            //性别
            tvSexUserMine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final ArrayList<String> sexList = new ArrayList<>();
                    //选项选择器
                    OptionsPickerView<String> pvOptions = new OptionsPickerView(MyActivity.this);
                    sexList.add("男");
                    sexList.add("女");

                    pvOptions.setPicker(sexList);
                    // 设置选项单位
                    pvOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int option2, int options3) {
                            String sex = sexList.get(options1);
                            if (sex.equals("男")){
                                edit.putInt("sex",1).commit();
                                tvSexUserMine.setText(sex);
                            }else {
                                edit.putInt("sex",2).commit();
                                tvSexUserMine.setText(sex);
                            }
                            Toast.makeText(MyActivity.this, sex, Toast.LENGTH_SHORT).show();
                        }
                    });
                    pvOptions.show();
                }
            });
        }
    }

    @Override
    public void onMyFailure(Throwable e) {
        Log.d(TAG, "onMyFailure: " + e.getMessage().toString());
    }

    @Override
    public void onHeadSuccess(HeadBean headBean) {
        Log.d(TAG, "onHeadSuccess: " + headBean);
        mPresenter.getMyP(userId, sessionId);
    }

    @Override
    public void onHeadFailure(Throwable e) {
        Log.d(TAG, "onHeadFailure: " + e.getMessage().toString());
        if (e.getMessage().equals("Permission denied")){
            Toast.makeText(this,"请打开手机权限",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBirthSuccess(BirthBean birthBean) {
        Log.d(TAG, "onBirthSuccess: "+birthBean);
        Toast.makeText(this,birthBean.getMessage(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBirthFailure(Throwable e) {
        Log.d(TAG, "onBirthFailure: "+e.getMessage().toString());
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

    public static class DateFormatUtil {
        public static String format(String date) {
            if (TextUtils.isEmpty(date))
                return null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Long time = new Long(date);
            return format.format(time);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 & resultCode == RESULT_OK) {
            if (data == null) {
                Log.d(TAG, "onActivityResult: data为空");
            } else {
                Uri uri = data.getData();
                if (uri != null) {
                    String path = ImageUtil.getPath(this, uri);
                    if (path != null) {
                        File file = new File(path);
                        RequestBody requestBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                        image1 = MultipartBody.Part.createFormData("image", file.getName(), requestBody1);
                        mPresenter.getHeadP(userId, sessionId, image1);
                    }
                }
            }
        }
    }

    //修改生日
    public static String getTime(Date date) {
        format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        Intent intent = new Intent();
        intent.putExtra("img",headPic);
        setResult(123,intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent();
            intent.putExtra("img",headPic);
            setResult(123,intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
