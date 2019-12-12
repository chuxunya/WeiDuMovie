package com.bw.movie.presenter;


import com.bw.movie.bean.AreaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Choose_day_bean;
import com.bw.movie.bean.Choose_qy_Bean;
import com.bw.movie.bean.CinemaBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.DayBean;
import com.bw.movie.bean.FuBean;
import com.bw.movie.bean.GZCBean;
import com.bw.movie.bean.GZMBean;
import com.bw.movie.bean.JiUpBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.NowReBean;
import com.bw.movie.bean.Price_Cinema_Bean;
import com.bw.movie.bean.QGZCBean;
import com.bw.movie.bean.QGZMBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.RemenBean;
import com.bw.movie.bean.TuiBean;
import com.bw.movie.bean.WXBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.YYBean;
import com.bw.movie.contract.IContract;
import com.bw.movie.contract.IContract3;
import com.bw.movie.model.HomeModel;
import com.bw.mvp.base.BasePresenter;
/**
 *@describe(描述)：HomePresenter
 *@data（日期）: 2019/11/11
 *@time（时间）: 21:19
 *@author（作者）: xin
 **/
public class HomePresenter extends BasePresenter<IContract.IView> implements IContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void loginPresenter(String email, String pwd) {
        homeModel.getLoginData(email, pwd, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                LoginBean loginBean = (LoginBean)o;
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onLoginFailure(e);
            }
        });
    }

    @Override
    public void getCodePresenter(String email) {
        homeModel.getCodeData(email, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                CodeBean codeBean = (CodeBean)o;
                getView().onCodeSuccess(codeBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onCodeFailure(e);
            }
        });
    }

    @Override
    public void ResPresenter(String nickName, String pwd, String email, String code) {
        homeModel.getResData(nickName, pwd, email, code, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                RegisterBean registerBean = (RegisterBean)o;
                getView().onResSuccess(registerBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onResFailure(e);
            }
        });
    }

    @Override
    public void getBannerData() {
        homeModel.getBannerData(new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                BannerBean bannerBean = (BannerBean)o;
                getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onBannerFailure(e);
            }
        });
    }

    @Override
    public void getNowData(int page, int count) {
        homeModel.getNowData(page, count, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                NowReBean nowReBean = (NowReBean)o;
                getView().onNowSuccess(nowReBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onNowFailure(e);
            }
        });
    }

    @Override
    public void getUpPresenter(int userId, String sessionId, int page, int count) {
        homeModel.getUpData(userId,sessionId,page, count, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                JiUpBean jiUpBean = (JiUpBean)o;
                getView().onUpSuccess(jiUpBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onUpFailure(e);
            }
        });
    }

    @Override
    public void getRemenData(int page, int count) {
        homeModel.getRemenData(page, count, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                RemenBean remenBean = (RemenBean)o;
                getView().onRemenSuccess(remenBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onRemenFailure(e);
            }
        });
    }

    @Override
    public void getAreaData() {
        homeModel.getAreaData(new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                AreaBean areaBean = (AreaBean)o;
                getView().onAreaSuccess(areaBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onAreaFailure(e);
            }
        });
    }

    @Override
    public void getCinemaByRegionData(int regionId) {
        homeModel.getCinemaByRegionData(regionId, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                CinemaBean cinemaBean = (CinemaBean)o;
                getView().onCinemaByRegionSuccess(cinemaBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onCinemaByRegionFailure(e);
            }
        });
    }

    @Override
    public void getTuiCinemaPresenter(int page, int count) {
        homeModel.getTuiCinema(page, count, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                TuiBean tuiBean = (TuiBean)o;
                getView().onTuiCinemaSuccess(tuiBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onTuiCinemaFailure(e);
            }
        });
    }

    @Override
    public void getFuCinemaPresenter(int page, int count) {
        homeModel.getFuCinema(page, count, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                FuBean fuBean = (FuBean)o;
                getView().onFuCinemaSuccess(fuBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFuCinemaFailure(e);
            }
        });
    }

    @Override
    public void getXiangP(int userId, String sessionId, int movieId) {
        homeModel.getXiangData(userId,sessionId,movieId, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                XiangBean xiangBean = (XiangBean)o;
                getView().onXiangSuccess(xiangBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onXiangFailure(e);
            }
        });
    }

    @Override
    public void getQYData(int movieId, int regionId, int page, int count) {
        homeModel.getQYData(movieId, regionId, page, count, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                Choose_qy_Bean choose_qy_bean = (Choose_qy_Bean)o;
                getView().onQYSuccess(choose_qy_bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onQYFailure(e);
            }
        });
    }

    @Override
    public void getDayP() {
        homeModel.getDayData(new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                DayBean dayBean = (DayBean)o;
                getView().onDaySuccess(dayBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onDayFailure(e);
            }
        });
    }

    @Override
    public void getDP(int movieId, String date, int page, int count) {
        homeModel.getDData(movieId, date, page, count, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                Choose_day_bean choose_day_bean = (Choose_day_bean)o;
                getView().onDSuccess(choose_day_bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onDFailure(e);
            }
        });
    }

    @Override
    public void getPriceData(int movieId, int page, int count) {
        homeModel.getPriceData(movieId, page, count, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                Price_Cinema_Bean price_cinema_bean = (Price_Cinema_Bean)o;
                getView().onPriceSuccess(price_cinema_bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onPriceFailure(e);
            }
        });
    }

    @Override
    public void getWxP(String code) {
        homeModel.getWxData(code, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                WXBean wxBean = (WXBean)o;
                getView().onWXSuccess(wxBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onWXFailure(e);
            }
        });
    }

    @Override
    public void getGZMData(int userId, String sessionId, int movieId) {
        homeModel.getGZMData(userId, sessionId, movieId, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                GZMBean gzmBean = (GZMBean)o;
                getView().onGZMSuccess(gzmBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onGZMFailure(e);
            }
        });
    }

    @Override
    public void getQGZMData(int userId, String sessionId, int movieId) {
        homeModel.getQGZMData(userId, sessionId, movieId, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                QGZMBean qgzmBean = (QGZMBean)o;
                getView().onQGZMSuccess(qgzmBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onQGZMFailure(e);
            }
        });
    }

    @Override
    public void getYYData(int userId, String sessionId, int movieId) {
        homeModel.getYYData(userId, sessionId, movieId, new IContract.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                YYBean yyBean = (YYBean)o;
                getView().onYYSuccess(yyBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onYYFailure(e);
            }
        });
    }
}
