package com.example.sus.caijiannan20170422;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sus.caijiannan20170422.JsonBean.Json;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/23.
 */

public class Adapter extends BaseAdapter {
    private Context context;
    private ListView lv;
    private List<String> name = new ArrayList<>();


    public Adapter() {
    }

    public Adapter(Context context, List<Json.DatalistBean> list) {
        this.context = context;
        this.list = list;
    }

    private List<Json.DatalistBean> list;
    private TextView tv,tv2;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
       if(convertView==null)
       {
           convertView =View.inflate(context,R.layout.item,null);
           tv = (TextView) convertView.findViewById(R.id.name);
           tv2 = (TextView) convertView.findViewById(R.id.price);
           iv = (ImageView) convertView.findViewById(R.id.iv);

       }
        tv.setText(list.get(position).getCourse_name());
        tv2.setText(list.get(position).getCourse_price());
        ImageLoader.getInstance().displayImage(list.get(position).getCourse_pic(),iv,new DisplayImageOptions.Builder().displayer(new RoundedBitmapDisplayer(0)).showImageForEmptyUri(R.mipmap.ic_launcher).build());


        return convertView;
    }


}
