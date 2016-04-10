package com.example.talizorah.finalapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by talizorah on 16.4.4.
 */
public class SchedulerDataBaseHelper {
    private SQLiteOpenHelper sqLiteOpenHelper;
    public SchedulerDataBaseHelper(Context context){
        sqLiteOpenHelper = new SchedulerDataOpenHelper(context);
    }

    class SchedulerDataOpenHelper extends SQLiteOpenHelper{

        public  SchedulerDataOpenHelper(Context context){
            super(context, SchedulerProvider.DB_SCHEDULER_NAME, null,
                    SchedulerProvider.DB_SCHEDULER_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table " + SchedulerProvider.TABLE_NAME + " (" +
                        SchedulerProvider.TABLE_ID + " integer primary key autoincrement, " +
                        SchedulerProvider.TABLE_SCHED_NAME + " text, " +
                        SchedulerProvider.TABLE_SCHED_TEXT + " text,  " +
                        SchedulerProvider.TABLE_SCHED_DATE + " text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + SchedulerProvider.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor getAll(){
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
        if(db == null)
            return null;
        String query = "select * from " + SchedulerProvider.TABLE_NAME;
        Cursor cur = db.rawQuery(query, null);
        return cur;
    }

    public int add(String noteName, String noteText, String noteDate) {
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        if (db == null) {
            return 0;
        }
        ContentValues row = new ContentValues();
        row.put(SchedulerProvider.TABLE_SCHED_NAME, noteName);
        row.put(SchedulerProvider.TABLE_SCHED_TEXT, noteText);
        row.put(SchedulerProvider.TABLE_SCHED_DATE, noteDate);
        int id = (int)db.insert(SchedulerProvider.TABLE_NAME, null, row);
        db.close();
        return id;
    }

    public void delete(long id) {
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        if (db == null) {
            return;
        }
        db.delete(SchedulerProvider.TABLE_NAME, SchedulerProvider.TABLE_ID + "=" + id, null);
        db.close();
    }


    public void clear(){
        //Clearing the database with name ->
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        db.delete(SchedulerProvider.TABLE_NAME, null, null);
    }
}
