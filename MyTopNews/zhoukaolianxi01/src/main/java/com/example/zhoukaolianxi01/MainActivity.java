package com.example.zhoukaolianxi01;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.zhoukaolianxi01.UrlUtils.Myurl;
import com.example.zhoukaolianxi01.fragment.Fragment1;
import com.example.zhoukaolianxi01.fragment.LeftFragmnet;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SlidingMenu menu;
    private FragmentManager fm;
    private List<String > far = new ArrayList<>();
    private TextView tvvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvvv = (TextView) findViewById(R.id.title_tv01);
        initdata();
         fm = getSupportFragmentManager();
        //创建一个Slidingmeu的对象
        menu = new SlidingMenu(this);
        //设置菜单的滑动模式可以设置左边滑动右边滑动
        //设置侧滑菜单的位置，可选值LEFT , RIGHT ,LEFT_RIGHT（两边都有菜单时设置
        menu.setMode(SlidingMenu.LEFT);
        //设置触摸屏幕的模式，可选只MARGIN ,CONTENT
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //设置SlidingMenu与下方视图的移动的速度比，当为1时同时移动，取值0-1
        menu.setBehindScrollScale(1.0f);
        menu.setBehindWidth(700);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //设置侧拉菜单加载的指定的布局
        menu.setMenu(R.layout.slidingmenu);
        //将侧拉的菜单创建出来
        LeftFragmnet fragmnet = new LeftFragmnet();
        //给Mainactivty设置一个默认的Fragment
        fm.beginTransaction().add(R.id.activity_main,new Fragment1(far.get(0)))
               .add(R.id.frag,fragmnet).commit();
        //用接口将侧拉界面点击的数据传送过来
               fragmnet.huidiao(new LeftFragmnet.Onclicklisten() {
                   @Override
                   public void getinpo(String title, int older) {
                        //创建一个事物
                       FragmentTransaction tran = fm.beginTransaction();
                       //点击的条目用对应的Fragment替换先前的Fragment
                           tran.replace(R.id.activity_main,new Fragment1(far.get(older)) );
                           Log.e("TAG","123234234243434243242");
                         tran.commit();//事物提交
                    tvvv.setText(title);
           }
       });
    }

    private void initdata() {

        far.add(Myurl.path2);
        far.add(Myurl.path3);
        far.add(Myurl.path4);
    }


}
