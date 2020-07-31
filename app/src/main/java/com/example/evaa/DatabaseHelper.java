package com.example.evaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "ITEMS_TABLE";
    private static final String COLUMN_ITEM_NAME = "ITEM_NAME";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "item_table.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ITEM_NAME + " TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    // Method for if the database version number changes
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(String item) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ITEM_NAME, item);

        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<String> getData(){
        List<String> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            // Loop through the cursor
            do {
                String itemName = cursor.getString(1);
                returnList.add(itemName);
            } while (cursor.moveToNext());
        } else {
            // Do not add anything to the list
        }

        // Close both the cursor and the db
        cursor.close();
        db.close();
        return returnList;
    }



}
