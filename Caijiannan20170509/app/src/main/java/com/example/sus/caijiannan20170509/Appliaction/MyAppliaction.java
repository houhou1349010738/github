package com.example.sus.caijiannan20170509.Appliaction;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/9 9:23
 */

public class MyAppliaction extends Application {
    @Override
    public void onCreate() {
        x.Ext.init(this);

        initimage();
    }

    private void initimage() {
        ImageLoaderConfiguration con = new ImageLoaderConfiguration.Builder
                (getApplicationContext()).memoryCacheExtraOptions(480,800).build();
        ImageLoader.getInstance().init(con);
    }
}
