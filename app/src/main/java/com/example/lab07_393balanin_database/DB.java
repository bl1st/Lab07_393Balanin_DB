package com.example.lab07_393balanin_database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE my_test (my_key TEXT, my_value TEXT);"; //creating table with 2 columns
        db.execSQL(sql);
    }

    public void do_insert(String key, String value) {

        String sql = "INSERT INTO my_test VALUES ('" + key + "', '" + value + "');"; //insert new row into table
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public String do_select(String key) {

        String sql = "SELECT my_value FROM my_test WHERE my_key = '"+ key +"';"; //finds value inside table by given key
        SQLiteDatabase db = getWritableDatabase();//get ready to read from database
        Cursor cur = db.rawQuery(sql,null); //run query and acquire results in a new "table" with only 1 column

        if (cur.moveToFirst() == true) //jump to the first (and the only one) matching record, if possible
            return cur.getString(0); // return value from the first column (my_value)

        return "(!) not found";
    }

    public String do_update(String key, String value) {

        String sql = "UPDATE my_test SET my_value = ' " + value + "' WHERE my_key = '"+ key +"';"; //update matching records
        SQLiteDatabase db = getWritableDatabase();//get ready to read from database
        db.execSQL(sql);
        return "record updated, check it out";
    }
    public String do_delete(String key) {

        String sql = "DELETE FROM my_test WHERE my_key = '"+ key +"';"; //delete matching records
        SQLiteDatabase db = getWritableDatabase();//get ready to read from database
        db.execSQL(sql);
        return "this record is gone";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
