package com.example.zhoukaolianxi01.Httputlis;

import android.os.Handler;
import android.os.Message;

import com.example.zhoukaolianxi01.Streamutlis.Stream;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by sus on 2017/4/15.
 */

public class MyHttp extends Thread {
    private Handler handler;
    private String url;
    private HttpURLConnection connection;
    private String getjson;

    public MyHttp(Handler han,String url){
       this.handler=han;
        this.url=url;
    }
    @Override
    public void run() {
        String getjs = getjson(url);
        if(getjson!=null){
            Message mess = new Message();
            mess.what=1;
            mess.obj=getjs;
            handler.sendMessage(mess);
        }
    }
    public String getjson(String urls){
        URL url=null;
        try{
            //创建一个Url给他一个指定的路径
            url = new URL(urls);
            //打开HttpURLConnection获取网络资源
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");//设置提交的方式
            connection.setReadTimeout(5000);//设置读取的超时时间
            connection.setConnectTimeout(5000);//设置读取的超时时间
            int responseCode = connection.getResponseCode();
            if(responseCode==200){
                InputStream inputStream = connection.getInputStream();
                getjson = Stream.getjson(inputStream);

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return getjson;
    }

}

