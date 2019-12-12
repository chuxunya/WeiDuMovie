package com.bw.movie.utils;

import com.bw.movie.app.ApiService;
import com.bw.mvp.app.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 *@describe(描述)：RetrofitUtil
 *@data（日期）: 2019/11/11
 *@time（时间）: 21:14
 *@author（作者）: xin
 **/
public class RetrofitUtil {
    private Retrofit mRetrofit;
    private static final String BASE_URL = Constant.BASE_URL;
    //默认的IApi
    private ApiService apiService;

    private static final class SingleHolder {
        private static final RetrofitUtil _INSTANCE = new RetrofitUtil(BASE_URL);
    }

    public static RetrofitUtil getInstance() {
        return SingleHolder._INSTANCE;
    }

    private RetrofitUtil(String url) {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .client(buildOkhttpClient())
                .build();
    }

    private OkHttpClient buildOkhttpClient() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    public <T> T create(final Class<T> service) {
        return mRetrofit.create(service);
    }

    public ApiService create() {
        if (apiService == null) {
            apiService = create(ApiService.class);
        }
        return apiService;
    }

}
