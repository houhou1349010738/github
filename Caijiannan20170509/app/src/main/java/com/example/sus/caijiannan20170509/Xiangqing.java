package com.example.sus.caijiannan20170509;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/9 10:18
 */

public class Xiangqing extends Activity {
    private ImageView im;
    private TextView tv,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiangq);
        im = (ImageView) findViewById(R.id.ivv);
        tv = (TextView) findViewById(R.id.ti_tv);
        tv2 = (TextView) findViewById(R.id.messtv);

        String name = getIntent().getStringExtra("name");
       String image = getIntent().getStringExtra("image");
        String title = getIntent().getStringExtra("title");
        ImageLoader.getInstance().displayImage(image,im,new DisplayImageOptions.Builder().displayer(new RoundedBitmapDisplayer(0)).showImageForEmptyUri(R.mipmap.ic_launcher).build());
        tv.setText(title);
        tv2.setText(name);
    }
}
