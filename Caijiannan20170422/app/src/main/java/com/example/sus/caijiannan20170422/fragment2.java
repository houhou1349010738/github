package com.example.sus.caijiannan20170422;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sus.caijiannan20170422.JsonBean.Json;

import java.util.List;

/**
 * Created by sus on 2017/4/23.
 */

public class fragment2 extends Fragment{
    private ListView list;
    private String url;

    public fragment2(List<Json.DatalistBean> inpo) {
        this.inpo = inpo;
    }

    private List<Json.DatalistBean> inpo;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.frag,container,false);
        list = (ListView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Adapter ada = new Adapter(getActivity(),inpo);
        list.setAdapter(ada);
    }
}
