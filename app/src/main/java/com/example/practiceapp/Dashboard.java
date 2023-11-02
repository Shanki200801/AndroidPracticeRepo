package com.example.practiceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
        add.setOnClickListener(this::onClick);


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
