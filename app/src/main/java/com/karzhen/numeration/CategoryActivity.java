package com.karzhen.numeration;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.karzhen.data.PostsDbHelper;


public class CategoryActivity extends AppCompatActivity
{

    private EditText etxCategoryName;
    private EditText etxCountingType;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.category_title);

        actionBar.setDisplayHomeAsUpEnabled(true);

        PostsDbHelper dbHelper = new PostsDbHelper(this);
        db = dbHelper.getWritableDatabase();

        etxCategoryName = (EditText) findViewById(R.id.etx_category_name);
        etxCountingType = (EditText) findViewById(R.id.etx_counting_type);
    }

    private void createCategory()
    {
        ContentValues cValues = new ContentValues();
        cValues.put(Posts.CategoryEntry.COLUMN_NAME_CATEGORY_NAME,
                    etxCategoryName.getText().toString());
        cValues.put(Posts.CategoryEntry.COLUMN_NAME_COUNTING_TYPE,
                    etxCountingType.getText().toString());

        long newId = db.insert(Posts.CategoryEntry.TABLE_NAME, null, cValues);
        if (newId > 0)
        {
            Toast.makeText(this, R.string.category_insert_success, Toast.LENGTH_SHORT);
        }
        else
        {
            Toast.makeText(this, R.string.category_insert_failure, Toast.LENGTH_SHORT);
        }
    }

    public void btnSaveCategory_Click(View view)
    {
        createCategory();
    }
}
