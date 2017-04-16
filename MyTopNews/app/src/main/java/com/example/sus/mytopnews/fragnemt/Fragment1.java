package com.example.sus.mytopnews.fragnemt;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sus.mytopnews.R;
import com.example.sus.mytopnews.adapter.MyBaseAdapter;
import com.example.sus.mytopnews.bean.InpoBean;
import com.example.sus.mytopnews.xutlis.Xutils;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by sus on 2017/4/10.
 */

public class Fragment1 extends Fragment {


    private String url;

    public Fragment1(String url, String sansu) {
        this.url = url;
        this.sansu = sansu;
    }

    private String sansu;
    private ListView listView;
    private Handler han = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            if(msg.what==2){
                String json = (String) msg.obj;
                if (!json.equals("sorry,this api without the mock data.")){
                    Gson gson = new Gson();
                    InpoBean inpoBean = gson.fromJson(json,InpoBean.class);
                    List<InpoBean.ResultBean.DataBean> data = inpoBean.getResult().getData();
                    MyBaseAdapter my = new MyBaseAdapter(data,getActivity());
                    listView.setAdapter(my);
                }

            }
//
//              String json = (String) msg.obj;
//            Gson gson = new Gson();
//            JsonBean jsonBean = gson.fromJson(json, JsonBean.class);
//            List<JsonBean.ResultBean> result = jsonBean.getResult();

        }

    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment,container,false);
        listView = (ListView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        new MyHttpClient(url,han).start();
       new Xutils(han,url).Get(sansu);

    }
}
