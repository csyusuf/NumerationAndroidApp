package com.karzhen.data;

import android.content.Context;
import android.database.Cursor;

import com.karzhen.numeration.Posts;

/**
 * Created by Yusuf on 1/2/2018.
 */

public class CategoryData
{
    private PostsDbHelper mDbHelper;
    private Context context;
    public CategoryData(Context context)
    {
        this.context = context;
    }

    public Cursor getCategoryTypes()
    {
        Cursor cursor;
        mDbHelper = new PostsDbHelper(context);
        cursor = mDbHelper.getReadableDatabase().query(Posts.CategoryEntry.TABLE_NAME, new String[]{
                Posts.CategoryEntry._ID, Posts.CategoryEntry.COLUMN_NAME_CATEGORY_NAME},null,null,null,null,null);
        return cursor;
    }
}
