package com.example.sus.mytopnews.appliaction;

import android.app.Application;

import org.xutils.DbManager;
import org.xutils.x;


/**
 * Created by sus on 2017/4/12.
 */

public class MyAppliaction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        DbManager.DaoConfig config = new DbManager.DaoConfig().setDbName("NEWS").setDbVersion(1);
    }
}
