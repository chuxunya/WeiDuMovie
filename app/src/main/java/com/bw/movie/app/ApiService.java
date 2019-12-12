package com.bw.movie.app;

import com.bw.movie.bean.AreaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.Choose_day_bean;
import com.bw.movie.bean.Choose_qy_Bean;
import com.bw.movie.bean.CinemaBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.DayBean;
import com.bw.movie.bean.FKBean;
import com.bw.movie.bean.FuBean;
import com.bw.movie.bean.GCinemaBeam;
import com.bw.movie.bean.GMovieBean;
import com.bw.movie.bean.GZCBean;
import com.bw.movie.bean.GZMBean;
import com.bw.movie.bean.HeadBean;
import com.bw.movie.bean.JiUpBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.LookedBean;
import com.bw.movie.bean.MovieXBean;
import com.bw.movie.bean.MyBean;
import com.bw.movie.bean.MyPBean;
import com.bw.movie.bean.MyYuBean;
import com.bw.movie.bean.NowReBean;
import com.bw.movie.bean.OrderBean;
import com.bw.movie.bean.PJBean;
import com.bw.movie.bean.PJYYBean;
import com.bw.movie.bean.PayBean;
import com.bw.movie.bean.PiaoBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.Price_Cinema_Bean;
import com.bw.movie.bean.PwdBean;
import com.bw.movie.bean.QGZCBean;
import com.bw.movie.bean.QGZMBean;
import com.bw.movie.bean.ReCodeBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.RemenBean;
import com.bw.movie.bean.SchedulerBean;
import com.bw.movie.bean.SearchBean;
import com.bw.movie.bean.SearchYYBean;
import com.bw.movie.bean.SeatBean;
import com.bw.movie.bean.TuiBean;
import com.bw.movie.bean.UpPwdBean;
import com.bw.movie.bean.WXBean;
import com.bw.movie.bean.XTBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.bean.YPBean;
import com.bw.movie.bean.YYBean;
import com.bw.movie.bean.YYPJBean;
import com.bw.movie.bean.YYPLBean;
import com.bw.movie.bean.YYPQBean;
import com.bw.movie.bean.YYXQBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/*
 *@auther:王可欣
 *@Date: 2019/11/11
 *@Time:16:20
 *@Description:api
 **/
