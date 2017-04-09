package com.example.sus.caijiannnanwork.Fragment1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sus.caijiannnanwork.Adapter.MyBaseAdapter2;
import com.example.sus.caijiannnanwork.Bean.User;
import com.example.sus.caijiannnanwork.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/9.
 */

public class Fragment1 extends Fragment {
    private ListView list;
    private List<User> userlist = new ArrayList<>();
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

        initdata();
        MyBaseAdapter2 my2 = new MyBaseAdapter2();

        list.setAdapter(my2);
    }

    private void initdata() {
        userlist.add(new User(R.mipmap.shouc,"我的收藏"));
        userlist.add(new User(R.mipmap.yingy,"应用宝"));
        userlist.add(new User(R.mipmap.yiny,"快听音乐"));
        userlist.add(new User(R.mipmap.yuedu,"QQ阅读"));
        userlist.add(new User(R.mipmap.jingd,"京东商城"));
        userlist.add(new User(R.mipmap.dongm,"动漫惊喜"));
        userlist.add(new User(R.mipmap.lx,"摄像"));

    }
}
