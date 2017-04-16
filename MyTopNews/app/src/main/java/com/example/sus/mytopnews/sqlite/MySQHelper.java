package com.example.sus.mytopnews.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sus on 2017/4/12.
 */

public class MySQHelper extends SQLiteOpenHelper {
    public MySQHelper(Context context) {
        super(context, "News", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create ="create table topnews(id integer primary key autoincrement,title text UNIQUE,uri text UNIQUE)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
