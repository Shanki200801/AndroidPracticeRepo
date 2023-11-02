package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivity.this,"onCreate Invoked", Toast.LENGTH_SHORT).show();
        Log.d("Activity update","onCreate invoked");
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button login_btn = findViewById(R.id.login_btn);
        Button explicit_intent_btn = findViewById(R.id.expIntBtn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_content = email.getText().toString();
                String pw_content = password.getText().toString();
                if(email_content.equals("dev@gmail.com") && pw_content.equals("12345")){
                    Log.d("Success","Entered details are correct");
                    Intent dashboardIntent = new Intent(MainActivity.this, Dashboard.class);
                    startActivity(dashboardIntent);
                }
                else{
                    Log.d("Fail","Entered details are incorrect");
                }
            }
        }
        );
        explicit_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("www.facebook.com"));
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "onResume Invoked", Toast.LENGTH_SHORT).show();
        Log.d("Activity update","onResume invoked");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop Invoked", Toast.LENGTH_SHORT).show();
        Log.d("Activity update","onStop invoked");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"onDestroy invoked",Toast.LENGTH_SHORT).show();
        Log.d("Activity update","onDestroy invoked");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this,"on Restart invoked", Toast.LENGTH_SHORT).show();
        Log.d("Activity update","onRestart invoked");

    }
}