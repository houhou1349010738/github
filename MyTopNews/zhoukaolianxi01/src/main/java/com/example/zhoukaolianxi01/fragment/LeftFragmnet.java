package com.example.zhoukaolianxi01.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhoukaolianxi01.Bean.Jsonbean;
import com.example.zhoukaolianxi01.Httputlis.MyHttp;
import com.example.zhoukaolianxi01.R;
import com.example.zhoukaolianxi01.UrlUtils.Myurl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sus on 2017/4/15.
 */

public class LeftFragmnet extends Fragment {

    private ListView list;
    private TextView tv;
    private Onclicklisten oncli;
    private  List<String> name= new ArrayList<>();
    private Handler han = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                String str = (String) msg.obj;
                Gson gson = new Gson();
                Jsonbean jsonbean = gson.fromJson(str, Jsonbean.class);
                List<Jsonbean.DataBean> data = jsonbean.getData();
                for (Jsonbean.DataBean d:data) {
                 name.add(d.getName());
                }
                list.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,name));

            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.laftffrag,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new MyHttp(han,Myurl.path).start();
        list = (ListView) getView().findViewById(R.id.list);
        tv = (TextView) getView().findViewById(R.id.title_tv);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                oncli.getinpo(name.get(position),position);
            }
        });




    }

    public interface Onclicklisten{
        public void getinpo(String title,int older);
    }
    public void huidiao(Onclicklisten on){
      this.oncli=on;
    }
}
