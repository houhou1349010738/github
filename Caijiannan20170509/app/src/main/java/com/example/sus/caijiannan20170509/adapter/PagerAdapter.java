package com.example.sus.caijiannan20170509.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sus.caijiannan20170509.bean.TitleBean;
import com.example.sus.caijiannan20170509.fragment.MyFragment;
import com.example.sus.caijiannan20170509.fragment.fragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/9 9:47
 */

public class PagerAdapter  extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm, List<TitleBean.ResultBean.DateBean> list) {
        super(fm);
        this.list = list;
    }

    private List<TitleBean.ResultBean.DateBean> list = new ArrayList<>();
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position%2==1){
            Fragment fragment = new MyFragment(list.get(position).getUri());
            return fragment;
        }else if(position%2==0){
            Fragment fragment2 =new fragment2(list.get(position).getUri());
            return fragment2;
        }

        return null;
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}
