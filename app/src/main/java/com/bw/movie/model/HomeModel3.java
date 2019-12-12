package com.bw.movie.model;

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
import com.bw.movie.utils.RetrofitUtil;
import com.bw.mvp.utils.CommonObserver;
import com.bw.mvp.utils.CommonSchedulers;

import okhttp3.MultipartBody;

/**
 *@describe(描述)：HomeModel2
 *@data（日期）: 2019/11/19
 *@time（时间）: 16:43
 *@author（作者）: xin
 **/
public class HomeModel3 implements IContract3.Imodel {
    @Override
    public void getMPJData(int userId, String sessionId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getMPJ(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PJBean>() {
                    @Override
                    public void onNext(PJBean pjBean) {
                        iContractCallBack.onSuccess(pjBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getCPJData(int userId, String sessionId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getCPJ(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PJYYBean>() {
                    @Override
                    public void onNext(PJYYBean pjyyBean) {
                        iContractCallBack.onSuccess(pjyyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getPiaoData(int userId, String sessionId, int recordId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getPiao(userId,sessionId,recordId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PiaoBean>() {
                    @Override
                    public void onNext(PiaoBean piaoBean) {
                        iContractCallBack.onSuccess(piaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getMyPiaoData(int userId, String sessionId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getMyPiao(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MyPBean>() {
                    @Override
                    public void onNext(MyPBean myPBean) {
                        iContractCallBack.onSuccess(myPBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getLookedData(int userId, String sessionId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getLooked(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<LookedBean>() {
                    @Override
                    public void onNext(LookedBean lookedBean) {
                        iContractCallBack.onSuccess(lookedBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getXTXXData(int userId, String sessionId, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getXTXX(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<XTBean>() {
                    @Override
                    public void onNext(XTBean xtBean) {
                        iContractCallBack.onSuccess(xtBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getMyData(int userId, String sessionId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getMy(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MyBean>() {
                    @Override
                    public void onNext(MyBean myBean) {
                        iContractCallBack.onSuccess(myBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getHeadData(int userId, String sessionId, MultipartBody.Part map, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getHead(userId,sessionId,map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<HeadBean>() {
                    @Override
                    public void onNext(HeadBean headBean) {
                        iContractCallBack.onSuccess(headBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getBirthData(int userId, String sessionId, String birthday, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getBirth(userId,sessionId,birthday)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<BirthBean>() {
                    @Override
                    public void onNext(BirthBean birthBean) {
                        iContractCallBack.onSuccess(birthBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getFKData(int userId, String sessionId, String content, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getFK(userId,sessionId,content)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FKBean>() {
                    @Override
                    public void onNext(FKBean fkBean) {
                        iContractCallBack.onSuccess(fkBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getMyYuData(int userId, String sessionId, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getMyYu(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MyYuBean>() {
                    @Override
                    public void onNext(MyYuBean myYuBean) {
                        iContractCallBack.onSuccess(myYuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getPWDData(int userId, String sessionId, String oldPwd, String newPwd, String newPwd2, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getPwd(userId,sessionId,oldPwd,newPwd,newPwd2)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PwdBean>() {
                    @Override
                    public void onNext(PwdBean pwdBean) {
                        iContractCallBack.onSuccess(pwdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void getYYSSData(int page, int count, String cinemaName, IContractCallBack iContractCallBack) {
        RetrofitUtil.getInstance().create()
                .getYYSS(page,count,cinemaName)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SearchYYBean>() {
                    @Override
                    public void onNext(SearchYYBean searchYYBean) {
                        iContractCallBack.onSuccess(searchYYBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }
}
