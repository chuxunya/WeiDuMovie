package com.bw.movie.view;

import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.mvp.base.BaseActivity;
import com.bw.mvp.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
/**
 *@describe(描述)：CxplActivity
 *@data（日期）: 2019/12/7
 *@time（时间）: 13:48
 *@author（作者）: xin
 **/
public class CxplActivity extends BaseActivity {

    @BindView(R.id.image_cxpl_back)
    ImageView imageCxplBack;
    @BindView(R.id.tab_cxpl)
    TabLayout tabCxpl;
    @BindView(R.id.pager_cxpl)
    ViewPager pagerCxpl;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_cxpl;
    }

    @Override
    protected void initData() {
        super.initData();
        List<Fragment> list = new ArrayList();
        list.add(new Fragment_Cxdypl());
        list.add(new Fragment_Cxyypl());
        List<String> tablist = new ArrayList<>();
        tablist.add("电影");
        tablist.add("影院");
        pagerCxpl.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        tabCxpl.setupWithViewPager(pagerCxpl);
    }

    @OnClick(R.id.image_cxpl_back)
    public void onViewClicked() {
        finish();
    }
}
