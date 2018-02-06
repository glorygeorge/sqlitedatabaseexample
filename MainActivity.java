package com.example.george.jsonaction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
ListView listView;
   ArrayList<String> s=new ArrayList<String>();
    ArrayList<String> s1=new ArrayList<String>();
    ArrayList<String> s2=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
listView=(ListView)findViewById(R.id.list);
        String company="{\"Employee\" :[				"
                +"	{                                   "
                +"		\"id\":\"01\",                  "
                +"		\"name\":\"Gopal Varma\",       "
                +"		\"salary\":\"500000\"           "
                +"	},                                  "
                +"	{                                   "
                +"		\"id\":\"02\",                  "
                +"		\"name\":\"Sairamkrishna\",     "
                +"		\"salary\":\"500000\"           "
                +"	},                                  "
                +"	{                                   "
                +"		\"id\":\"03\",                  "
                +"		\"name\":\"Sathish kallakuri\", "
                +"		\"salary\":\"600000\"           "
                +"	}                               "
                +"	]                                   "
                +"	}";
String data="";
        try {
            JSONObject object=new JSONObject(company);
            JSONArray test=object.getJSONArray("Employee");
            for(int i=0;i<test.length();i++)
            {
                JSONObject jsonObject=test.getJSONObject(i);
                int id=Integer.parseInt(jsonObject.optString("id").toString());
                String name=jsonObject.optString("name").toString();
                String salary=jsonObject.optString("salary").toString();
                s.add(String.valueOf(id));
                s1.add(name);
                s2.add(salary);
            }
           Customadapter ad=new Customadapter(getApplicationContext(),s,s1,s2);
            listView.setAdapter(ad);

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
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
if(id==R.id.ret)
{
    Intent i=new Intent(getApplicationContext(),Jsonretrieve.class);
    startActivity(i);
}
        if(id==R.id.send)
        {
            Intent i=new Intent(getApplicationContext(),Jsonsend.class);
            startActivity(i);
        }
        if(id==R.id.imagesend)
        {
            Intent i=new Intent(getApplicationContext(),Imagetext.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
