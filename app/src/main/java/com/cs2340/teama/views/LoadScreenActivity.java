package com.cs2340.teama.views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cs2340.teama.m5.R;

public class LoadScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.d("Edit","Simulating Wait");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startPlanetActivity();
            }
        },2000);



    }

    private void startPlanetActivity() {
        Intent intent = new Intent(this, PlanetActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}
