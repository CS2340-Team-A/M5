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

public class PlanetActivity extends AppCompatActivity {

    private PlanetViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        viewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);


        TextView planetName = (TextView) findViewById(R.id.planet_name);
        planetName.setText(viewModel.getPlanetName());

        TextView planetInfo = findViewById(R.id.planet_info);
        planetInfo.setText(viewModel.getPlanetInfo());

        Button goToMarket = findViewById(R.id.planet_trade);

        goToMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "goToMarket Button Pushed");
                startMarket();
            }
        });

    }

    private void startMarket() {
        Intent intent = new Intent(this, MarketPlaceActivity.class);
        this.startActivity(intent);
    }


}
