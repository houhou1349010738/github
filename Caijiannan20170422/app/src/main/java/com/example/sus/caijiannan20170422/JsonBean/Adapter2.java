package com.example.sus.caijiannan20170422.JsonBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sus.caijiannan20170422.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/23.
 */

public class Adapter2 extends BaseAdapter {
    private List<String> list = new ArrayList<>();
    private Context context;
    private TextView tv;

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
            convertView = View.inflate(context,R.layout.item2,null);
            tv = (TextView) convertView.findViewById(R.id.tv);
        }
        tv.setText(list.get(position));
        return convertView;
    }
}
