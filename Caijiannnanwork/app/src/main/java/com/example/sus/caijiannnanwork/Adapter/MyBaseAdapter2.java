package com.example.sus.caijiannnanwork.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sus.caijiannnanwork.Bean.User;
import com.example.sus.caijiannnanwork.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/9.
 */

public class MyBaseAdapter2 extends BaseAdapter {
    private Context context;
    private List<User> list = new ArrayList<>();
    private ImageView image;
    private TextView tv;

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
            convertView = View.inflate(context,R.layout.item2,null);
            image = (ImageView) convertView.findViewById(R.id.item_iv);
            tv = (TextView) convertView.findViewById(R.id.item_tv);
            image.setBackgroundResource(list.get(position).getImage());
            tv.setText(list.get(position).getName());
        }
        return convertView;
    }
}
