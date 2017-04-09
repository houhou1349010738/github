package com.example.sus.myandroid_studiotext;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sus.myandroid_studiotext.Fragment.Fragment1;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SlidingMenu menu = new SlidingMenu(this);//创建slidingMenu的对象
        //设定SlidingMenu的模式设置slidingMenu在屏幕哪边
        /**
         * menu.setMode(SlidingMenu.LEFT);
         * 如果只显示左侧菜单就是用LEFT,右侧就RIGHT，
         * 左右都支持就LEFT_RIGHT
         */
        menu.setMode(SlidingMenu.LEFT);
        /**
         * SlidingMenu滑出时主页面显示的剩余宽度
         * menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
         *
         *
         */
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//设置在整个屏幕都可以滑动
        menu.setShadowDrawable(R.mipmap.ic_launcher);

        //SlidingMenu滑动时的渐变程度
        menu.setFadeDegree(0.35f);
        menu.setBehindWidth(700);//设置SlidingMenu菜单的宽度
        //使SlidingMenu附加在Activity上
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
       //设置menu的布局文件
        menu.setMenu(R.layout.menu);//在同一个Activity上添加另一个视图
        //监听Slidingmenu在打开后加载一个指定的Fragmnet

        menu.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {
            @Override
            public void onOpened() {


                getSupportFragmentManager().beginTransaction().add(R.id.fragment, new Fragment1()).commit();
            }
        });


    }
}
