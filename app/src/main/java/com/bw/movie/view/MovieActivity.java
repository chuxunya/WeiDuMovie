package com.bw.movie.view;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bw.movie.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：MovieActivity
 * @data（日期）: 2019/11/11
 * @time（时间）: 21:24
 * @author（作者）: xin
 **/
public class MovieActivity extends AppCompatActivity {

    @BindView(R.id.yingpian)
    LinearLayout yingpian;
    @BindView(R.id.movie)
    LinearLayout movie;
    @BindView(R.id.relat_a)
    RelativeLayout relatA;
    @BindView(R.id.shapes)
    LinearLayout shapes;
    @BindView(R.id.cinema)
    LinearLayout cinema;
    @BindView(R.id.relat_b)
    RelativeLayout relatB;
    @BindView(R.id.my)
    LinearLayout my;
    @BindView(R.id.my_a)
    LinearLayout myA;
    @BindView(R.id.relat_c)
    RelativeLayout relatC;
    @BindView(R.id.pager)
    NoScrollViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        List<Fragment> list = new ArrayList<>();
        list.add(new FragMovie());
        list.add(new FragNear());
        list.add(new FragMy());
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @OnClick({R.id.relat_a, R.id.relat_b, R.id.relat_c})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relat_a:
                yingpian.setVisibility(View.VISIBLE);
                movie.setVisibility(View.GONE);
                shapes.setVisibility(View.GONE);
                cinema.setVisibility(View.VISIBLE);
                my.setVisibility(View.GONE);
                myA.setVisibility(View.VISIBLE);
                pager.setCurrentItem(0);
                break;
            case R.id.relat_b:
                yingpian.setVisibility(View.GONE);
                movie.setVisibility(View.VISIBLE);
                shapes.setVisibility(View.VISIBLE);
                cinema.setVisibility(View.GONE);
                my.setVisibility(View.GONE);
                myA.setVisibility(View.VISIBLE);
                pager.setCurrentItem(1);
                break;
            case R.id.relat_c:
                yingpian.setVisibility(View.GONE);
                movie.setVisibility(View.VISIBLE);
                shapes.setVisibility(View.GONE);
                cinema.setVisibility(View.VISIBLE);
                my.setVisibility(View.VISIBLE);
                myA.setVisibility(View.GONE);
                pager.setCurrentItem(2);
                break;
        }
    }
}
