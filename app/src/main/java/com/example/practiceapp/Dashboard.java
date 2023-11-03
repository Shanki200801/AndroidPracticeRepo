package com.example.practiceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{
    Context context = this;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        sharedPreferences = context.getSharedPreferences("demo_preference",Context.MODE_PRIVATE);
        editor =  sharedPreferences.edit();
        Button add = findViewById(R.id.addbtn);
        Button del = findViewById(R.id.delbtn);
        PlayerView playerView = findViewById(R.id.media_player);
        add.setOnClickListener(this::onClick);
        ExoPlayer player = new ExoPlayer.Builder(context).build();
        playerView.setPlayer(player);

//        MediaItem mediaItem = MediaItem.fromUri(Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));
       // MediaItem mediaItem = MediaItem.fromUri(Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse("http://commondatastorage.googleapis.com/codeskulptor-demos/DDR_assets/Kangaroo_MusiQue_-_The_Neverwritten_Role_Playing_Game.mp3"));

        player.setMediaItem(mediaItem);

        player.prepare();

        player.play();



    }
    @Override
    public void onClick(View view){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(view.getId()==R.id.addbtn){

            editor.putString("name1","shashank");
            editor.putString("name2","Raghav");
            editor.apply();
        }
        else if(view.getId()==R.id.delbtn){
//            editor.clear();
            editor.remove("name1");

        }
        Log.d("shared pref",sharedPreferences.getString("name1","default name"));
    }
}
