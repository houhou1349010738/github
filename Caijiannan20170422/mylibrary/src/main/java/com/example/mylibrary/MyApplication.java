package com.example.mylibrary;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
  *类的用途：图片的全局配置
  *@author caoyan
  *@date 2017/4/5 0005
  */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //图片的默认配置
        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this);
        //初始化配置的数据
        ImageLoader.getInstance().init(configuration);
    }
}
