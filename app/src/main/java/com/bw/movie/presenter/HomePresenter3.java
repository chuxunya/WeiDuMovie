package com.bw.movie.presenter;

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
import com.bw.movie.bean.WXBean;
import com.bw.movie.bean.XTBean;
import com.bw.movie.bean.YYPJBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.contract.IContract3;
import com.bw.movie.model.HomeModel3;
import com.bw.mvp.base.BasePresenter;

import okhttp3.MultipartBody;

/**
 *@describe(描述)：HomePresenter2
 *@data（日期）: 2019/11/19
 *@time（时间）: 16:43
 *@author（作者）: xin
 **/

public class HomePresenter3 extends BasePresenter<IContract3.IView> implements IContract3.IPresenter {

    private HomeModel3 homeModel3;

    @Override
    protected void initModel() {
        homeModel3 = new HomeModel3();
    }

    @Override
    public void getMPJp(int userId, String sessionId, int page, int count) {
        homeModel3.getMPJData(userId, sessionId, page, count, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                PJBean pjBean=(PJBean)o;
                getView().onMPJSuccess(pjBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onMPJFailure(e);
            }
        });
    }

    @Override
    public void getCPJp(int userId, String sessionId, int page, int count) {
        homeModel3.getCPJData(userId, sessionId, page, count, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                PJYYBean pjyyBean = (PJYYBean)o;
                getView().onCPJSuccess(pjyyBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onCPJFailure(e);
            }
        });
    }

    @Override
    public void getPiaoP(int userId, String sessionId, int recordId) {
        homeModel3.getPiaoData(userId, sessionId, recordId, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                PiaoBean piaoBean = (PiaoBean)o;
                getView().onPiaoSuccess(piaoBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onPiaoFailure(e);
            }
        });
    }

    @Override
    public void getMyPiaoP(int userId, String sessionId) {
        homeModel3.getMyPiaoData(userId, sessionId, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                MyPBean myPBean = (MyPBean)o;
                getView().onMyPiaoSuccess(myPBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onMyPiaoFailure(e);
            }
        });
    }

    @Override
    public void getLookedP(int userId, String sessionId) {
        homeModel3.getLookedData(userId, sessionId, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                LookedBean lookedBean = (LookedBean)o;
                getView().onLookedSuccess(lookedBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onLookedFailure(e);
            }
        });
    }

    @Override
    public void getXTXXP(int userId, String sessionId, int page, int count) {
        homeModel3.getXTXXData(userId, sessionId, page, count, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                XTBean xtBean = (XTBean)o;
                getView().onXTXXSuccess(xtBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onXTXXFailure(e);
            }
        });
    }

    @Override
    public void getMyP(int userId, String sessionId) {
        homeModel3.getMyData(userId, sessionId, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                MyBean myBean = (MyBean)o;
                getView().onMySuccess(myBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onMyFailure(e);
            }
        });
    }

    @Override
    public void getHeadP(int userId, String sessionId, MultipartBody.Part map) {
        homeModel3.getHeadData(userId, sessionId, map, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                HeadBean headBean = (HeadBean)o;
                getView().onHeadSuccess(headBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onHeadFailure(e);
            }
        });
    }

    @Override
    public void getBirthP(int userId, String sessionId, String birthday) {
        homeModel3.getBirthData(userId, sessionId, birthday, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                BirthBean birthBean = (BirthBean)o;
                getView().onBirthSuccess(birthBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onBirthFailure(e);
            }
        });
    }

    @Override
    public void getFKP(int userId, String sessionId, String content) {
        homeModel3.getFKData(userId, sessionId, content, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                FKBean fkBean = (FKBean)o;
                getView().onFKSuccess(fkBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFKFailure(e);
            }
        });
    }

    @Override
    public void getMyYuData(int userId, String sessionId) {
        homeModel3.getMyYuData(userId, sessionId, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                MyYuBean myYuBean = (MyYuBean)o;
                getView().onMyYuSuccess(myYuBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onMyYuFailure(e);
            }
        });
    }

    @Override
    public void getPWDData(int userId, String sessionId, String oldPwd, String newPwd, String newPwd2) {
        homeModel3.getPWDData(userId, sessionId, oldPwd, newPwd, newPwd2, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                PwdBean pwdBean = (PwdBean)o;
                getView().onPWDSuccess(pwdBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onPWDFailure(e);
            }
        });
    }

    @Override
    public void getYYSSData(int page, int count, String cinemaName) {
        homeModel3.getYYSSData(page, count, cinemaName, new IContract3.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                SearchYYBean searchYYBean = (SearchYYBean)o;
                getView().onYYSSSuccess(searchYYBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onYYSSFailure(e);
            }
        });
    }
}
