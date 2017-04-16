package com.example.zhoukaolianxi01.Streamutlis;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by sus on 2017/4/15.
 */

public class Stream {
    public static String getjson(InputStream ins){
        StringBuffer sbu = new StringBuffer();//可变的字符串

        try{
            //创建一个缓冲刘对参数进行包装流
            BufferedReader br = new BufferedReader(new InputStreamReader(ins,"gbk"));
            String inpo;
            //循环读取参数输入流的信息
            while((inpo=br.readLine())!=null){
                sbu.append(inpo);//将每次读取的信息最佳到
            }
        }catch(Exception e){

        }
        return sbu.toString();
    }
}
