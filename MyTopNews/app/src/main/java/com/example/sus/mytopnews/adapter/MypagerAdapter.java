package com.example.sus.mytopnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sus.mytopnews.bean.JsonBean;
import com.example.sus.mytopnews.fragnemt.Fragment1;
import com.example.sus.mytopnews.urlutils.Myurl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/10.
 */

public class MypagerAdapter extends FragmentPagerAdapter {
    List<JsonBean.ResultBean.DateBean> list = new ArrayList<>();

    public MypagerAdapter(FragmentManager fm, List<JsonBean.ResultBean.DateBean> list) {
        super(fm);
        this.list = list;
    }

    public MypagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

            Fragment1 fragment1 = new Fragment1(Myurl.mess,list.get(position).getUri());

        return fragment1;
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }
}
