package com.example.sus.caijiannan20170509;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.sus.caijiannan20170509.adapter.PagerAdapter;
import com.example.sus.caijiannan20170509.bean.TitleBean;
import com.example.sus.caijiannan20170509.uritype.Uri;
import com.google.gson.Gson;

import net.lucode.hackware.magicindicator.MagicIndicator;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private MagicIndicator mag;
    private ViewPager vp;
    private   Handler han = new Handler(){

        private List<TitleBean.ResultBean.DateBean> date;

        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
             String json = (String) msg.obj;
                Gson gson = new Gson();
                TitleBean titleBean = gson.fromJson(json, TitleBean.class);
                date = titleBean.getResult().getDate();
//                MagAdapter magAdapter = new MagAdapter(vp,MainActivity.this,date);
//                CommonNavigator com = new CommonNavigator(MainActivity.this);
//                com.setAdapter(magAdapter);
//                mag.setNavigator(com);
                for(int i=0;i<date.size();i++){
                    tabLayout.addTab(tabLayout.newTab().setText(date.get(i).getTitle()));
                }
                tabLayout.setupWithViewPager(vp);
                tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),date);
                vp.setAdapter(pagerAdapter);
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        new XulisGet(han).xutlisGet(Uri.path,"news");
        mag = (MagicIndicator) findViewById(R.id.mag);
        tabLayout = (TabLayout) findViewById(R.id.tab);

    }

}
