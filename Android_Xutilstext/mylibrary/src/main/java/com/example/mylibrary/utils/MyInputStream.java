package com.example.mylibrary.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
  *类的用途：读取字节流
  *@author caoyan
  *@date 2017/4/5 0005
  */
public class MyInputStream {

    private ByteArrayOutputStream stream;

    public String getData(InputStream inputStream){

        try {
            stream = new ByteArrayOutputStream();
            int len=0;
            byte[] b=new byte[1024];
            //循环读取数据
            while((len=inputStream.read(b))!=-1){
                stream.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }
}
