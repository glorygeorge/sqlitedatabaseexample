package com.example.george.savedata;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by george on 10/11/2017.
 */
public class Displayadapter extends BaseAdapter {
    ArrayList<String> userId;
    ArrayList<String>name;
    ArrayList<String> age;
    Context applicationContext;
    public Displayadapter(Context applicationContext, ArrayList<String> userId, ArrayList<String> name, ArrayList<String> age) {
        this.age=age;
        this.name=name;
        this.userId=userId;
        this.applicationContext=applicationContext;

    }


    @Override
    public int getCount() {
        return userId.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater .inflate(R.layout.cardview,parent, false);
        TextView t1=(TextView)view.findViewById(R.id.textView);
        TextView t2=(TextView)view.findViewById(R.id.textView2);
t1.setText(name.get(position));
        t2.setText(age.get(position));

        return view;
    }

}
