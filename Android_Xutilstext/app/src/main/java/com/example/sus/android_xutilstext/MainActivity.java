package com.example.sus.android_xutilstext;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.sus.android_xutilstext.Fragment.Fragment1;
import com.example.sus.android_xutilstext.MagAdapter.MagIntorAdapter;
import com.example.sus.android_xutilstext.MyAdapter.MypagerAdapter;
import com.example.sus.android_xutilstext.Urlutlis.MyUrl;
import com.example.sus.android_xutilstext.Xutils.Xutilspost;

import net.lucode.hackware.magicindicator.MagicIndicator;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager vp;
    private List<String> list;
    private MagicIndicator mag;
    private List<Fragment> frag = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG","---------------------------234");
       new Xutilspost("http://result.eolinker.com/gfGTLlHc049c6b450500b16971f52bd8e83f6b2fed305ab").Post("news");

        initdata();//创建一个初始化数据的方法
        initview();//创建一个通过资源id获取控件的方法
        x.view().inject(this);//初始化xutlis
        //给标题设置指示器
       new MagIntorAdapter(mag,vp,list,this).Mag();
        //创建Viewpager的适配器
        MypagerAdapter my = new MypagerAdapter(getSupportFragmentManager(),frag);
        vp.setAdapter(my);//给viewpager设置适配器
        //监听Viewpager
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mag.onPageScrolled(position,positionOffset,positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                mag.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mag.onPageScrollStateChanged(state);
            }
        });
    }

    private void initview() {
        mag = (MagicIndicator) findViewById(R.id.mag);
        vp = (ViewPager) findViewById(R.id.support);
    }

    private void initdata() {
        list = new ArrayList<>();
        list.add("头条");list.add("社会");list.add("国内");list.add("国际");list.add("娱乐");
        list.add("体育");list.add("军事");list.add("科技");list.add("财经");list.add("时尚");
        frag.add(new Fragment1(MyUrl.path,"jinritouxiaotoutiao"));
        frag.add(new Fragment1(MyUrl.path,"jinritoutiaoshehui"));frag.add(new Fragment1(MyUrl.path,"jinritoutiao"));
        frag.add(new Fragment1(MyUrl.path,"jinritoutiaoguoji"));frag.add(new Fragment1(MyUrl.path,"jinritoutiaoyule"));
        frag.add(new Fragment1(MyUrl.path,"jinritoutiaotiyu"));frag.add(new Fragment1(MyUrl.path,"jinritoutiaojunshi"));
        frag.add(new Fragment1(MyUrl.path,"jinritoutiaokeji"));frag.add(new Fragment1(MyUrl.path,"jinritoutiaocaijing"));
        frag.add(new Fragment1(MyUrl.path,"jinritoutiaoshishang"));

    }
    }

