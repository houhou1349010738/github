package com.example.sus.caijiannan20170509.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sus.caijiannan20170509.R;
import com.example.sus.caijiannan20170509.bean.InpoBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/9 9:52
 */

public class MyBase extends BaseAdapter {
 private    List<InpoBean.ResultBean.DataBean> list=  new ArrayList<>();

    public MyBase(List<InpoBean.ResultBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private Context context;
    private TextView tv;
    private TextView tv2;
    private ImageView im;

    @Override
    public int getCount() {
        return list.size();
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
            convertView =View.inflate(context,R.layout.item,null);
            im = (ImageView) convertView.findViewById(R.id.image);

            tv = (TextView) convertView.findViewById(R.id.title_tv);
            tv2 = (TextView) convertView.findViewById(R.id.mess);
        }
        ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),im,new DisplayImageOptions.Builder().displayer(new RoundedBitmapDisplayer(0)).showImageForEmptyUri(R.mipmap.ic_launcher).build());
        tv.setText(list.get(position).getTitle());
        tv2.setText(list.get(position).getAuthor_name());
        return convertView;
    }
}
