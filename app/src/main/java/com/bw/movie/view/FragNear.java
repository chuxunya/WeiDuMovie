package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.presenter.HomePresenter;
import com.bw.mvp.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

/**
 * @describe(描述)：FragNear
 * @data（日期）: 2019/11/11
 * @time（时间）: 21:21
 * @author（作者）: xin
 **/
public class FragNear extends BaseFragment<HomePresenter> {

    @BindView(R.id.pager_near)
    ViewPager pagerNear;
    @BindView(R.id.position_near)
    ImageView positionNear;
    @BindView(R.id.city_near)
    TextView cityNear;
    @BindView(R.id.search_near)
    ImageView searchNear;
    @BindView(R.id.tab_near)
    TabLayout tabNear;
    private ArrayList<Fragment> list;
    private ArrayList<String> tablist;
    private boolean network;
    private SharedPreferences sp;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_near;
    }

    @Override
    protected void initView() {
        super.initView();
        sp = getActivity().getSharedPreferences("position", MODE_PRIVATE);
        String district = sp.getString("district", "");
        if (sp != null) {
            cityNear.setText(district);
        }
        list = new ArrayList<>();
        list.add(new FragTui());
        list.add(new FragFu());
        list.add(new FragArea());
        tablist = new ArrayList<>();
        tablist.add("推荐影院");
        tablist.add("附近影院");
        tablist.add("海淀区");
        pagerNear.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
                return tablist.get(position);
            }
        });
        tabNear.setupWithViewPager(pagerNear);
    }

    @OnClick(R.id.search_near)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(),SearchYYActivity.class);
        startActivity(intent);
    }
}
