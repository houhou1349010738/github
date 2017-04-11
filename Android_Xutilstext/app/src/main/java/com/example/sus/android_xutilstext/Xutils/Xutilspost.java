package com.example.sus.android_xutilstext.Xutils;

import android.database.Cursor;
import android.os.Handler;
import android.util.Log;

import com.example.sus.android_xutilstext.Appliaction.MyAppliaction;
import com.example.sus.android_xutilstext.Bean.title;
import com.google.gson.Gson;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/11.
 */

public class Xutilspost {
    private Handler handler;
    public Xutilspost(String url) {
        this.url = url;
    }

    private String url;
    public void Post(String canshu){
        Log.i("TAG","---------------");
        RequestParams params = new RequestParams(url);
        params.addBodyParameter("uri",canshu);
        params.addHeader("hean","android");

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                DbManager getdb = x.getDb((DbManager.DaoConfig) MyAppliaction.Getdb());
                title title = gson.fromJson(result, title.class);
                List<title.ResultBean.DateBean> date =title.getResult().getDate();
                List<ChildInfotext> listinpo = new ArrayList<>();
                try {
                for(int i=0;i<date.size();i++){
                    ChildInfotext childInfo = new ChildInfotext();

                    listinpo.add(childInfo);
                }
                    getdb.save(listinpo);
                    Cursor cursor = getdb.execQuery("select * from child_info");
                    Log.d("abc",cursor.getString(0));

                } catch (DbException e) {
                    e.printStackTrace();
                }
            }

            @Override//网络求求出现异常时回掉的方法
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override//手动取消网络请求是回掉的方法
            public void onCancelled(CancelledException cex) {

            }

            @Override//当网络请求完成时回调的方法
            public void onFinished() {

            }
        });
    }

}
