package com.example.george.jsonaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by george on 12/12/2017.
 */
public class Customadapter extends BaseAdapter {
    Context applicationContext;
    ArrayList<String> s;
    ArrayList<String> s1;
    ArrayList<String> s2;
    public Customadapter(Context applicationContext, ArrayList<String> s,ArrayList<String> s1,ArrayList<String> s2) {
        this.applicationContext=applicationContext;
        this.s=s;
        this.s1=s1;
        this.s2=s2;
    }

    @Override
    public int getCount() {
        return s.size();
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
    public View getView( final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)applicationContext.getSystemService(applicationContext.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.listitem,parent,false);
        TextView id=(TextView)view.findViewById(R.id.textView4);
        TextView name=(TextView)view.findViewById(R.id.textView5);
        TextView sal=(TextView)view.findViewById(R.id.textView6);
        id.setText(s.get(position));
        name.setText(s1.get(position));
        sal.setText(s2.get(position));
        return view;
    }
}
