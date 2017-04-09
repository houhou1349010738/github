package com.example.sus.caijiannnanwork.Httputlis;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2017/4/7 0007.
 */

public class MyAsyncTask extends AsyncTask<String,Integer,String>{
    private getjson getjson;
    @Override
    protected String doInBackground(String... strings) {
        //创建一个可变的字符串
        StringBuffer sbu = new StringBuffer();
        try{
            //创建一个URL
            URL url = new URL(strings[0]);
            //通过HttpURLConnection打开指定url
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");//设置一个提交方式
            connect.setReadTimeout(5000);//设置读取超时的时间
            connect.setConnectTimeout(5000);

            if(connect.getResponseCode()==200){//创建一个字节输入流
                InputStream ins = connect.getInputStream();
                //用字符缓冲流对他进行包装
                BufferedReader br = new BufferedReader(new InputStreamReader(ins,"utf-8"));
                String inpo;
                while((inpo=br.readLine())!=null){
                    sbu.append(inpo);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return sbu.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        getjson.getjsonstr(s);
    }
    public interface getjson{//创建一个接口
       public void getjsonstr(String str);
    }
    //创建一个回掉接口的方法
    public void huidiao(getjson get){
        this.getjson=get;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
