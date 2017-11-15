package com.example.george.savedata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by george on 10/11/2017.
 */
public class Dbhelper extends SQLiteOpenHelper {
    public static String DATABASENAME="sample";
    public static String TABLENAME="persondetails";
    public static String ID="id";
    public static String NAME="name";
    public static String AGE="age";

    public Dbhelper(Context context) {
        super(context, DATABASENAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="create table "+TABLENAME+" ("+ID+" INTEGER PRIMARY KEY,"+NAME+" TEXT,"+AGE+" TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
