package com.example.properprepapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "USER_RECORD";
    private static final String TABLE_NAME = "USER_DATA";
    private static final String COL_1 = "EMAIL";
    private static final String COL_2 = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(EMAIL TEXT PRIMARY KEY, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean registerUser(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1, email);
        values.put(COL_2, password);
        long result = db.insert(TABLE_NAME, null, values);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUser(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String [] columns = { COL_1 };
        String selection = COL_1 + "=?" + " and " + COL_2 + "=?" ;
        String [] selectionargs = { email, password };
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionargs, null, null, null );
        int count = cursor.getCount();
        db.close();
        cursor.close();
        if(count > 0){
            return true;
        } else {
            return false;
        }
    }
}
