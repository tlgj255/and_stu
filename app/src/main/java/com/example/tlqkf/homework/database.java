package com.example.tlqkf.homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tlqkf on 2016-09-05.
 */
public class database {
    private static final String DATABASE_NAME = "first_DB";
    private static final String DATABASE_TABLE = "first_table";
    private static final int DATABASE_VERSION = 2;
    private final Context mCtx;

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_CREATE="CREATE TABLE " +DATABASE_TABLE+ "" +
            " (    ID    INTEGER PRIMARY    KEY AUTOINCREMENT,     POINT INTEGER,     NAME TEXT)";


    public static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }
        /**
         *
         * @param db         The database.
         * @param oldVersion The old database version.
         * @param newVersion The new database version.
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DATABASE_CREATE);
            onCreate(db);
        }
    }

    public void open() throws SQLException {

        mDbHelper = new DatabaseHelper(mCtx);

        mDb = mDbHelper.getWritableDatabase();
    }

    public database (Context ctx) {
        this.mCtx = ctx;
    }

    public void close() {
        mDbHelper.close();
    }

    public long insert(int point, String name) {
        ContentValues insertValues = new ContentValues();
        insertValues.put("POINT", point);
        insertValues.put("NAME", name);
        return mDb.insert(DATABASE_TABLE, null, insertValues);
    }

    public long update(String id, int point, String name) {
        ContentValues updateValues = new ContentValues();
        updateValues.put("POINT", point);
        updateValues.put("NAME", name);
        return mDb.update(DATABASE_TABLE, updateValues, "ID" + "=?", new String[]{id});
    }

    public boolean deleteRow(String id) {
        return mDb.delete(DATABASE_TABLE, "ID" + "=?", new String[]{id}) > 0;
    }

    public boolean deleteAll() {
        return mDb.delete(DATABASE_TABLE, null, null) > 0;
    }

    public Cursor AllRows() {
        return mDb.query(DATABASE_TABLE, null, null, null, null, null, null);
    }
}