package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.view.MovieActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @describe(描述)：MainActivity
 * @data（日期）: 2019/11/11
 * @time（时间）: 21:24
 * @author（作者）: xin
 **/
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv)
    TextView tv;
    private int count = 3;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (count < 0) {
                startActivity(new Intent(MainActivity.this, MovieActivity.class));
                finish();
            } else {
                tv.setText(count + "S");
                count--;
                handler.sendEmptyMessageDelayed(99, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
            }
        });
        handler.sendEmptyMessageDelayed(99, 1000);

    }
}
