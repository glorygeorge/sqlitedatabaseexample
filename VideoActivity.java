package com.example.george.eduvideo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.github.rtoshiro.view.video.FullscreenVideoLayout;

import java.io.IOException;

public class VideoActivity extends AppCompatActivity {
VideoView videoView;
    String file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView=(VideoView)findViewById(R.id.simpleVideoView);
        file=getIntent().getStringExtra("url");

        playvideo();

    }

    private void playvideo() {
        MediaController mediaController = new MediaController(this);
     videoView.setMediaController(mediaController);

        Uri uri=Uri.parse(file);
        videoView.setVideoURI(uri);
        videoView.start();

    }

}



