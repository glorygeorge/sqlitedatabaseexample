package com.example.george.jsonaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by george on 12/13/2017.
 */
public class Ownadapter extends BaseAdapter {
    TextView nametext,agetext,nationalitytext,mobiletext;
    Context applicationContext;
    ArrayList<String> na;
    ArrayList<String> ag;
    ArrayList<String> nat;
    ArrayList<String> mo;
    public Ownadapter(Context applicationContext, ArrayList<String> na, ArrayList<String> ag, ArrayList<String> nat, ArrayList<String> mo) {
  this.applicationContext=applicationContext;
   this.na=na;
        this.ag=ag;
        this.nat=nat;
        this.mo=mo;



    }

    @Override
    public int getCount() {
        return na.size() ;
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
        View view=inflater.inflate(R.layout.list_item,parent,false);
        nametext=(TextView)view.findViewById(R.id.na);
        agetext=(TextView)view.findViewById(R.id.ag);
       nationalitytext=(TextView)view.findViewById(R.id.nat);
       mobiletext=(TextView)view.findViewById(R.id.mo);
        nametext.setText(na.get(position));
        agetext.setText(ag.get(position));
        nationalitytext.setText(nat.get(position));
        mobiletext.setText(mo.get(position));
        return view ;
    }
}
