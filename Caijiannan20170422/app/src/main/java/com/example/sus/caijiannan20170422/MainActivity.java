package com.example.sus.caijiannan20170422;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mylibrary.utils.MyHttpClient;
import com.example.sus.caijiannan20170422.JsonBean.Json;
import com.example.sus.caijiannan20170422.JsonBean.Myurl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction tran;
    private FragmentManager fm;
    private List<Json.DatalistBean> lists = new ArrayList<>();
   private List<Json.DatalistBean> mo;
    private Handler han = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String json = (String) msg.obj;
            Gson gson = new Gson();
            Json json1 = gson.fromJson(json, Json.class);
            final List<Json.DatalistBean> datalist = json1.getDatalist();
            Log.i("12",datalist.toString());
            lists.add(datalist.get(0));
            lists.add(datalist.get(1));
            fragment frag = new fragment();
                tran.add(R.id.message2,new fragment2(lists)).add(R.id.message1,frag).commit();
           frag.huidiao(new fragment.indexs() {
                @Override
                public void index(int in) {
                    if(in==0){
                   lists.clear();
                lists.add(datalist.get(0));
                lists.add(datalist.get(1));
                    }else if(in==1) {
                        lists.clear();
                        lists.add(datalist.get(2));
                        lists.add(datalist.get(3));
                    }else if(in==2){
                        lists.clear();
                        lists.add(datalist.get(4));
                        lists.add(datalist.get(5));
                    }else if(in==3){
                        lists.clear();
                        lists.add(datalist.get(6));
                        lists.add(datalist.get(7));
                    }else if(in==4){
                        lists.clear();
                        lists.add(datalist.get(8));
                        lists.add(datalist.get(9));
                    }
                  fragment2 frag2 = new fragment2(lists);
                    fm = getSupportFragmentManager();
                    tran = fm.beginTransaction();
                    tran.replace(R.id.message2,frag2).commit();
                }
            });
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();
        new MyHttpClient(Myurl.path,han).start();




    }

}