public interface ApiService {
    //下载
    public static final String BASE_URL = "http://172.17.8.100/";
    @Streaming
    @GET
    Observable<ResponseBody> executeDownload(@Header("Range") String range, @Url() String url);
    @FormUrlEncoded
    //http://172.17.8.100/movieApi/user/v2/sendOutEmailCode验证码
    @POST("user/v2/sendOutEmailCode")
    Observable<CodeBean> getCode(@Field("email") String email);
    @FormUrlEncoded
    //http://172.17.8.100/movieApi/user/v2/register注册
    @POST("user/v2/register")
    Observable<RegisterBean> getRegister(@Field("nickName")String nickName, @Field("pwd")String pwd, @Field("email")String email, @Field("code")String code);
    @FormUrlEncoded
    //http://172.17.8.100/movieApi/user/v2/login登录
    @POST("user/v2/login")
    Observable<LoginBean> getLogin(@Field("email")String email,@Field("pwd")String pwd);
    @FormUrlEncoded
    //http://172.17.8.100/movieApi/user/v1/verify/modifyUserPwd修改密码
    @POST("user/v1/verify/modifyUserPwd")
    Observable<UpPwdBean> getUpPwd(@Header("userId")String userId,@Header("sessionId")String sessionId,@Field("oldPwd")String oldPwd,@Field("newPwd")String newPwd,@Field("newPwd2")String newPwd2);
    //http://172.17.8.100/movieApi/tool/v2/banner banner
    @GET("tool/v2/banner")
    Observable<BannerBean> getBanner();
    //http://172.17.8.100/movieApi/movie/v2/findReleaseMovieList正在热映
    @GET("movie/v2/findReleaseMovieList")
    Observable<NowReBean> getNowRe(@Query("page")int page,@Query("count")int count);
    //http://172.17.8.100/movieApi/movie/v2/findComingSoonMovieList即将上映
    @GET("movie/v2/findComingSoonMovieList")
    Observable<JiUpBean> getJiUp(@Header("userId")int userId,@Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count);
    //http://172.17.8.100/movieApi/movie/v2/findHotMovieList热门电影
    @GET("movie/v2/findHotMovieList")
    Observable<RemenBean> getRemen(@Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/tool/v2/findRegionList查询区域列表
    @GET("tool/v2/findRegionList")
    Observable<AreaBean> getArea();
    //http://172.17.8.100/movieApi/cinema/v2/findCinemaByRegion根据区域查询影院
    @GET("cinema/v2/findCinemaByRegion")
    Observable<CinemaBean> getCinemaByRegion(@Query("regionId")int regionId);
    //http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas推荐影院
    @GET("cinema/v1/findRecommendCinemas")
    Observable<TuiBean> getTuiCinema(@Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/cinema/v1/findNearbyCinemas附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<FuBean> getFuCinema(@Query("page")int page, @Query("count")int count);
    //详情
    @GET("movie/v2/findMoviesDetail")
    Observable<XiangBean> getXiang(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("movieId")int movieId);
    //http://172.17.8.100/movieApi/movie/v2/findAllMovieComment影评
    @GET("movie/v2/findAllMovieComment")
    Observable<PingBean> getPing(@Query("movieId")int movieId,@Query("page")int page, @Query("count")int count);
    //movie/v2/findCinemasInfoByRegion区域查询
    @GET("movie/v2/findCinemasInfoByRegion")
    Observable<Choose_qy_Bean> getQYcinema(@Query("movieId")int movieId,@Query("regionId")int regionId,@Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/tool/v2/findDateList一周排表
    @GET("tool/v2/findDateList")
    Observable<DayBean> getDay();
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByDate时间查询
    @GET("movie/v2/findCinemasInfoByDate")
    Observable<Choose_day_bean> getDaycinema(@Query("movieId")int movieId,@Query("date")String date,@Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByPrice根据电影价格查询播放影院信息
    @GET("movie/v2/findCinemasInfoByPrice")
    Observable<Price_Cinema_Bean> getPrice(@Query("movieId")int movieId,@Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/movie/v2/findMovieSchedule根据电影ID和影院ID查询电影排期列表
    @GET("movie/v2/findMovieSchedule")
    Observable<SchedulerBean> getScheduler(@Query("movieId")int movieId, @Query("cinemaId")int cinemaId);
    //http://172.17.8.100/movieApi/movie/v2/findSeatInfo根据影厅id 查询座位信息
    @GET("movie/v2/findSeatInfo")
    Observable<SeatBean> getSeat(@Query("hallId")int hallId);
    //http://172.17.8.100/movieApi/movie/v2/verify/buyMovieTickets下单
    @FormUrlEncoded
    @POST("movie/v2/verify/buyMovieTickets")
    Observable<OrderBean> getOrder(@Header("userId")int userId, @Header("sessionId")String sessionId, @Field("scheduleId")int scheduleId, @Field("seat")String seat, @Field("sign")String sign);
    //http://172.17.8.100/movieApi/user/v2/verify/findUserBuyTicketRecord购票记录
    @GET("user/v2/verify/findUserBuyTicketRecord")
    Observable<ReCodeBean> getRocode(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("page")int page,@Query("count")int count,@Query("status")int status);
    //http://172.17.8.100/movieApi/movie/v2/verify/pay//支付
    @FormUrlEncoded
    @POST("movie/v2/verify/pay")
    Observable<PayBean> getPay(@Header("userId")int userId, @Header("sessionId")String sessionId,@Field("payType")int ipayType,@Field("orderId")String orderId);
    //http://172.17.8.100/movieApi/user/v2/verify/findBuyTicketRecordByOrderId查看订单详情
    @GET("user/v2/verify/findBuyTicketRecordByOrderId")
    Observable<MovieXBean> getMovieX(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("orderId")String orderId);
    //http://172.17.8.100/movieApi/movie/v2/findMovieByKeyword根据关键字查询电影信息
    @GET("movie/v2/findMovieByKeyword")
    Observable<SearchBean> getDyss(@Query("keyword")String keyword,@Query("page")String page,@Query("count")String count);
    //http://172.17.8.100/movieApi/movie/v1/verify/movieComment添加用户对影片的评论
    @FormUrlEncoded
    @POST("movie/v1/verify/movieComment")
    Observable<YPBean> getPJ(@Header("userId")int userId, @Header("sessionId")String sessionId, @Field("movieId")int movieId, @Field("commentContent")String commentContent, @Field("score")double score);
    //http://172.17.8.100/movieApi/cinema/v1/findCinemaInfo影院详情
    @GET("cinema/v1/findCinemaInfo")
    Observable<YYXQBean> getYYXQ(@Header("userId")int userId, @Header("sessionId")String sessionId, @Query("cinemaId") int cinemaId);
    //http://172.17.8.100/movieApi/cinema/v1/findAllCinemaComment查询影院用户评论列表
    @GET("cinema/v1/findAllCinemaComment")
    Observable<YYPJBean> getYYPJ(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("cinemaId") int cinemaId,@Query("page")int page,@Query("count")int count);
    //http://172.17.8.100/movieApi/cinema/v2/findCinemaScheduleList查询影院下的电影排期
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<YYPQBean> getYYpq(@Query("cinemaId") int cinemaId, @Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/user/v2/verify/findUserFollowMovieList查询用户关注电影列表
    @GET("user/v2/verify/findUserFollowMovieList")
    Observable<GMovieBean> getGM(@Header("userId")int userId, @Header("sessionId")String sessionId, @Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/user/v2/verify/findUserFollowCinemaList查询用户关注影院列表
    @GET("user/v2/verify/findUserFollowCinemaList")
    Observable<GCinemaBeam> getGC(@Header("userId")int userId, @Header("sessionId")String sessionId, @Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/user/v2/verify/findMyMovieCommentList查询我对电影的评论列表
    @GET("user/v2/verify/findMyMovieCommentList")
    Observable<PJBean> getMPJ(@Header("userId")int userId, @Header("sessionId")String sessionId, @Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/user/v2/verify/findMyCinemaCommentList查询我对影院的评论列表
    @GET("user/v2/verify/findMyCinemaCommentList")
    Observable<PJYYBean> getCPJ(@Header("userId")int userId, @Header("sessionId")String sessionId, @Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/user/v2/verify/findExchangeCode查询取票码
    @GET("user/v2/verify/findExchangeCode")
    Observable<PiaoBean> getPiao(@Header("userId")int userId, @Header("sessionId")String sessionId, @Query("recordId")int recordId);
    //http://172.17.8.100/movieApi/user/v2/verify/findMyMovieTicket我的电影票
    @GET("user/v2/verify/findMyMovieTicket")
    Observable<MyPBean> getMyPiao(@Header("userId")int userId, @Header("sessionId")String sessionId);
    //http://172.17.8.100/movieApi/user/v2/verify/findSeenMovie看过的电影
    @GET("user/v2/verify/findSeenMovie")
    Observable<LookedBean> getLooked(@Header("userId")int userId, @Header("sessionId")String sessionId);
    //http://172.17.8.100/movieApi/user/v1/weChatBindingLogin微信登录
    @FormUrlEncoded
    @POST("user/v1/weChatBindingLogin")
    Observable<WXBean> getWx(@Field("code")String code);
    //http://172.17.8.100/movieApi/tool/v1/verify/findAllSysMsgList查询系统消息列表
    @GET("tool/v1/verify/findAllSysMsgList")
    Observable<XTBean> getXTXX(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("page")int page, @Query("count")int count);
    //http://172.17.8.100/movieApi/user/v1/verify/getUserInfoByUserId根据用户ID查询用户信息
    @GET("user/v1/verify/getUserInfoByUserId")
    Observable<MyBean> getMy(@Header("userId")int userId, @Header("sessionId")String sessionId);
    //http://172.17.8.100/movieApi/user/v1/verify/uploadHeadPic上传头像
    @Multipart
    @POST("user/v1/verify/uploadHeadPic")
    Observable<HeadBean> getHead(@Header("userId")int userId, @Header("sessionId")String sessionId, @Part MultipartBody.Part map);
    //http://172.17.8.100/movieApi/user/v2/verify/updateUserBirthday修改生日
    @FormUrlEncoded
    @POST("user/v2/verify/updateUserBirthday")
    Observable<BirthBean> getBirth(@Header("userId")int userId, @Header("sessionId")String sessionId,@Field("birthday")String birthday);
    //http://172.17.8.100/movieApi/tool/v1/verify/recordFeedBack意见反馈
    @POST("tool/v1/verify/recordFeedBack")
    Observable<FKBean> getFK(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("content")String content);
    //http://172.17.8.100/movieApi/user/v2/verify/findUserReserve查询用户预约电影信息
    @GET("user/v2/verify/findUserReserve")
    Observable<MyYuBean> getMyYu(@Header("userId")int userId, @Header("sessionId")String sessionId);
    //http://172.17.8.100/movieApi/user/v1/verify/modifyUserPwd修改密码
    @FormUrlEncoded
    @POST("user/v1/verify/modifyUserPwd")
    Observable<PwdBean> getPwd(@Header("userId")int userId, @Header("sessionId")String sessionId, @Field("oldPwd")String oldPwd,@Field("newPwd")String newPwd,@Field("newPwd2")String newPwd2);
    //http://mobile.bwstudent.com/movieApi/cinema/v1/findAllCinema查询影院
    @GET("cinema/v1/findAllCinemas")
    Observable<SearchYYBean> getYYSS(@Query("page")int page, @Query("count")int count, @Query("cinemaName") String cinemaName);
    //http://172.17.8.100/movieApi/cinema/v1/verify/cinemaComment影院评论
    @FormUrlEncoded
    @POST("cinema/v1/verify/cinemaComment")
    Observable<YYPLBean> getYYPL(@Header("userId")int userId, @Header("sessionId")String sessionId,@Field("cinemaId")int cinemaId,@Field("commentContent")String commentContent);
    //http://172.17.8.100/movieApi/movie/v1/verify/followMovie关注电影
    @GET("movie/v1/verify/followMovie")
    Observable<GZMBean> getGZM(@Header("userId")int userId, @Header("sessionId")String sessionId,@Query("movieId")int movieId);
    //http://172.17.8.100/movieApi/movie/v1/verify/cancelFollowMovie取消关注影片
    @GET("movie/v1/verify/cancelFollowMovie")
    Observable<QGZMBean> getQGZM(@Header("userId")int userId, @Header("sessionId")String sessionId, @Query("movieId")int movieId);
    //http://172.17.8.100/movieApi/movie/v2/verify/reserve预约
    @FormUrlEncoded
    @POST("movie/v2/verify/reserve")
    Observable<YYBean> getYY(@Header("userId")int userId, @Header("sessionId")String sessionId, @Field("movieId") int movieId);
    //http://172.17.8.100/movieApi/cinema/v1/verify/followCinema影院关注
    @GET("cinema/v1/verify/followCinema")
    Observable<GZCBean> getGZC(@Header("userId")int userId, @Header("sessionId")String sessionId, @Query("cinemaId") int cinemaId);
    //http://172.17.8.100/movieApi/cinema/v1/verify/cancelFollowCinema取消影院关注
    @GET("cinema/v1/verify/cancelFollowCinema")
    Observable<QGZCBean> getQGZC(@Header("userId")int userId, @Header("sessionId")String sessionId, @Query("cinemaId") int cinemaId);



}
