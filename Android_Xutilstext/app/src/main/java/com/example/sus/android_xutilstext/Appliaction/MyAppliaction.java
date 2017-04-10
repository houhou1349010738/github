package com.example.sus.android_xutilstext.Appliaction;

import android.app.Application;

import org.xutils.x;

/**
 * Created by sus on 2017/4/10.
 */

public class MyAppliaction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化一个X
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
