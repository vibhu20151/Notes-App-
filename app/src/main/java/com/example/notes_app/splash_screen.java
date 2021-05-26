package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
        public void run() {
            // This method will be executed once the timer is over
            Intent i = new Intent(splash_screen.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    },2000);
    }
}
