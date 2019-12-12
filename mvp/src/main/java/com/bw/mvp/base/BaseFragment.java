package com.bw.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.mvp.R;
import com.bw.mvp.app.App;
import com.bw.mvp.utils.NetUtil;

import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 *@describe(描述)：BaseFragment
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:06
 *@author（作者）: xin
 **/
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    private Unbinder bind;
    protected P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View inflate = inflater.inflate(provideLayoutId(), container, false);
        bind = ButterKnife.bind(this, inflate);
        boolean network = hasNetwork();
        if (!network){
            inflate = inflater.inflate(R.layout.nonet, container, false);
        }
        return inflate;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = providePresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract P providePresenter();

    protected abstract int provideLayoutId();

    protected void initView() {

    }

    protected void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        /*bind.unbind();*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    //判断是否有网络
    public boolean hasNetwork() {
        return NetUtil.hasNet(context());
    }

    //无网提醒
    public void showNoNetTip() {

    }

    @Override
    public Context context() {
        return getContext()==null ? App.getAppContext() :getContext();
    }
}