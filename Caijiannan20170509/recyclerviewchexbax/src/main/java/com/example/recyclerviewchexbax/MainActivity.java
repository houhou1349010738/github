package com.example.recyclerviewchexbax;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.recyclerviewchexbax.adapter.DividerItemDecoration;
import com.example.recyclerviewchexbax.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private List<String> list = new ArrayList<>();
    private Map<Integer,Boolean> map = new HashMap<>();
    private RecyclerViewAdapter adapter;
    private TextView tv;
    private TextView tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initdata();
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.quanxuan);
        tv2 = (TextView) findViewById(R.id.quanbuxuan);
        tv.setOnClickListener(this);
        tv2.setOnClickListener(this);

        //通过资源id找到制定的控件
        recyclerView = (RecyclerView) findViewById(R.id.rec_view);
        //创建RecyclerView的布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置一个默认的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter = new RecyclerViewAdapter(MainActivity.this,list,map);
        recyclerView.setAdapter(adapter);

    }

    private void initdata() {
       for(int i=0;i<20;i++){
           list.add("香蕉"+i);
       }
        for(int i=0;i<map.size();i++){
            map.put(i,false);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.quanxuan:
                for(int i=0;i<map.size();i++){
                    map.put(i,true);
                }
                map.notify();
            Log.i("tag","1234");
                break;
            case R.id.quanbuxuan:
               for(int i=0;i<map.size();i++){
                   map.put(i,false);
               }
                map.notify();
                Log.i("tag","4567");

                break;
        }
    }


}
