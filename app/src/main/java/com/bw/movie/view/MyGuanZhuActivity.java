package com.bw.movie.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.presenter.HomePresenter2;
import com.bw.mvp.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
/**
 *@describe(描述)：MyGuanZhuActivity
 *@data（日期）: 2019/12/3
 *@time（时间）: 11:00
 *@author（作者）: xin
 **/
public class MyGuanZhuActivity extends BaseActivity<HomePresenter2> {

    @BindView(R.id.my_guanzhu_fanhui)
    ImageView myGuanzhuFanhui;
    @BindView(R.id.write_relation)
    RelativeLayout writeRelation;
    @BindView(R.id.my_guanzhu_tablayout)
    TabLayout myGuanzhuTablayout;
    @BindView(R.id.my_guanzhu_vp)
    ViewPager myGuanzhuVp;

    @Override
    protected HomePresenter2 providePresenter() {
        return new HomePresenter2();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_guan_zhu;
    }

    @Override
    protected void initData() {
        super.initData();
        myGuanzhuFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        List<Fragment> list = new ArrayList<>();
        list.add(new FragMoviegGZ());
        list.add(new FragYingYuanGZ());
        List<String> slist = new ArrayList<>();
        slist.add("电影");
        slist.add("影院");
        myGuanzhuVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return slist.get(position);
            }
        });
        myGuanzhuTablayout.setupWithViewPager(myGuanzhuVp);
        myGuanzhuVp.setOffscreenPageLimit(2);

    }
}
