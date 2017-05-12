package com.example.sus.caijiannan20170509;

import android.os.Handler;
import android.os.Message;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/**
 * Created by sus on 2017/4/28.
 */

public class XulisGet  {
    public XulisGet(Handler handler) {
        this.handler = handler;
    }

    private Handler handler;
    public void xutlisGet(String url,String canshu){
        RequestParams params = new RequestParams(url);
        params.addBodyParameter("uri",canshu);
        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if(result!=null) {
                    Message mess = new Message();
                    mess.what = 1;
                    mess.obj = result;
                    handler.sendMessage(mess);
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
            if(result!=null){
            Message mess = new Message();
                mess.what=1;
                mess.obj=result;
                handler.sendMessage(mess);
            }
                return true;
            }
        });
    }
}
