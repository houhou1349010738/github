package com.example.sus.android_xutilstext.Xutils;


import android.widget.ImageView;

import com.example.sus.android_xutilstext.R;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;


/**
 * Created by sus on 2017/4/10.
 */

public class MyImage {
    public void show(String url, ImageView iv){
        x.image().bind(iv,url,new ImageOptions.Builder().setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120)).setRadius(DensityUtil.dip2px(5)).setFailureDrawableId(R.mipmap.ic_launcher).setLoadingDrawableId(R.mipmap.ic_launcher).build());
    }
}
