package com.bw.movie.contract;

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
import com.bw.mvp.base.IBaseView;

/**
 *@describe(描述)：IContract
 *@data（日期）: 2019/11/11
 *@time（时间）: 21:11
 *@author（作者）: xin
 **/
public interface IContract {
    interface  IView extends IBaseView {
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable e);
        void onResSuccess(RegisterBean registerBean);
        void onResFailure(Throwable e);
        void onCodeSuccess(CodeBean codeBean);
        void onCodeFailure(Throwable e);
        void onBannerSuccess(BannerBean bannerBean);
        void onBannerFailure(Throwable e);
        void onNowSuccess(NowReBean nowReBean);
        void onNowFailure(Throwable e);
        void onUpSuccess(JiUpBean jiUpBean);
        void onUpFailure(Throwable e);
        void onRemenSuccess(RemenBean remenBean);
        void onRemenFailure(Throwable e);
        void onAreaSuccess(AreaBean areaBean);
        void onAreaFailure(Throwable e);
        void onCinemaByRegionSuccess(CinemaBean cinemaBean);
        void onCinemaByRegionFailure(Throwable e);
        void onTuiCinemaSuccess(TuiBean tuiBean);
        void onTuiCinemaFailure(Throwable e);
        void onFuCinemaSuccess(FuBean fuBean);
        void onFuCinemaFailure(Throwable e);
        void onXiangSuccess(XiangBean xiangBean);
        void onXiangFailure(Throwable e);
        void onQYSuccess(Choose_qy_Bean choose_qy_bean);
        void onQYFailure(Throwable e);
        void onDaySuccess(DayBean dayBean);
        void onDayFailure(Throwable e);
        void onDSuccess(Choose_day_bean dayBean);
        void onDFailure(Throwable e);
        void onPriceSuccess(Price_Cinema_Bean price_cinema_bean);
        void onPriceFailure(Throwable e);
        void onWXSuccess(WXBean wxBean);
        void onWXFailure(Throwable e);
        void onGZMSuccess(GZMBean gzmBean);
        void onGZMFailure(Throwable e);
        void onQGZMSuccess(QGZMBean qgzmBean);
        void onQGZMFailure(Throwable e);
        void onYYSuccess(YYBean yyBean);
        void onYYFailure(Throwable e);

    }

    interface Imodel{
        void  getLoginData(String email, String pwd, IContractCallBack iContractCallBack);
        void  getResData(String nickName, String pwd, String email, String code, IContractCallBack iContractCallBack);
        void  getCodeData(String email, IContractCallBack iContractCallBack);
        void  getBannerData(IContractCallBack iContractCallBack);
        void  getNowData(int page,int count,IContractCallBack iContractCallBack);
        void  getUpData(int userId,String sessionId,int page,int count,IContractCallBack iContractCallBack);
        void  getRemenData(int page,int count,IContractCallBack iContractCallBack);
        void  getAreaData(IContractCallBack iContractCallBack);
        void  getCinemaByRegionData(int regionId,IContractCallBack iContractCallBack);
        void  getTuiCinema(int page,int count,IContractCallBack iContractCallBack);
        void  getFuCinema(int page,int count,IContractCallBack iContractCallBack);
        void  getXiangData(int userId,String sessionId,int movieId,IContractCallBack iContractCallBack);
        void  getQYData(int movieId,int regionId,int page,int count,IContractCallBack iContractCallBack);
        void  getDayData(IContractCallBack iContractCallBack);
        void  getDData(int movieId,String date,int page,int count,IContractCallBack iContractCallBack);
        void  getPriceData(int movieId,int page,int count,IContractCallBack iContractCallBack);
        void getWxData(String code, IContractCallBack iContractCallBack);
        void  getGZMData(int userId,String sessionId,int movieId,IContractCallBack iContractCallBack);
        void  getQGZMData(int userId,String sessionId,int movieId,IContractCallBack iContractCallBack);
        void  getYYData(int userId,String sessionId,int movieId,IContractCallBack iContractCallBack);

        interface  IContractCallBack{
            void onSuccess(Object o);
            void onFailure(Throwable e);
        }
    }

    interface IPresenter{
        void loginPresenter(String email, String pwd);
        void getCodePresenter(String email);
        void ResPresenter(String nickName, String pwd, String email, String code);
        void getBannerData();
        void getNowData(int page, int count);
        void getUpPresenter(int userId,String sessionId,int page, int count);
        void getRemenData(int page, int count);
        void  getAreaData();
        void  getCinemaByRegionData(int regionId);
        void  getTuiCinemaPresenter(int page, int count);
        void  getFuCinemaPresenter(int page, int count);
        void  getXiangP(int userId,String sessionId,int movieId);
        void  getQYData(int movieId, int regionId, int page, int count);
        void  getDayP();
        void  getDP(int movieId, String date, int page, int count);
        void  getPriceData(int movieId, int page, int count);
        void  getWxP(String code);
        void  getGZMData(int userId, String sessionId, int movieId);
        void  getQGZMData(int userId, String sessionId, int movieId);
        void  getYYData(int userId, String sessionId, int movieId);

    }
}
