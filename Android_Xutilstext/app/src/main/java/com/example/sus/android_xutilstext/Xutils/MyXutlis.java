package com.example.sus.android_xutilstext.Xutils;

import android.os.Handler;
import android.os.Message;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by sus on 2017/4/10.
 */

public class MyXutlis {
    private Handler han;
    private String url;

    public MyXutlis(Handler han, String url, String canshu) {
        this.han = han;
        this.url = url;
        this.canshu = canshu;
    }

    private String canshu;
    public  void Get(){
        //设置请求的URL
        RequestParams params = new RequestParams(url);
        //给请求的url写参数请求
        params.addQueryStringParameter("uri",canshu);
        //用Xutlis设置GET提交方式
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
            //解析result请求后获得到的字符串
                Message mess = new Message();
                mess.what=1;
                mess.obj=result;
                han.sendMessage(mess);
            }

            @Override//请求发生异常是回调的方法
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override//网络请求取消是回掉的方法
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}
