package com.app.hack.toppr.ultis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ajay Kumar on 9/25/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="FavEventDatabase.db";
    private static final int DATABASE_VERSION = 1;
    public static final String FAV_TABLE_NAME = "fav";
    public static final String FAV_COLUMN_ID = "_id";
    public static final String FAV_COLUMN_EVENT_NAME = "name";
    public static final String FAV_COLUMN_CATEGORY = "category";
    public static final String FAV_COLUMN_IMAGE_URL = "age";

    public DataBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + FAV_TABLE_NAME + "(" +
                FAV_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                FAV_COLUMN_EVENT_NAME + " TEXT, " +
                FAV_COLUMN_CATEGORY + " TEXT, " +
                FAV_COLUMN_IMAGE_URL + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + FAV_TABLE_NAME);
        onCreate(db);
    }

    public Cursor getAllPersons() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + FAV_TABLE_NAME, null );
        return res;
    }


    public boolean insertPerson(String name, String gender, int age) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FAV_COLUMN_EVENT_NAME, name);
        contentValues.put(FAV_COLUMN_CATEGORY, gender);
        contentValues.put(FAV_COLUMN_IMAGE_URL, age);
        db.insert(FAV_TABLE_NAME, null, contentValues);
        return true;
    }
}
