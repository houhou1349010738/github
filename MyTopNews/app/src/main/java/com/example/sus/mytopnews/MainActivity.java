package com.example.sus.mytopnews;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.sus.mytopnews.adapter.MagIntorAdapter;
import com.example.sus.mytopnews.adapter.MypagerAdapter;
import com.example.sus.mytopnews.base.BaseFragmentActivity;
import com.example.sus.mytopnews.bean.JsonBean;
import com.example.sus.mytopnews.bean.Mytitle;
import com.example.sus.mytopnews.dao.Daotitle;
import com.example.sus.mytopnews.urlutils.Myurl;
import com.example.sus.mytopnews.xutlis.MyXutlis;
import com.google.gson.Gson;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import net.lucode.hackware.magicindicator.MagicIndicator;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener{


    private ImageView login_iv;
    private ImageView toutiao;
    private ImageView title_bar;
    private ImageView tite_bar2;
    private ImageView shousuo;
    private RelativeLayout ralyout;
    private MagicIndicator mag;
    private ViewPager support;
    private Daotitle daotitle;
    private List<String> list = new ArrayList<>();
    private List<JsonBean.ResultBean.DateBean> date;
    private MagIntorAdapter magIntorAdapter;
    private SlidingMenu menu;
    private Handler han = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
              String inpo = (String) msg.obj;
                Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(inpo, JsonBean.class);
                date = jsonBean.getResult().getDate();
                for(JsonBean.ResultBean.DateBean da:date){
                    Mytitle mytitle = new Mytitle();
                    mytitle.setTitle(da.getTitle());
                    mytitle.setUri(da.getUri());
                    daotitle.addinpo(mytitle);
                }
                //创建Viewpager的适配器
                MypagerAdapter my = new MypagerAdapter(getSupportFragmentManager(),date);
                support.setAdapter(my);//给viewpager设置适配器
            }
        }
    };
    private ImageView jiahao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initview();
        initdata();
        x.view().inject(this);

        new MagIntorAdapter(mag,support,list,this).Mag();


        //监听Viewpager
        support.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
//        SlidingMenu menu = new SlidingMenu(this);
//        menu.setTouchModeAbove(SlidingMenu.LEFT);
//        menu.setShadowWidth(700);
//        menu.setMenu(R.id.alyou);
//        getSupportFragmentManager().beginTransaction().add(R.id.alyou,new LeftFragment(),"f1").commit();
    }


    @Override
    public void initview() {
        jiahao = (ImageView) findViewById(R.id.jiahao);
        login_iv = (ImageView) findViewById(R.id.login_iv);
        toutiao = (ImageView) findViewById(R.id.toutiao);
        title_bar = (ImageView) findViewById(R.id.title_bar);
        tite_bar2 = (ImageView) findViewById(R.id.tite_bar2);
        shousuo = (ImageView) findViewById(R.id.shousuo);
        ralyout = (RelativeLayout) findViewById(R.id.ralyout);
        mag = (MagicIndicator) findViewById(R.id.mag);
        support = (ViewPager) findViewById(R.id.support);
        jiahao.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        daotitle = new Daotitle(this);
        new MyXutlis(han, Myurl.titlwpath).Get("news");
        List<Mytitle> selete = daotitle.selete();
        for(Mytitle my:selete){
            list.add(my.getTitle());
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.jiahao:
//                Intent it = new Intent(MainActivity.this, TopNews_pingdao.class);
//                startActivity(it);
            break;
        }
    }

}
