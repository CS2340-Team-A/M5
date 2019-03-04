package com.cs2340.teama.m5.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cs2340.teama.m5.viewModels.PlanetViewModel;

public class PlanetActivity extends AppCompatActivity {

    private PlanetViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        viewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView planetName = (TextView) findViewById(R.id.planet_name);
        planetName.setText(viewModel.getPlanetName());

        TextView planetInfo = findViewById(R.id.planet_info);
        planetInfo.setText(viewModel.getPlanetInfo());

    }

}
