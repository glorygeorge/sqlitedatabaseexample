package com.example.george.jsonaction;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Jsonretrieve extends AppCompatActivity {
ListView listView;
    ArrayList<String> na=new ArrayList<>();
    ArrayList<String> ag=new ArrayList<>();
    ArrayList<String> nat=new ArrayList<>();
    ArrayList<String> mo=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonretrieve);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
listView=(ListView)findViewById(R.id.listview);
        StrictMode.enableDefaults();
        getdata();
    }

   public void getdata() {
       String result="";
       InputStream isr=null;
       try {
           HttpClient httpclient=new DefaultHttpClient();
           HttpPost httppost=new HttpPost("http://192.168.43.235/php/reterive.php");
           HttpResponse httpresponse=httpclient.execute(httppost);
           HttpEntity httpentity=httpresponse.getEntity();
           isr=httpentity.getContent();


       }
       catch (Exception e)
       {
     e.printStackTrace();
           Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
       }
       try {
           BufferedReader reader=new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
           StringBuilder builder=new StringBuilder();
           String line=null;
           while ((line=reader.readLine())!=null){
               builder.append(line +"\n");
           }
isr.close();
           result=builder.toString();

       }catch (Exception e)
       {
           e.printStackTrace();

       }
       try {
           String name="";
           String age="";
           String nationality="";
           String mobile="";
           JSONArray array=new JSONArray(result);
           for(int i=0;i<array.length();i++)
           {
JSONObject object=array.getJSONObject(i);
               name=name+object.getString("name").toString();
               age=age+object.getString("age").toString();
               nationality=nationality+object.getString("nationality").toString();
               mobile=mobile+object.getString("mobile").toString();
               na.add(name);
               ag.add(age);
               nat.add(nationality);
               mo.add(mobile);
           }
           Ownadapter adapter=new Ownadapter(getApplicationContext(),na,ag,nat,mo);
           listView.setAdapter(adapter);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }


    }

}
