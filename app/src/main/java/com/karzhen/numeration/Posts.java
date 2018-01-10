package com.karzhen.numeration;

import android.provider.BaseColumns;

/**
 * Created by Yusuf on 12/11/2017.
 */

public class Posts
{
    public Posts(){}

    public static abstract class CategoryEntry implements BaseColumns{
        public static final String TABLE_NAME = "category";
        public static final String COLUMN_NAME_CATEGORY_NAME = "name";
        public static final String COLUMN_NAME_COUNTING_TYPE = "counting_type";
    }

    public static abstract class ActivityEntry implements BaseColumns{
        public static final String TABLE_NAME = "activity";
        public static final String COLUMN_NAME_ACTIVITY_NAME = "name";
        public static final String COLUMN_NAME_CATEGORY_ID = "category_id";
    }

    public static abstract class ProgressEntry implements BaseColumns{
        public static final String TABLE_NAME = "progress";
        public static final String COLUMN_NAME_ACTIVITY_ID = "activity_id";
        public static final String COLUMN_NAME_PROGRESS = "progress";
        public static final String COLUMN_NAME_DATE = "date";
    }
}
