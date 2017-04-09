package com.example.sus.caijiannnanwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sus.caijiannnanwork.Adapter.MyBaseAdapter;
import com.example.sus.caijiannnanwork.Bean.JsonBean;
import com.example.sus.caijiannnanwork.Httputlis.MyAsyncTask;
import com.example.sus.caijiannnanwork.Urlutlis.MyUrl;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<JsonBean.ListBean> list;
    private MyBaseAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //通过资源id获取控件
        lv = (ListView) findViewById(R.id.list);
        //创建异步线程
        MyAsyncTask my = new MyAsyncTask();
        //开启异步线程
        my.execute(MyUrl.path);
        //通过接口回调获取网络请求的数据
        my.huidiao(new MyAsyncTask.getjson() {
            @Override
            public void getjsonstr(String str) {
                Log.i("TAG","~~~~~~~~~~"+str);
                Gson gson = new Gson();//创建一个Gson
                //将获取的json串转换成javaBean
                JsonBean jsonBean = gson.fromJson(str, JsonBean.class);
                list = jsonBean.getList();//返回集合
                Log.i("TAG","----------------"+list.get(0).toString());
                myadapter  = new MyBaseAdapter(MainActivity.this,list);
                lv.setAdapter(myadapter);//添加适配器
            }
        });//设置条目点击吐丝站点的id
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"该站点的id"+list.get(i).getId(),Toast.LENGTH_LONG).show();
            }
        });
        //设置长时间的监听删除
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                list.remove(i);
                myadapter.notifyDataSetChanged();
                return false;

            }
        });
    }
}
