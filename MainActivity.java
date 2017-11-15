package com.example.george.savedata;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView list;
 //Boolean isupdate;
    SQLiteDatabase db;
    Dbhelper helper;
    private ArrayList<String> userId=new ArrayList<String>();
    private ArrayList<String> name=new ArrayList<String>();
    private ArrayList<String> age=new ArrayList<String>();
    Displayadapter adapter;
    AlertDialog.Builder alert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.);
        list=(ListView)findViewById(R.id.listView);
        helper=new Dbhelper(this);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent in=new Intent(getApplicationContext(),addactivity.class);
                in.putExtra("title",name.get(i));
                in.putExtra("note",age.get(i));
                in.putExtra("value",true);
                in.putExtra("id",userId.get(i));
                startActivity(in);
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
alert=new  AlertDialog.Builder(MainActivity.this,android.R.style.Theme_Holo_Dialog_NoActionBar);
                alert.setTitle("Delete");
                alert.setMessage("Do you Want Delete");
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
db.delete(helper.TABLENAME,helper.ID+"="+userId.get(position),null);
                        displaydata();
                        dialog.cancel();
                    }


                });
                alert.setNegativeButton("no" ,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
AlertDialog build=alert.create();
                build.show();
                return true;
            }
        });

    }
    @Override
protected void onResume()
{
    displaydata();
super.onResume();
}
    private void displaydata() {
        db=helper.getWritableDatabase();
        Cursor mcursor=db.rawQuery("SELECT * FROM "+Dbhelper.TABLENAME,null);
        name.clear();
        age.clear();
        userId.clear();
        if(mcursor.moveToFirst())
        {
            do {
userId.add(mcursor.getString(mcursor.getColumnIndex(Dbhelper.ID)));
                name.add(mcursor.getString(mcursor.getColumnIndex(Dbhelper.NAME)));
                age.add(mcursor.getString(mcursor.getColumnIndex(Dbhelper.AGE)));
            }
            while (mcursor.moveToNext());
        }
         adapter=new Displayadapter(getApplicationContext(),userId,name,age);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if(id==R.id.add)
        {
         Intent in=new Intent(getApplicationContext(),addactivity.class);
            in.putExtra("value",false);
            startActivity(in);
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}
