package com.example.mylibrary.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

/**
  *类的用途：请求方式
  *@author caoyan
  *@date 2017/4/5 0005
  */

public class MyHttpClient extends Thread {
    String path;
    Handler handler;
    public MyHttpClient(String path, Handler handler){
        this.path=path;
        this.handler=handler;
    }
    @Override
    public void run() {
        super.run();

        try {
            HttpClient client=new DefaultHttpClient();
            HttpPost post=new HttpPost(path);
            HttpResponse execute = client.execute(post);
            int code = execute.getStatusLine().getStatusCode();
            //状态码为200请求成功
            if(200==code){
                //获取请求的数据
                InputStream inputStream = execute.getEntity().getContent();
                String s = new MyInputStream().getData(inputStream);
                Message message=new Message();
                message.obj=s;
                Log.i("2121",s);
                handler.sendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
