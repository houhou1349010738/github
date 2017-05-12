package com.example.recyclerviewchexbax.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.recyclerviewchexbax.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/12 19:51
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> list = new ArrayList<>();
    private boolean bo=false;
    private Context context;
    private Map<Integer,Boolean> map = new HashMap<>();
    public RecyclerViewAdapter(Context context, List<String> list,Map<Integer,Boolean>map) {
        this.context = context;
        this.list = list;
        this.map=map;
            }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paren, int viewType) {


        //创建一个Holderview填充一个子布局
        Holderview holderview = new Holderview(LayoutInflater.from(context).inflate(R.layout.recycleritem,paren,false));

        return holderview;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //强转成Holderview调用其属性
        Holderview holderview= (Holderview) holder;
        //给条目设置数据
        holderview.tv.setText(list.get(position));
        //创建一个缩放动画
        holderview.checkBox.setChecked(map.get(position));
        holderview.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                map.put(position,isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //创建一个优化的内部类
    public static class Holderview extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        TextView tv;
        public Holderview(View itemView) {
            super(itemView);
            //获取控件的资源id
            checkBox = (CheckBox) itemView.findViewById(R.id.rec_check);
            tv = (TextView) itemView.findViewById(R.id.rec_tv);
        }
    }
    public void chexed(){
       for(int i=0;i<map.size();i++){
           map.put(i,true);
       }
        notifyDataSetChanged();
    }
    public void chexeds(){
        for(int i=0;i<map.size();i++){
            map.put(i,false);
        }
        notifyDataSetChanged();
    }

}
