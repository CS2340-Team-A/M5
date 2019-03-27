package com.cs2340.teama.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.teama.m5.R;
import com.cs2340.teama.viewModels.PlanetViewModel;
import com.cs2340.teama.views.TravelActivity;

public class PlanetActivity extends AppCompatActivity {

    private PlanetViewModel viewModel;
    private Button travel;
    private Button market;
    private Button goToMarket;
    private Button goTravel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet);
        viewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);


        TextView planetName = findViewById(R.id.planet_name);
        planetName.setText(viewModel.getPlanetName());

        TextView planetInfo = findViewById(R.id.planet_info);
        planetInfo.setText(viewModel.getPlanetInfo());

        goToMarket = findViewById(R.id.market_button);
        travel = findViewById(R.id.travel_button);

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
