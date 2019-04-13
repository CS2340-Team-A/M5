package com.cs2340.teama.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.cs2340.teama.m5.R;

import com.cs2340.teama.viewModels.TravelAnimationViewModel;

public class TravelAnimationActivity extends AppCompatActivity {


    private TravelAnimationViewModel viewModel;
    private static final int DELAY_DURATION = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.space_travel);
        viewModel = ViewModelProviders.of(this).get(TravelAnimationViewModel.class);
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
        },DELAY_DURATION);

        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchPic2();
            }
        },DELAY_DURATION * 2);

        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                startPlanetActivity();
            }
        },DELAY_DURATION * 3);
    }

    private void switchPic1() {
        RelativeLayout layout = findViewById(R.id.space_travel_1);
        layout.setBackgroundResource(R.drawable.space_travel_2);
    }

    private void switchPic2() {
        RelativeLayout layout = findViewById(R.id.space_travel_1);
        layout.setBackgroundResource(R.drawable.space_travel);
    }

    private void startPlanetActivity() {
        if (viewModel.pirateAttack()) {
            Log.d("Edit", "Pirate Attack");
            Intent intent = new Intent(this, PirateAttackActivity.class);
            this.startActivity(intent);
            this.finish();
        } else {
            Intent intent = new Intent(this, PlanetActivity.class);
            this.startActivity(intent);
            this.finish();
        }
    }
}
