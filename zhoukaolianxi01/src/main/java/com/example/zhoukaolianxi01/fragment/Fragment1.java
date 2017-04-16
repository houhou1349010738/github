package com.example.zhoukaolianxi01.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhoukaolianxi01.Bean.InpoBean;
import com.example.zhoukaolianxi01.Httputlis.MyHttp;
import com.example.zhoukaolianxi01.R;
import com.example.zhoukaolianxi01.adapter.MyBaseadapter;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by sus on 2017/4/15.
 */

public class Fragment1 extends Fragment {

    public Fragment1(String url) {
        this.url = url;
    }
   private String text;
    private String url;
    private TextView tvs;
    private ListView listView;
    private Handler han = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
               String json  = (String) msg.obj;
                Gson gson = new Gson();
                InpoBean inpoBean = gson.fromJson(json, InpoBean.class);
                List<InpoBean.DataBean> data = inpoBean.getData();
                MyBaseadapter base = new MyBaseadapter(data,getActivity());
                listView.setAdapter(base);
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.f,container,false);
        listView = (ListView) view.findViewById(R.id.list01);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new MyHttp(han,url).start();
    }
}
