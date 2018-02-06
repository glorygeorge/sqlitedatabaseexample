package com.example.george.eduvideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import java.util.ArrayList;


/**
 * Created by george on 1/29/2018.
 */
public class CustomAdapter1 extends BaseAdapter {
    Context applicationContext;
    ArrayList<String> namearray;
    ArrayList<String> patharray;
    ArrayList<String> typearray;
    ArrayList<String> idarray;
    int ima[]={R.drawable.play4,R.drawable.play2,R.drawable.play3};
    public CustomAdapter1(Context applicationContext, ArrayList<String> idarray, ArrayList<String> namearray, ArrayList<String> patharray, ArrayList<String> typearray) {
        this.applicationContext = applicationContext;
        this.namearray = namearray;
        this.patharray = patharray;
        this.typearray = typearray;
        this.idarray = idarray;
    }

    @Override
    public int getCount() {
        return idarray.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listdesign,parent,false);
        final TextView nametext,typetext;
        ImageView thumnail;
        //final ImageView thumnail;
       thumnail=(ImageView)row.findViewById(R.id.thumnail);
//        final VideoView videoview;
//        videoview = (VideoView)view.findViewById(R.id.videoView);
        nametext = (TextView)row.findViewById(R.id.textView3);
        typetext = (TextView)row.findViewById(R.id.textView4);
        nametext.setText(namearray.get(position));
        typetext.setText(typearray.get(position));
        thumnail.setImageResource(ima[position]);

//        Bitmap bmThumbnail;
//        bmThumbnail = ThumbnailUtils.createVideoThumbnail(patharray.get(position), MediaStore.Images.Thumbnails.MICRO_KIND);
//        thumnail.setImageBitmap(bmThumbnail);








        return row;
        //MediaController mediacontroller = new MediaController(applicationContext);
//        mediacontroller.setAnchorView(videoview);
//        Uri video = Uri.parse(patharray.get(position));
//        videoview.setMediaController(mediacontroller);
//
//        ViewGroup.LayoutParams params=videoview.getLayoutParams();
//        params.height=150;
//     videoview.setLayoutParams(params);
//
//        videoview.setVideoURI(video);
//        videoview.requestFocus();
//        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            public void onPrepared(MediaPlayer mp) {
//                videoview.start();
//            }
//        });
//        Uri videouri=Uri.parse(patharray.get(position).toString());
//        videoview.setVideoURI(videouri);
//        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);
//                videoview.start();
//            }
//        });


    }
}
