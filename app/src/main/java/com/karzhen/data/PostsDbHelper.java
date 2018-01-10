package com.karzhen.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.karzhen.numeration.Posts;

/**
 * Created by Yusuf on 12/11/2017.
 */

public class PostsDbHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Activities.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ACTIVITY_ENTRIES = "CREATE TABLE " + Posts.ActivityEntry.TABLE_NAME + " (" +
            Posts.ActivityEntry._ID + " INTEGER PRIMARY KEY," +
            Posts.ActivityEntry.COLUMN_NAME_ACTIVITY_NAME + TEXT_TYPE + COMMA_SEP +
            Posts.ActivityEntry.COLUMN_NAME_CATEGORY_ID + TEXT_TYPE + " )";

    private static final String SQL_CREATE_CATEGORY_ENTRIES = "CREATE TABLE " + Posts.CategoryEntry.TABLE_NAME + " (" +
            Posts.CategoryEntry._ID + " INTEGER PRIMARY KEY," +
            Posts.CategoryEntry.COLUMN_NAME_CATEGORY_NAME + TEXT_TYPE + COMMA_SEP +
            Posts.CategoryEntry.COLUMN_NAME_COUNTING_TYPE + TEXT_TYPE + " )";

    private static final String SQL_CREATE_PROGRESS_ENTRIES = "CREATE TABLE " + Posts.ProgressEntry.TABLE_NAME + " (" +
            Posts.ProgressEntry._ID + " INTEGER PRIMARY KEY," +
            Posts.ProgressEntry.COLUMN_NAME_ACTIVITY_ID + " INTEGER" + COMMA_SEP +
            Posts.ProgressEntry.COLUMN_NAME_PROGRESS + " INTEGER" + COMMA_SEP +
            Posts.ProgressEntry.COLUMN_NAME_DATE + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ACTIVITY_ENTRIES = "DROP TABLE IF EXISTS " + Posts.ActivityEntry.TABLE_NAME;
    private static final String SQL_DELETE_CATEGORY_ENTRIES = "DROP TABLE IF EXISTS " + Posts.CategoryEntry.TABLE_NAME;
    private static final String SQL_DELETE_PROGRESS_ENTRIES = "DROP TABLE IF EXISTS " + Posts.ProgressEntry.TABLE_NAME;

    public PostsDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ACTIVITY_ENTRIES);
        db.execSQL(SQL_CREATE_CATEGORY_ENTRIES);
        db.execSQL(SQL_CREATE_PROGRESS_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_ACTIVITY_ENTRIES);
        db.execSQL(SQL_DELETE_CATEGORY_ENTRIES);
        db.execSQL(SQL_DELETE_PROGRESS_ENTRIES);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db,oldVersion,newVersion);
    }
}
