package com.cs2340.teama.views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.d("Edit","Simulating Wait");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchPic1();
            }
        },2000);
//        handler.removeCallbacks(new Runnable() {
//            @Override
//            public void run() {
//                switchPic1();
//            }
//        });

        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchPic2();
            }
        },4000);

        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                startPlanetActivity();
            }
        },6000);
    }

    private void switchPic1() {
        ImageView img= findViewById(R.id.wait_image);
        img.setImageResource(R.drawable.moon_base_picture);
        TextView text = findViewById(R.id.wait_text);
        text.setText("Building moon base . . .");
    }

    private void switchPic2() {
        ImageView img= findViewById(R.id.wait_image);
        img.setImageResource(R.drawable.space_driver);
        TextView text = findViewById(R.id.wait_text);
        text.setText("Fueling extraterrestrial car . . .");
    }

    private void startPlanetActivity() {
        Intent intent = new Intent(this, PlanetActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}
