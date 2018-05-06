package com.app.omandiscount.SqliteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NyesteVenture3 on 4/1/2018.
 */

public class Database extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME="oman.db";
    private static final Integer DATABASE_VERSION=1;


    public Database(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
