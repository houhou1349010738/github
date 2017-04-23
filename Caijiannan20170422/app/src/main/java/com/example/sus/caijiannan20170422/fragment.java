package com.example.sus.caijiannan20170422;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/23.
 */

public class fragment extends Fragment{

    private ListView list;
    private indexs indexs;
    private List<String> name = new ArrayList<>();
    private int tag=-1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2,container,false);

        return view;
    }
    public interface indexs{
        public void index(int ins);
    }
    public void huidiao(indexs ins){
        this.indexs=ins;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initdata();
        list = (ListView) getView().findViewById(R.id.list_mess);
        list.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,name));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               indexs.index(position);
                if(tag!=position){
                    view.setBackgroundColor(Color.RED);
                }
                //如果 下标不等于-1 就说明 已经保存了上一次的点击下标
                //将上一次的下标对象 返回为透明色
                if(tag!=-1){
                    parent.getChildAt(tag).setBackgroundColor(Color.TRANSPARENT);

                }
                //保存上次点击下标
                tag = position;

            }
        });
    }

    private void initdata() {
        name.add("条目 0 1");
        name.add("条目 2 3");
        name.add("条目 4 5");
        name.add("条目 6 7");
        name.add("条目 8 9");
    }

}
