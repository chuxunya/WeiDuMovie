package com.bw.mvp.app;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.internal.Constants;

/**
 *@describe(描述)：App
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:06
 *@author（作者）: xin
 **/
public class App extends Application {
    private static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
    }

    public static App getAppContext(){
        return sContext;
    }

}
