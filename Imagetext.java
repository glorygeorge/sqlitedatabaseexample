package com.example.george.jsonaction;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Imagetext extends AppCompatActivity {
ImageView img;
    TextView des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagetext);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        img=(ImageView)findViewById(R.id.imageView);
        des=(TextView)findViewById(R.id.textView);
        RequestQueue queue= Volley.newRequestQueue(this);
        String url="http://192.168.43.235/php/image.php";
     StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
             new Response.Listener<String>() {
                 @Override
                 public void onResponse(String s) {
                     Toast.makeText(getApplicationContext(),"Response"+s,Toast.LENGTH_LONG).show();

                 }
             },
             new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError volleyError) {
                     Toast.makeText(getApplicationContext(),"Error:"+volleyError.toString(),Toast.LENGTH_LONG).show();

                 }
             }


     ){

     @Override
         protected Map<String, String> getParams()
     {
Map<String,String> params=new HashMap<>();
Bitmap image=((BitmapDrawable)img.getDrawable()).getBitmap();
         params.put("image", String.valueOf(image));
         params.put("description","Tiger");
         return params;
     }


     };
queue.add(stringRequest);

        }

    }
