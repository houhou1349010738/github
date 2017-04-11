package com.example.sus.android_xutilstext.Xutils;

import android.os.Handler;
import android.os.Message;

import com.example.sus.android_xutilstext.Bean.title;

import org.xutils.DbManager;

import java.util.List;

/**
 * Created by sus on 2017/4/11.
 */

public class XutlistSQLitet {

    private DbManager db;
    private String url;

    public XutlistSQLitet(String url, String canshu) {
        this.url = url;
        this.canshu = canshu;
    }

    private String canshu;
    private Handler han = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            List<title.ResultBean.DateBean> list = (List<title.ResultBean.DateBean>) msg.obj;


        }
    };


//
//    public  void  create(){
//
//        //初始化DaoConfig配置
//        DbManager.DaoConfig  config = new DbManager.DaoConfig();
//        config.setDbName("mysql.db");//创建数据库的默认名字
//        config.setDbDir(new File("/mnt/sdcard"));//设置数据库的路径
//        config.setDbVersion(1);//设置数据库的版本号
//        //设置数据库打开的监听
//        config.setDbOpenListener(new DbManager.DbOpenListener() {
//            @Override
//            public void onDbOpened(DbManager db) {
//                //开启数据库支持多线程操作，提升性能，对写入加速提升巨大
//                db.getDatabase().enableWriteAheadLogging();
//
//            }
//        });
//        //给数据库升级是的监听
//        config.setDbUpgradeListener(new DbManager.DbUpgradeListener() {
//            @Override
//            public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
//            }
//        });
//        //创建数据表设置的监听
//        config.setTableCreateListener(new DbManager.TableCreateListener() {
//            @Override
//            public void onTableCreated(DbManager db, TableEntity<?> table) {
//
//            }
//        });
//        //设置支持事物添加信息
//        config.setAllowTransaction(true);
//        db = x.getDb(config);
//
//    }

}
