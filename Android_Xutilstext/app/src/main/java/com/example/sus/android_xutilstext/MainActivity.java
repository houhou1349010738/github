package com.example.sus.android_xutilstext;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.sus.android_xutilstext.Fragment.Fragment1;
import com.example.sus.android_xutilstext.MagAdapter.MagIntorAdapter;
import com.example.sus.android_xutilstext.MyAdapter.MypagerAdapter;
import com.example.sus.android_xutilstext.Urlutlis.MyUrl;

import net.lucode.hackware.magicindicator.MagicIndicator;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private List<String> list;
    private MagicIndicator mag;
    private List<Fragment> frag = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        list.add("推荐");list.add("热点");list.add("本地");list.add("视频");list.add("社会");
        list.add("娱乐");list.add("科技");list.add("汽车");list.add("体育");list.add("财经");
        frag.add(new Fragment1(MyUrl.path,"jinritouxiaotoutiao"));
        frag.add(new Fragment1(MyUrl.path2,"jinritoutiaoshehui"));frag.add(new Fragment1(MyUrl.path3,"jinritoutiao"));
        frag.add(new Fragment1(MyUrl.path4,"jinritoutiaoguoji"));frag.add(new Fragment1(MyUrl.path5,"jinritoutiaoyule"));
        frag.add(new Fragment1(MyUrl.path6,"jinritoutiaotiyu"));frag.add(new Fragment1(MyUrl.path7,"jinritoutiaojunshi"));
        frag.add(new Fragment1(MyUrl.path8,"jinritoutiaokeji"));frag.add(new Fragment1(MyUrl.path9,"jinritoutiaocaijing"));
        frag.add(new Fragment1(MyUrl.path10,"jinritoutiaoshishang"));
    }
    }

