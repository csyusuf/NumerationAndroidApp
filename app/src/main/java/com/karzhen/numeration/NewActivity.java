package com.karzhen.numeration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import com.karzhen.data.CategoryData;
import com.karzhen.data.PostsDbHelper;

public class NewActivity extends AppCompatActivity
{
    private SQLiteDatabase db;

    private EditText etxActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.activity_title);

        actionBar.setDisplayHomeAsUpEnabled(true);

        PostsDbHelper dbHelper = new PostsDbHelper(this);
        db = dbHelper.getWritableDatabase();

        etxActivityName = (EditText) findViewById(R.id.etx_activity_name);
        setDataToSpinner();
    }

    private void setDataToSpinner()
    {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] adapterCols = new String[]{Posts.CategoryEntry.COLUMN_NAME_CATEGORY_NAME};
        int[] adapterRowViews=new int[]{android.R.id.text1};
        Cursor cursor = new CategoryData(this).getCategoryTypes();

        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor,
                                                        adapterCols, adapterRowViews, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER  );
        spinner.setAdapter(adapter);
    }
}
