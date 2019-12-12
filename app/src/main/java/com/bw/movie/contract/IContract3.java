package com.bw.movie.contract;

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
import com.bw.mvp.base.IBaseView;

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.Query;

/**
 *@describe(描述)：IContract3
 *@data（日期）: 2019/12/3
 *@time（时间）: 21:47
 *@author（作者）: xin
 **/
public interface IContract3 {
    interface  IView extends IBaseView {
        void onMPJSuccess(PJBean pjBean);
        void onMPJFailure(Throwable e);

        void onCPJSuccess(PJYYBean pjyyBean);
        void onCPJFailure(Throwable e);

        void onPiaoSuccess(PiaoBean piaoBean);
        void onPiaoFailure(Throwable e);

        void onMyPiaoSuccess(MyPBean myPBean);
        void onMyPiaoFailure(Throwable e);

        void onLookedSuccess(LookedBean lookedBean);
        void onLookedFailure(Throwable e);

        void onXTXXSuccess(XTBean xtBean);
        void onXTXXFailure(Throwable e);

        void onMySuccess(MyBean myBean);
        void onMyFailure(Throwable e);

        void onHeadSuccess(HeadBean headBean);
        void onHeadFailure(Throwable e);

        void onBirthSuccess(BirthBean birthBean);
        void onBirthFailure(Throwable e);

        void onFKSuccess(FKBean fkBean);
        void onFKFailure(Throwable e);

        void onMyYuSuccess(MyYuBean myYuBean);
        void onMyYuFailure(Throwable e);

        void onPWDSuccess(PwdBean pwdBean);
        void onPWDFailure(Throwable e);

        void onYYSSSuccess(SearchYYBean searchYYBean);
        void onYYSSFailure(Throwable e);
    }

    interface Imodel{
        void getMPJData(int userId, String sessionId, int page, int count, IContractCallBack iContractCallBack);
        void getCPJData(int userId, String sessionId, int page, int count, IContractCallBack iContractCallBack);
        void getPiaoData(int userId, String sessionId,int recordId, IContractCallBack iContractCallBack);
        void getMyPiaoData(int userId, String sessionId,IContractCallBack iContractCallBack);
        void getLookedData(int userId, String sessionId,IContractCallBack iContractCallBack);
        void getXTXXData(int userId, String sessionId,int page, int count, IContractCallBack iContractCallBack);
        void getMyData(int userId, String sessionId,IContractCallBack iContractCallBack);
        void getHeadData(int userId, String sessionId, MultipartBody.Part image,IContractCallBack iContractCallBack);
        void getBirthData(int userId, String sessionId, String birthday,IContractCallBack iContractCallBack);
        void getFKData(int userId, String sessionId, String content,IContractCallBack iContractCallBack);
        void getMyYuData(int userId, String sessionId,IContractCallBack iContractCallBack);
        void getPWDData(int userId, String sessionId, String oldPwd,String newPwd,String newPwd2,IContractCallBack iContractCallBack);
        void getYYSSData(int page,int count, String cinemaName, IContractCallBack iContractCallBack);

        interface  IContractCallBack{
            void onSuccess(Object o);
            void onFailure(Throwable e);
        }
    }

    interface IPresenter{
        void getMPJp(int userId, String sessionId, int page, int count);
        void getCPJp(int userId, String sessionId, int page, int count);
        void getPiaoP(int userId, String sessionId,int recordId);
        void getMyPiaoP(int userId, String sessionId);
        void getLookedP(int userId, String sessionId);
        void getXTXXP(int userId, String sessionId,int page, int count);
        void getMyP(int userId, String sessionId);
        void getHeadP(int userId, String sessionId, MultipartBody.Part map);
        void getBirthP(int userId, String sessionId, String birthday);
        void getFKP(int userId, String sessionId, String content);
        void getMyYuData(int userId, String sessionId);
        void getPWDData(int userId, String sessionId, String oldPwd, String newPwd, String newPwd2);
        void getYYSSData(int page,int count, String cinemaName);
    }
}
