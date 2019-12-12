package com.bw.movie.model;

import com.bw.movie.bean.GCinemaBeam;
import com.bw.movie.bean.GMovieBean;
import com.bw.movie.bean.GZCBean;
import com.bw.movie.bean.MovieXBean;
import com.bw.movie.bean.OrderBean;
import com.bw.movie.bean.PayBean;
import com.bw.movie.bean.PiaoBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.QGZCBean;
import com.bw.movie.bean.QGZMBean;
import com.bw.movie.bean.ReCodeBean;
import com.bw.movie.bean.SchedulerBean;
import com.bw.movie.bean.SearchBean;
import com.bw.movie.bean.SeatBean;
import com.bw.movie.bean.YPBean;
import com.bw.movie.bean.YYPJBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.bean.YYPQBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.contract.IContract;
import com.bw.movie.contract.IContract2;
import com.bw.movie.contract.IContract3;
import com.bw.movie.utils.RetrofitUtil;
import com.bw.movie.view.SearchActivity;
import com.bw.mvp.utils.CommonObserver;
import com.bw.mvp.utils.CommonSchedulers;
/**
 *@describe(描述)：HomeModel2
 *@data（日期）: 2019/11/19
 *@time（时间）: 16:43
 *@author（作者）: xin
 **/
public class HomeModel2 implements IContract2.Imodel {

    @Override
    public void getPingData(int movieId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getPing(movieId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PingBean>() {
                    @Override
                    public void onNext(PingBean pingBean) {
                        iContractCallBack.onSuccess(pingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getSchedulerData(int movieId, int cinemaId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getScheduler(movieId,cinemaId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SchedulerBean>() {
                    @Override
                    public void onNext(SchedulerBean schedulerBean) {
                        iContractCallBack.onSuccess(schedulerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getSeatData(int hallId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getSeat(hallId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SeatBean>() {
                    @Override
                    public void onNext(SeatBean seatBean) {
                        iContractCallBack.onSuccess(seatBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getOrderData(int userId, String sessionId, int scheduleId, String seat, String sign, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getOrder(userId,sessionId,scheduleId,seat,sign)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<OrderBean>() {
                    @Override
                    public void onNext(OrderBean orderBean) {
                        iContractCallBack.onSuccess(orderBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getRecodeData(int userId, String sessionId, int page, int count, int status, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getRocode(userId,sessionId,page,count,status)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ReCodeBean>() {
                    @Override
                    public void onNext(ReCodeBean reCodeBean) {
                        iContractCallBack.onSuccess(reCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getPayData(int userId, String sessionId, int ipayType, String orderId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getPay(userId,sessionId,ipayType,orderId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PayBean>() {
                    @Override
                    public void onNext(PayBean payBean) {
                        iContractCallBack.onSuccess(payBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getMXData(int userId, String sessionId, String orderId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getMovieX(userId,sessionId,orderId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MovieXBean>() {
                    @Override
                    public void onNext(MovieXBean movieXBean) {
                        iContractCallBack.onSuccess(movieXBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);                    }
                });
    }

    @Override
    public void getDyssData(String keyword, String page, String count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create().getDyss(keyword, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SearchBean>() {
                    @Override
                    public void onNext(SearchBean searchBean) {
                        iContractCallBack.onSuccess(searchBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });

    }

    @Override
    public void getXYPData(int userId, String sessionId, int movieId, String commentContent, double score, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getPJ(userId,sessionId,movieId,commentContent,score)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YPBean>() {
                    @Override
                    public void onNext(YPBean ypBean) {
                        iContractCallBack.onSuccess(ypBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getYYXQData(int userId, String sessionId, int cinemaId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getYYXQ(userId,sessionId,cinemaId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YYXQBean>() {
                    @Override
                    public void onNext(YYXQBean yyxqBean) {
                        iContractCallBack.onSuccess(yyxqBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getYYpjData(int userId, String sessionId, int cinemaId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getYYPJ(userId,sessionId,cinemaId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YYPJBean>() {
                    @Override
                    public void onNext(YYPJBean yypjBean) {
                        iContractCallBack.onSuccess(yypjBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getYYPQData(int cinemaId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getYYpq(cinemaId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YYPQBean>() {
                    @Override
                    public void onNext(YYPQBean yypqBean) {
                        iContractCallBack.onSuccess(yypqBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getGMData(int userId, String sessionId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getGM(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<GMovieBean>() {
                    @Override
                    public void onNext(GMovieBean gMovieBean) {
                        iContractCallBack.onSuccess(gMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getGCData(int userId, String sessionId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getGC(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<GCinemaBeam>() {
                    @Override
                    public void onNext(GCinemaBeam gCinemaBeam) {
                        iContractCallBack.onSuccess(gCinemaBeam);
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
    public void getYYPLData(int userId, String sessionId, int cinemaId, String commentContent, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getYYPL(userId,sessionId,cinemaId,commentContent)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<YYPLBean>() {
                    @Override
                    public void onNext(YYPLBean yyplBean) {
                        iContractCallBack.onSuccess(yyplBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getGZCData(int userId, String sessionId, int cinemaId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getGZC(userId,sessionId,cinemaId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<GZCBean>() {
                    @Override
                    public void onNext(GZCBean gzcBean) {
                        iContractCallBack.onSuccess(gzcBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getQGZCData(int userId, String sessionId, int cinemaId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getQGZC(userId,sessionId,cinemaId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<QGZCBean>() {
                    @Override
                    public void onNext(QGZCBean qgzcBean) {
                        iContractCallBack.onSuccess(qgzcBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }
}
