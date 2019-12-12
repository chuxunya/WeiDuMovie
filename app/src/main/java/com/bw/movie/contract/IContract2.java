package com.bw.movie.contract;

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
import com.bw.mvp.base.IBaseView;

import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 *@describe(描述)：IContract2
 *@data（日期）: 2019/11/19
 *@time（时间）: 16:43
 *@author（作者）: xin
 **/
public interface IContract2 {
    interface  IView extends IBaseView {
        void onPingSuccess(PingBean pingBean);
        void onPingFailure(Throwable e);

        void onSchedulerSuccess(SchedulerBean schedulerBean);
        void onSchedulerFailure(Throwable e);

        void onSeatSuccess(SeatBean seatBean);
        void onSeatFailure(Throwable e);

        void onOrderSuccess(OrderBean orderBean);
        void onOrderFailure(Throwable e);

        void onRecodeSuccess(ReCodeBean reCodeBean);
        void onRecodeFailure(Throwable e);

        void onPaySuccess(PayBean payBean);
        void onPayFailure(Throwable e);

        void onMXSuccess(MovieXBean movieXBean);
        void onMXFailure(Throwable e);

        void onDyssSuccess(SearchBean bean);
        void onDyssFailure(Throwable e);

        void onXYPSuccess(YPBean ypBean);
        void onXYPFailure(Throwable e);

        void onYYXQSuccess(YYXQBean yyxqBean);
        void onYYXQFailure(Throwable e);

        void onYYPJSuccess(YYPJBean yypjBean);
        void onYYPJFailure(Throwable e);

        void onYYPQSuccess(YYPQBean yypqBean);
        void onYYPQFailure(Throwable e);

        void onGMSuccess(GMovieBean gMovieBean);
        void onGMFailure(Throwable e);

        void onGcSuccess(GCinemaBeam gCinemaBeam);
        void onGcFailure(Throwable e);

        void onQGZMSuccess(QGZMBean qgzmBean);
        void onQGZMFailure(Throwable e);

        void onYYPLSuccess(YYPLBean yyplBean);
        void onYYPLFailure(Throwable e);

        void onGZCSuccess(GZCBean gzcBean);
        void onGZCFailure(Throwable e);

        void onQGZCSuccess(QGZCBean qgzcBean);
        void onQGZCFailure(Throwable e);

    }

    interface Imodel{
        void getPingData(int movieId,int page,int count,IContractCallBack iContractCallBack);
        void getSchedulerData(int movieId,int cinemaId,IContractCallBack iContractCallBack);
        void getSeatData(int hallId,IContractCallBack iContractCallBack);
        void getOrderData(int userId,String sessionId,int scheduleId,String seat,String sign,IContractCallBack iContractCallBack);
        void getRecodeData(int userId,String sessionId, int page,int count,int status,IContractCallBack iContractCallBack);
        void getPayData(int userId,String sessionId, int ipayType,String orderId,IContractCallBack iContractCallBack);
        void getMXData(int userId,String sessionId,String orderId,IContractCallBack iContractCallBack);
        void getDyssData(String keyword,String page,String count,IContractCallBack iContractCallBack) ;
        void getXYPData(int userId,String sessionId,int movieId,String commentContent,double score,IContractCallBack iContractCallBack);
        void getYYXQData(int userId,String sessionId,int cinemaId,IContractCallBack iContractCallBack);
        void getYYpjData(int userId,String sessionId,int cinemaId,int page,int count,IContractCallBack iContractCallBack);
        void getYYPQData(int cinemaId,int page,int count,IContractCallBack iContractCallBack);
        void getGMData(int userId,String sessionId,int page,int count,IContractCallBack iContractCallBack);
        void getGCData(int userId,String sessionId,int page,int count,IContractCallBack iContractCallBack);
        void  getQGZMData(int userId, String sessionId, int movieId, IContractCallBack iContractCallBack);
        void getYYPLData(int userId, String sessionId, int cinemaId, String commentContent, IContractCallBack iContractCallBack);
        void  getGZCData(int userId, String sessionId, int cinemaId,IContractCallBack iContractCallBack);
        void  getQGZCData(int userId, String sessionId, int cinemaId, IContractCallBack iContractCallBack);

        interface  IContractCallBack{
            void onSuccess(Object o);
            void onFailure(Throwable e);
        }
    }

    interface IPresenter{
        void getPingData(int movieId, int page, int count);
        void getSchedulerData(int movieId, int cinemaId);
        void getSeatData(int hallId);
        void getOrderP(int userId, String sessionId, int scheduleId, String seat, String sign);
        void getRecodeP(int userId, String sessionId, int page, int count, int status);
        void getPayP(int userId, String sessionId, int ipayType, String orderId);
        void getMXP(int userId, String sessionId, String orderId);
        void getDyssPresenter(String keyword,String page,String count);
        void getXYPData(int userId, String sessionId, int movieId, String commentContent, double score);
        void getYYXQp(int userId, String sessionId, int cinemaId);
        void getYYpjP(int userId, String sessionId, int cinemaId, int page, int count);
        void getYYPQP(int cinemaId, int page, int count);
        void getGMP(int userId, String sessionId, int page, int count);
        void getGCP(int userId, String sessionId, int page, int count);
        void  getQGZMData(int userId, String sessionId, int movieId);
        void getYYPLData(int userId, String sessionId, int cinemaId, String commentContent);
        void  getGZCData(int userId, String sessionId, int cinemaId);
        void  getQGZCData(int userId, String sessionId, int cinemaId);
    }
}
