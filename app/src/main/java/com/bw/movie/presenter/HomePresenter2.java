package com.bw.movie.presenter;

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
import com.bw.movie.bean.YYBean;
import com.bw.movie.bean.YYPJBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.bean.YYPQBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.contract.IContract;
import com.bw.movie.contract.IContract2;
import com.bw.movie.contract.IContract3;
import com.bw.movie.model.HomeModel2;
import com.bw.mvp.base.BasePresenter;
/**
 *@describe(描述)：HomePresenter2
 *@data（日期）: 2019/11/19
 *@time（时间）: 16:43
 *@author（作者）: xin
 **/

public class HomePresenter2 extends BasePresenter<IContract2.IView> implements IContract2.IPresenter {

    private HomeModel2 homeModel2;

    @Override
    protected void initModel() {
        homeModel2 = new HomeModel2();
    }

    @Override
    public void getPingData(int movieId, int page, int count) {
        homeModel2.getPingData(movieId, page, count, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                PingBean pingBean = (PingBean)o;
                getView().onPingSuccess(pingBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onPingFailure(e);
            }
        });
    }

    @Override
    public void getSchedulerData(int movieId, int cinemaId) {
        homeModel2.getSchedulerData(movieId, cinemaId, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                SchedulerBean schedulerBean = (SchedulerBean)o;
                getView().onSchedulerSuccess(schedulerBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onSchedulerFailure(e);
            }
        });
    }

    @Override
    public void getSeatData(int hallId) {
        homeModel2.getSeatData(hallId, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                SeatBean seatBean = (SeatBean)o;
                getView().onSeatSuccess(seatBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onSeatFailure(e);
            }
        });
    }

    @Override
    public void getOrderP(int userId, String sessionId, int scheduleId, String seat, String sign) {
        homeModel2.getOrderData(userId, sessionId, scheduleId, seat, sign, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                OrderBean orderBean = (OrderBean)o;
                getView().onOrderSuccess(orderBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onOrderFailure(e);
            }
        });
    }

    @Override
    public void getRecodeP(int userId, String sessionId, int page, int count, int status) {
        homeModel2.getRecodeData(userId, sessionId, page, count, status, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                ReCodeBean reCodeBean = (ReCodeBean)o;
                getView().onRecodeSuccess(reCodeBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onRecodeFailure(e);
            }
        });
    }

    @Override
    public void getPayP(int userId, String sessionId, int ipayType, String orderId) {
        homeModel2.getPayData(userId, sessionId, ipayType, orderId, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                PayBean payBean = (PayBean)o;
                getView().onPaySuccess(payBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onPayFailure(e);
            }
        });
    }

    @Override
    public void getMXP(int userId, String sessionId, String orderId) {
        homeModel2.getMXData(userId, sessionId, orderId, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                MovieXBean movieXBean = (MovieXBean)o;
                getView().onMXSuccess(movieXBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onMXFailure(e);
            }
        });
    }

    @Override
    public void getDyssPresenter(String keyword, String page, String count) {
        homeModel2.getDyssData(keyword, page, count, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                SearchBean bean = (SearchBean)o;
                getView().onDyssSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onDyssFailure(e);
            }
        });
    }

    @Override
    public void getXYPData(int userId, String sessionId, int movieId, String commentContent, double score) {
        homeModel2.getXYPData(userId, sessionId, movieId, commentContent, score, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                YPBean ypBean = (YPBean)o;
                getView().onXYPSuccess(ypBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onXYPFailure(e);
            }
        });
    }

    @Override
    public void getYYXQp(int userId, String sessionId, int cinemaId) {
        homeModel2.getYYXQData(userId, sessionId, cinemaId, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                YYXQBean yyxqBean = (YYXQBean)o;
                getView().onYYXQSuccess(yyxqBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onYYXQFailure(e);
            }
        });
    }

    @Override
    public void getYYpjP(int userId, String sessionId, int cinemaId, int page, int count) {
        homeModel2.getYYpjData(userId, sessionId, cinemaId, page, count, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                YYPJBean yypjBean = (YYPJBean)o;
                getView().onYYPJSuccess(yypjBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onYYPJFailure(e);
            }
        });
    }

    @Override
    public void getYYPQP(int cinemaId, int page, int count) {
        homeModel2.getYYPQData(cinemaId, page, count, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                YYPQBean yypqBean = (YYPQBean)o;
                getView().onYYPQSuccess(yypqBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onYYPQFailure(e);
            }
        });
    }

    @Override
    public void getGMP(int userId, String sessionId, int page, int count) {
        homeModel2.getGMData(userId, sessionId, page, count, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                GMovieBean gMovieBean = (GMovieBean)o;
                getView().onGMSuccess(gMovieBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onGMFailure(e);
            }
        });
    }

    @Override
    public void getGCP(int userId, String sessionId, int page, int count) {
        homeModel2.getGCData(userId, sessionId, page, count, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                GCinemaBeam gCinemaBeam = (GCinemaBeam)o;
                getView().onGcSuccess(gCinemaBeam);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onGcFailure(e);
            }
        });
    }

    @Override
    public void getQGZMData(int userId, String sessionId, int movieId) {
        homeModel2.getQGZMData(userId, sessionId, movieId, new IContract2.Imodel.IContractCallBack() {
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
    public void getYYPLData(int userId, String sessionId, int cinemaId, String commentContent) {
        homeModel2.getYYPLData(userId, sessionId, cinemaId, commentContent, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                YYPLBean yyplBean = (YYPLBean)o;
                getView().onYYPLSuccess(yyplBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onYYPLFailure(e);
            }
        });
    }

    @Override
    public void getGZCData(int userId, String sessionId, int cinemaId) {
        homeModel2.getGZCData(userId, sessionId, cinemaId, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                GZCBean gzcBean = (GZCBean)o;
                getView().onGZCSuccess(gzcBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onGZCFailure(e);
            }
        });
    }

    @Override
    public void getQGZCData(int userId, String sessionId, int cinemaId) {
        homeModel2.getQGZCData(userId, sessionId, cinemaId, new IContract2.Imodel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                QGZCBean qgzcBean = (QGZCBean)o;
                getView().onQGZCSuccess(qgzcBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onQGZCFailure(e);
            }
        });
    }
}
