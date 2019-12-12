package com.bw.movie.view;

import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.mvp.base.BaseActivity;
import com.bw.mvp.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
/**
 *@describe(描述)：购票记录
 *@data（日期）: 2019/12/3
 *@time（时间）: 10:10
 *@author（作者）: xin
 **/
public class ReCordActivity extends BaseActivity {

    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.pager)
    ViewPager pager;
    private ArrayList<Fragment> list;
    private ArrayList<String> tablist;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_re_cord;
    }

    @Override
    protected void initView() {
        super.initView();
        detailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        list = new ArrayList<>();
        list.add(new DaiFragment());
        list.add(new OverFragment());
        tablist = new ArrayList<>();
        tablist.add("待付款");
        tablist.add("已付款");
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tablist.get(position);
            }
        });
        tab.setupWithViewPager(pager);
    }
}
