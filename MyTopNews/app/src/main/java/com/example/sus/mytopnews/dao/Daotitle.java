package com.example.sus.mytopnews.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sus.mytopnews.bean.Mytitle;
import com.example.sus.mytopnews.sqlite.MySQHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sus on 2017/4/12.
 */

public class Daotitle  {

    private SQLiteDatabase db;
    public Daotitle(Context context) {
        db = new MySQHelper(context).getReadableDatabase();
    }
    public void addinpo(Mytitle mytitle){
        ContentValues values = new ContentValues();
        values.put("title",mytitle.getTitle());
        values.put("uri",mytitle.getUri());
        db.insert("topnews",null,values);
    }
    public List<Mytitle> selete(){
        List<Mytitle> list = new ArrayList<>();
        Cursor topnews = db.query("topnews", null, null, null, null, null, null);
       while(topnews.moveToNext()){
           Mytitle my = new Mytitle();
          String title = topnews.getString(topnews.getColumnIndex("title"));
           String uri = topnews.getString(topnews.getColumnIndex("uri"));
           my.setTitle(title);
           my.setUri(uri);
           list.add(my);
       }
        return list;
    }

}
