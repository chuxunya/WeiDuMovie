package com.bw.movie.view;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.utils.DownloadIntentService;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：UpDataActivity
 * @data（日期）: 2019/11/13
 * @time（时间）: 19:01
 * @author（作者）: xin
 **/
public class UpDataActivity extends AppCompatActivity {

    private static final int DOWNLOADAPK_ID = 10;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.details_back)
    ImageView detailsBack;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_data);
        ButterKnife.bind(this);
        //注册eventbus

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("asdaf", "onClick: ");
                if (isServiceRunning(DownloadIntentService.class.getName())) {
                    Toast.makeText(UpDataActivity.this, "正在下载", Toast.LENGTH_SHORT).show();
                    return;
                }
                String downloadUrl = "/media/movie.apk";
                intent = new Intent(UpDataActivity.this, DownloadIntentService.class);
                Bundle bundle = new Bundle();
                bundle.putString("download_url", downloadUrl);
                bundle.putInt("download_id", DOWNLOADAPK_ID);
                bundle.putString("download_file", downloadUrl.substring(downloadUrl.lastIndexOf('/') + 1));
                intent.putExtras(bundle);
                startService(intent);
            }
        });
    }


    //关闭服务 停止下载
    public void stopFinishSer() {

    }

    /**
     * 用来判断服务是否运行.
     *
     * @param className 判断的服务名字
     * @return true 在运行 false 不在运行
     */
    private boolean isServiceRunning(String className) {

        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) this
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager
                .getRunningServices(Integer.MAX_VALUE);
        if (!(serviceList.size() > 0)) {
            return false;
        }
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }


    @OnClick(R.id.details_back)
    public void onViewClicked() {
        finish();
    }
}
