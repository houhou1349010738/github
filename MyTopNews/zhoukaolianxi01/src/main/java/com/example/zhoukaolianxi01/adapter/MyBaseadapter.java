package com.example.zhoukaolianxi01.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zhoukaolianxi01.Bean.InpoBean;
import com.example.zhoukaolianxi01.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/15.
 */

public class MyBaseadapter extends BaseAdapter {
    private List<InpoBean.DataBean> list = new ArrayList<>();

    public MyBaseadapter(List<InpoBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private Context context;
    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    TextView tv,tv2,tv3;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView =View.inflate(context, R.layout.item,null);

            tv = (TextView) convertView.findViewById(R.id.name);
            tv2 = (TextView) convertView.findViewById(R.id.title_tvv);
            tv3 = (TextView) convertView.findViewById(R.id.price);
        }
        tv.setText(list.get(position).getTitle());
        tv2.setText(list.get(position).getApply());
        tv3.setText(list.get(position).getOld_price());
        return convertView;
    }
}
