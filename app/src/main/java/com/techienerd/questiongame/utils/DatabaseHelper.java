package com.techienerd.questiongame.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.techienerd.questiongame.model.MOption;
import com.techienerd.questiongame.model.MScore;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/16/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "friends.db";
    private static final int DATABASE_VERSION = 3;

    public static final String TABLE_FRIENDS = "friends";

    private static final String KEY_ID = "id";
    private static final String KEY_FAV = "fav";
    private static final String KEY_OPTION = "op";
    private static final String KEY_PRESENT_SCORE = "ps";
    private static final String KEY_BEST_SCORE = "bs";


    private String CREATE_TABLE_CONTUCTS = "create table " + TABLE_FRIENDS + "(" + KEY_ID + " integer primary key autoincrement,"
            + KEY_PRESENT_SCORE + " integer,"
            + KEY_FAV + " integer,"
            + KEY_OPTION + " text,"
            + KEY_BEST_SCORE + " integer )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTUCTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exists " + TABLE_FRIENDS);
        onOpen(db);

    }


    public void addBestScore(MScore mList) {
        Cursor cursor = null;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_ID, mList.getParentId());
            values.put(KEY_PRESENT_SCORE, mList.getBestScore());
            values.put(KEY_BEST_SCORE, mList.getBestScore());

            String sql = "select * from " + TABLE_FRIENDS + " where " + KEY_ID + "='" + mList.getParentId() + "'";
            cursor = db.rawQuery(sql, null);
            if (cursor != null && cursor.getCount() > 0) {
                int update = db.update(TABLE_FRIENDS, values, KEY_ID + "=?", new String[]{mList.getParentId() + ""});
                Log.e("log", "content update : " + update);
            } else {
                long v = db.insert(TABLE_FRIENDS, null, values);
                Log.e("log", "content insert : " + v);

            }


        } catch (
                Exception e
                )

        {

        }

        if (cursor != null)
            cursor.close();


    }

    public void addFavData(MOption mOption) {
        Cursor cursor = null;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_FAV, mOption.getFav());
            values.put(KEY_OPTION, mOption.getOption());

            String sql = "select * from " + TABLE_FRIENDS + " where " + KEY_ID + "='" + mOption.getId() + "'";
            cursor = db.rawQuery(sql, null);
            if (cursor != null && cursor.getCount() > 0) {
                int update = db.update(TABLE_FRIENDS, values, KEY_ID + "=?", new String[]{mOption.getId() + ""});
                Log.e("log", "content update : " + update);
            } else {
                long v = db.insert(TABLE_FRIENDS, null, values);
                Log.e("log", "content insert : " + v);

            }


        } catch (
                Exception e
                )

        {

        }

        if (cursor != null)
            cursor.close();


    }

    public int deleteCotact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_FRIENDS, KEY_ID + "=?", new String[]{id + ""});
        return result;
    }

    public int getBestScores(int parentId) {
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_FRIENDS + " where " + KEY_ID + "='" + parentId + "'";

        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                int bestScore = cursor.getInt(cursor.getColumnIndex(KEY_BEST_SCORE));
                result = bestScore;

            } while (cursor.moveToNext());
        }
        return result;
    }

    public ArrayList<MOption> getFavData() {
        ArrayList<MOption> mOptions = new ArrayList<>();
        MOption mOption;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_FRIENDS + " where " + KEY_FAV + "='" + 1 + "'";

        Cursor cursor = db.rawQuery(sql, null);
        Log.e("cursor", "size " + cursor.getCount());
        if (cursor != null && cursor.getCount() > 0) {

            cursor.moveToFirst();
            do {
                mOption = new MOption();
                mOption.setFav(cursor.getInt(cursor.getColumnIndex(KEY_FAV)));
                mOption.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                mOption.setOption(cursor.getString(cursor.getColumnIndex(KEY_OPTION)));
                mOptions.add(mOption);

            } while (cursor.moveToNext());
        }
        return mOptions;
    }

    public ArrayList<MOption> getData() {
        ArrayList<MOption> mOptions = new ArrayList<>();
        MOption mOption;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_FRIENDS;

        Cursor cursor = db.rawQuery(sql, null);
        Log.e("cursor", "size " + cursor.getCount());
        if (cursor != null && cursor.getCount() > 0) {

            cursor.moveToFirst();
            do {
                mOption = new MOption();
                mOption.setFav(cursor.getInt(cursor.getColumnIndex(KEY_FAV)));
                mOption.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                mOption.setOption(cursor.getString(cursor.getColumnIndex(KEY_OPTION)));
                mOptions.add(mOption);

            } while (cursor.moveToNext());
        }
        return mOptions;
    }


}
