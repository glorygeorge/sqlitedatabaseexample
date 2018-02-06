package com.example.george.eduvideo;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
ListView listView;

    ArrayList<String>idarray=new ArrayList<>();

    ArrayList<String>namearray=new ArrayList<>();
    ArrayList<String>patharray=new ArrayList<>();
    ArrayList<String>typearray=new ArrayList<>();
    CustomAdapter1 adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        listView=(ListView)findViewById(R.id.list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent inten=new Intent(getApplicationContext(),VideoActivity.class);
                inten.putExtra("path",patharray.get(position));
            }
        });
        RequestQueue queue= Volley.newRequestQueue(this);
        String url="https://georgedevelop.000webhostapp.com/php/videoretrive.php";
        StringRequest request=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Toast.makeText(getApplicationContext(),"Response"+s,Toast.LENGTH_LONG).show();
                        try {
                            JSONArray array=new JSONArray(s);
                            for(int i=0;i<array.length();i++)
                            {
                                JSONObject object=array.getJSONObject(i);
                                int id=Integer.parseInt(object.optString("id").toString());
                                String name=object.optString("name").toString();
                                String path=object.optString("path").toString();
                                String type=object.optString("type").toString();
                                idarray.add((String.valueOf(id)));
                                namearray.add(name);
                                patharray.add(path);

                                typearray.add(type);

                            }
                            adapter1=new CustomAdapter1(getApplicationContext(),idarray,namearray,patharray,typearray);
                            listView.setAdapter(adapter1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getApplicationContext(),"Error Response"+volleyError,Toast.LENGTH_LONG).show();

                    }
                }


        );
        queue.add(request);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),VideoActivity.class);
                intent.putExtra("url",patharray.get(position));
                startActivity(intent);
            }
        });
    }
    }

