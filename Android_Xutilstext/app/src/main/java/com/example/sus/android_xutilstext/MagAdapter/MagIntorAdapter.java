package com.example.sus.android_xutilstext.MagAdapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/10.
 */

public class MagIntorAdapter {
    private MagicIndicator mag;
    private ViewPager vp;
    private List<String> list = new ArrayList<>();

    public MagIntorAdapter(MagicIndicator mag, ViewPager vp, List<String> list, Context context) {
        this.mag = mag;
        this.vp = vp;
        this.list = list;
        this.context = context;
    }

    private Context context;
    public void Mag(){
        //创建一个CommonNavigator给标题设置适配器
        CommonNavigator comm = new CommonNavigator(context);
        comm.setAdapter(new CommonNavigatorAdapter() {
            @Override//设置返回指示器的数据
            public int getCount() {
                return list.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView cli = new ClipPagerTitleView(context);

                cli.setText(list.get(index));
                cli.setTextColor(Color.BLACK);
                cli.setClipColor(Color.RED);
                cli.setTextSize(40);
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
                LinePagerIndicator lin = new LinePagerIndicator(context);
                lin.setLineHeight(10);
                lin.setColors(Color.RED);
                return lin;
            }
        });
        mag.setNavigator(comm);
    }
}
