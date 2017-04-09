package com.example.sus.caijiannnanwork.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.sus.caijiannnanwork.Bean.JsonBean;
import com.example.sus.caijiannnanwork.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/7 0007.
 */

public class MyBaseAdapter extends BaseAdapter {


    //通过Activity传来的上下文以及适配的数据
    public MyBaseAdapter(Context context, List<JsonBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<JsonBean.ListBean> list = new ArrayList<>();
    private TextView tv,tv2;

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }//返回item的总数

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }//返回条目

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            //获取填充条目的资源id
            view=View.inflate(context,R.layout.item,null);
            tv = (TextView) view.findViewById(R.id.tv);
            tv2 = (TextView) view.findViewById(R.id.tv2);
        }
        //将信息显示到指定的页面中
        tv.setText(list.get(i).getAddress());
        tv2.setText(list.get(i).getSite_name());
        return view;
    }
}
