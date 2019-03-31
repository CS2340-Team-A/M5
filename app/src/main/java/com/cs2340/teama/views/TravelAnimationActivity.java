package com.cs2340.teama.views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs2340.teama.m5.R;

public class TravelAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        ImageView img= findViewById(R.id.wait_image);
        img.setImageResource(R.drawable.launching_off);
        TextView text = findViewById(R.id.wait_text);
        text.setText("Preparing for launch off . . .");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.d("Edit","Simulating Travelling");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchPic1();
            }
        },2000);

        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                startPlanetActivity();
            }
        },5000);
    }

    private void switchPic1() {
        ImageView img= findViewById(R.id.wait_image);
        img.setImageResource(R.drawable.travelling_inspace);
        TextView text = findViewById(R.id.wait_text);
        text.setText("Travelling through space . . .");
    }

    private void startPlanetActivity() {
        Intent intent = new Intent(this, PlanetActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}
