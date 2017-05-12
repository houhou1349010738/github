package com.example.sus.caijiannan20170509.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sus.caijiannan20170509.R;
import com.example.sus.caijiannan20170509.XulisGet;
import com.example.sus.caijiannan20170509.adapter.MasonryAdapter;
import com.example.sus.caijiannan20170509.adapter.SpacesItemDecoration;
import com.example.sus.caijiannan20170509.bean.InpoBean;
import com.example.sus.caijiannan20170509.bean.Product;
import com.example.sus.caijiannan20170509.uritype.Uri;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/9 10:33
 */

public class fragment2 extends Fragment{
    public fragment2(String uri) {
        this.uri = uri;
    }
    private List<InpoBean.ResultBean.DataBean> datas;
    private String uri;

    private RecyclerView recyclerView;
    private List<Product> list = new ArrayList<>();
    private Handler han = new Handler(){

        private MasonryAdapter adapter;

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                String json = (String) msg.obj;
                Gson gson = new Gson();
                InpoBean inpoBean = gson.fromJson(json, InpoBean.class);
                datas = inpoBean.getResult().getData();
                for(int i=0;i<datas.size();i++){
                    String thumbnail_pic_s = datas.get(i).getThumbnail_pic_s();
                    String author_name = datas.get(i).getAuthor_name();
                    Product pro = new Product();
                    pro.setImg(thumbnail_pic_s);
                    pro.setTitle(author_name);
                    list.add(pro);
                }
                adapter = new MasonryAdapter(list,getActivity());
                recyclerView.setAdapter(adapter);
                adapter.setOnItemLongClickListener(new MasonryAdapter.onRecyclerItemLongClickListener() {
                    @Override
                    public void onItemLongClick(View view, int position) {
                        adapter.removeItem(position);
                        Log.i("tag", "onItemLongClick: "+position);
                        Log.i("tag", "集合: "+list.toString());
                    }
                });
                adapter.setOnItemClickListener(new MasonryAdapter.OnRecyclerItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        adapter.addItem(position,list.get(position));
                        Log.i("tag", "onItemClick: "+position);
                        Log.i("tag", "集合: "+list.toString());
                    }
                });
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag3,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new XulisGet(han).xutlisGet(Uri.inpo,uri);
        recyclerView= (RecyclerView) getView().findViewById(R.id.view);
       recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置item之间的间隔
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(15);
        recyclerView.addItemDecoration(spacesItemDecoration);
    }




}
