package com.example.sus.caijiannan20170422;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by sus on 2017/4/22.
 */

public class NewsConnType {
    public boolean isNetworkConnected(Context context) {
            if (context != null) {
                    ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                            .getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
                    if (mNetworkInfo != null) {
                          return mNetworkInfo.isAvailable();
                        }
                }
            return false;
         }
    //判断Wifi是否可用
    public boolean isWifiConnected(Context context) {
            if (context != null) {
                ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                           .getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                            .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                    if (mWiFiNetworkInfo != null) {
                            return mWiFiNetworkInfo.isAvailable();
                       }
                 }
          return false;
         }
}
