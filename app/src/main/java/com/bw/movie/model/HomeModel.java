package com.bw.movie.model;

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
import com.bw.mvp.utils.CommonObserver;
import com.bw.mvp.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitUtil;

/**
 *@describe(描述)：HomeModel
 *@data（日期）: 2019/11/11
 *@time（时间）: 21:11
 *@author（作者）: xin
 **/
public class HomeModel implements IContract.Imodel {
    @Override
    public void getLoginData(String email, String pwd, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getLogin(email,pwd)
                .compose(CommonSchedulers.<LoginBean>io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        iContractCallBack.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getResData(String nickName, String pwd, String email, String code, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getRegister(nickName,pwd,email,code)
                .compose(CommonSchedulers.<RegisterBean>io2main())
                .subscribe(new CommonObserver<RegisterBean>() {
                    @Override
                    public void onNext(RegisterBean resBean) {
                        iContractCallBack.onSuccess(resBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getCodeData(String email, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getCode(email)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CodeBean>() {
                    @Override
                    public void onNext(CodeBean codeBean) {
                        iContractCallBack.onSuccess(codeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getBannerData(IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getBanner()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<BannerBean>() {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        iContractCallBack.onSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getNowData(int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getNowRe(page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<NowReBean>() {
                    @Override
                    public void onNext(NowReBean nowReBean) {
                        iContractCallBack.onSuccess(nowReBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getUpData(int userId, String sessionId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getJiUp(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<JiUpBean>() {
                    @Override
                    public void onNext(JiUpBean jiUpBean) {
                        iContractCallBack.onSuccess(jiUpBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getRemenData(int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getRemen(page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<RemenBean>() {
                    @Override
                    public void onNext(RemenBean remenBean) {
                        iContractCallBack.onSuccess(remenBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getAreaData(IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getArea()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<AreaBean>() {
                    @Override
                    public void onNext(AreaBean areaBean) {
                        iContractCallBack.onSuccess(areaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getCinemaByRegionData(int regionId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getCinemaByRegion(regionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CinemaBean>() {
                    @Override
                    public void onNext(CinemaBean cinemaBean) {
                        iContractCallBack.onSuccess(cinemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getTuiCinema(int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getTuiCinema(page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<TuiBean>() {
                    @Override
                    public void onNext(TuiBean tuiBean) {
                        iContractCallBack.onSuccess(tuiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getFuCinema(int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getFuCinema(page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FuBean>() {
                    @Override
                    public void onNext(FuBean fuBean) {
                        iContractCallBack.onSuccess(fuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getXiangData(int userId, String sessionId, int movieId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getXiang(userId,sessionId,movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<XiangBean>() {
                    @Override
                    public void onNext(XiangBean xiangBean) {
                        iContractCallBack.onSuccess(xiangBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getQYData(int movieId, int regionId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getQYcinema(movieId,regionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<Choose_qy_Bean>() {
                    @Override
                    public void onNext(Choose_qy_Bean choose_qy_bean) {
                        iContractCallBack.onSuccess(choose_qy_bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getDayData(IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getDay()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DayBean>() {
                    @Override
                    public void onNext(DayBean dayBean) {
                        iContractCallBack.onSuccess(dayBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getDData(int movieId, String date, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getDaycinema(movieId,date,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<Choose_day_bean>() {
                    @Override
                    public void onNext(Choose_day_bean dayBean) {
                        iContractCallBack.onSuccess(dayBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getPriceData(int movieId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getPrice(movieId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<Price_Cinema_Bean>() {
                    @Override
                    public void onNext(Price_Cinema_Bean price_cinema_bean) {
                        iContractCallBack.onSuccess(price_cinema_bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getWxData(String code, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getWx(code)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<WXBean>() {
                    @Override
                    public void onNext(WXBean wxBean) {
                        iContractCallBack.onSuccess(wxBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getGZMData(int userId, String sessionId, int movieId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getGZM(userId,sessionId,movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<GZMBean>() {
                    @Override
                    public void onNext(GZMBean gzmBean) {
                        iContractCallBack.onSuccess(gzmBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getQGZMData(int userId, String sessionId, int movieId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getQGZM(userId,sessionId,movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<QGZMBean>() {
                    @Override
                    public void onNext(QGZMBean qgzmBean) {
                        iContractCallBack.onSuccess(qgzmBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getYYData(int userId, String sessionId, int movieId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getYY(userId,sessionId,movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YYBean>() {
                    @Override
                    public void onNext(YYBean yyBean) {
                        iContractCallBack.onSuccess(yyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }
}
