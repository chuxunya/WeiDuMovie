package com.bw.movie.utils;
/**
 *@describe(描述)：DownloadCallBack
 *@data（日期）: 2019/11/13
 *@time（时间）: 19:17
 *@author（作者）: xin
 **/
public interface DownloadCallBack {

      void onProgress(int progress);

    void onCompleted();

    void onError(String msg);

}
