package com.example.sus.mytopnews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sus.mytopnews.R;
import com.example.sus.mytopnews.bean.InpoBean;
import com.example.sus.mytopnews.xutlis.MyImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/10.
 */

public class MyBaseAdapter extends BaseAdapter {
    private List<InpoBean.ResultBean.DataBean>list = new ArrayList<>();

    public MyBaseAdapter(List<InpoBean.ResultBean.DataBean>list, Context context) {
        this.list=list;
        this.context = context;
    }

    private Context context;
    private TextView tv;
    private TextView tv2;
    private ImageView iv;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView =View.inflate(context, R.layout.item,null);
            tv = (TextView) convertView.findViewById(R.id.item_tv);
            tv2 = (TextView) convertView.findViewById(R.id.item_tv2);
            iv = (ImageView) convertView.findViewById(R.id.item_iv);
        }
        tv.setText(list.get(position).getTitle());
        tv2.setText(list.get(position).getAuthor_name());
        new MyImage().show(list.get(position).getThumbnail_pic_s(),iv);
        return convertView;
    }
}
