package com.example.sus.caijiannan20170509.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.sus.caijiannan20170509.bean.TitleBean;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.List;

/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/9 9:38
 */

public class MagAdapter extends CommonNavigatorAdapter{
    private ViewPager vp;
    private Context context;
    private List<TitleBean.ResultBean.DateBean> list;

    public MagAdapter( ViewPager vp, Context context, List<TitleBean.ResultBean.DateBean> list) {
        this.vp = vp;
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        ClipPagerTitleView cli = new ClipPagerTitleView(context);
        cli.setTextColor(Color.RED);
        cli.setTextSize(30);
        cli.setText(list.get(index).getTitle());
        cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(index);
            }
        });
        return cli;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        return null;
    }

}
