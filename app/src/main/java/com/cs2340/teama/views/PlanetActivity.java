package com.cs2340.teama.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.teama.viewModels.PlanetViewModel;
import com.cs2340.teama.m5.R;

public class PlanetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet);
        PlanetViewModel viewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);


        TextView planetName = findViewById(R.id.planet_name);
        planetName.setText(viewModel.getPlanetName());

        TextView planetInfo = findViewById(R.id.planet_info);
        planetInfo.setText("Current " +  viewModel.getPlanetInfo());

        Button goToMarket = findViewById(R.id.market_button);
        Button travel = findViewById(R.id.travel_button);

        goToMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMarketActivity();
            }
        });
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTravelActivity();
            }
        });


    }

    private void openMarketActivity() {
        Intent intent = new Intent(this, MarketPlaceWelcomeActivity.class);
        this.startActivity(intent);
    }

    private void openTravelActivity() {
        Intent intent = new Intent(this, TravelActivity.class);
        this.startActivity(intent);
    }

}
