package com.example.george.savedata;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addactivity extends AppCompatActivity {
EditText e1,e2;
    Button b1,b2;
    SQLiteDatabase db;
    Dbhelper dbhelper;
    Boolean isupdate;
String nm1,ag1,id1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
isupdate=getIntent().getExtras().getBoolean("value");
        if(isupdate)
        {
            nm1=getIntent().getExtras().getString("title");
            e1.setText(nm1);

            ag1=getIntent().getExtras().getString("note");
            e2.setText(ag1);
            id1=getIntent().getExtras().getString("id");

        }
dbhelper=new Dbhelper(this);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        savedata();
    }
});
    }

    private void savedata() {
        String nm=e1.getText().toString();
        String ag=e2.getText().toString();
        db=dbhelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(dbhelper.NAME,nm);
        values.put(dbhelper.AGE,ag);
        if(isupdate)
        {
            db.update(dbhelper.TABLENAME,values,dbhelper.ID+ "="+id1,null);
        }
        else {
            db.insert(dbhelper.TABLENAME,null,values);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}