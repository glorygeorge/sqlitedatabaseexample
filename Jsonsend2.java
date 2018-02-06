package com.example.george.jsonaction;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Jsonsend2 extends AppCompatActivity {
    Button go;
    EditText name,age,city;
    String nm;
    String ag;
    String cy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonsend2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        go=(Button)findViewById(R.id.button);
        name=(EditText)findViewById(R.id.editText);
        age=(EditText)findViewById(R.id.editText2);
        city=(EditText)findViewById(R.id.editText3);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm=name.getText().toString();
                ag=age.getText().toString();
                cy=city.getText().toString();
                RequestQueue queue= Volley.newRequestQueue(Jsonsend2.this);
                String url="http://192.168.1.3/php/JsonDataOnly.php";
                HashMap request = new HashMap();


                StringRequest putRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Toast.makeText(getApplicationContext(),"Response"+response,Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Log.d("Error.Response", error.toString());
                            }
                        }
                ) {
                    @Override
                    public Map<String, String> getParams(){
                        Map<String, String> req = new HashMap<String, String>();
                        HashMap param = new HashMap();
                        param.put("name",nm);
                        param.put("age",ag);
                        param.put("city",cy);
                        req.put("request",new JSONObject(param).toString());

                        return req;

                    }
                };
                ;
                queue.add(putRequest);

            }
        });


    }

}
