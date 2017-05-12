package com.example.sus.caijiannan20170509.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sus.caijiannan20170509.R;
import com.example.sus.caijiannan20170509.XulisGet;
import com.example.sus.caijiannan20170509.adapter.LayoutMess;
import com.example.sus.caijiannan20170509.adapter.SpacesItemDecoration;
import com.example.sus.caijiannan20170509.bean.InpoBean;
import com.example.sus.caijiannan20170509.uritype.Uri;
import com.google.gson.Gson;

import java.util.List;

/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/9 9:50
 */

public class MyFragment extends Fragment {

    private RecyclerView recyclerView;

    public MyFragment(String utl) {
        this.utl = utl;
    }
    private String utl;
    private ListView listView;
    private Handler han = new Handler(){
        private List<InpoBean.ResultBean.DataBean> data;


        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                String json = (String) msg.obj;
                Gson gson = new Gson();
                InpoBean inpoBean = gson.fromJson(json, InpoBean.class);
                data = inpoBean.getResult().getData();
                LayoutMess mess = new LayoutMess(getActivity(),data);
                recyclerView.setAdapter(mess);
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.frag,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new XulisGet(han).xutlisGet(Uri.inpo,utl);
        //通过控件获取RecyclerView的控件
        recyclerView = (RecyclerView) getView().findViewById(R.id.fragview);
        //给recyclerView设置一个LayoutManager想当于Listview
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        添加默认分割线：高度为2px，颜色为灰色
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(30);
        recyclerView.addItemDecoration(spacesItemDecoration);
    }
}
