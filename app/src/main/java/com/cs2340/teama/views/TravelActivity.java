package com.cs2340.teama.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.cs2340.teama.m5.R;
import com.cs2340.teama.models.Ship;
import com.cs2340.teama.viewModels.TravelViewModel;

public class TravelActivity extends AppCompatActivity {

    private Button travel_button;
    private Button backButton;
    private Spinner planet_spinner;
    private CardView planet_info_cardView;
    private TextView planetInfoContent;
    private ProgressBar fuelBar;

    private TravelViewModel viewModel;

    private Ship ship;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel);
        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);

        travel_button = findViewById(R.id.travel_button);
        backButton = findViewById(R.id.back_from_travel);
        planet_spinner = findViewById(R.id.travel_spinner);
        planet_info_cardView = findViewById(R.id.planet_info_cardView);

        final ArrayAdapter<String> planet_adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item, viewModel.getPlanetNameList());
        planet_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planet_spinner.setAdapter(planet_adapter);

        planetInfoContent = findViewById(R.id.travel_planet_info_content);
        setPlanetInfoContentText();

        planet_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parView, View selV, int pos, long id) {
                setPlanetInfoContentText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                //Do Nothing
            }
        });

        ship = viewModel.getShip();

        fuelBar = findViewById(R.id.fuel_bar);
        fuelBar.setMax(100);
        fuelBar.setProgress((int) (ship.getFuel()*100/ship.getFuelCapacity()), true);

        travel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Travel Button Pressed. Traveling to "
                        + planet_spinner.getSelectedItem());
                doTravel((int) planet_spinner.getSelectedItemPosition());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Back Button Pressed");
                goBack();
            }
        });
    }

    private void doTravel(int planetPos) {
        viewModel.travelTo(planetPos);
        Intent intent = new Intent(this, TravelAnimationActivity.class);
        this.startActivity(intent);
    }

    private void goBack() {
        Intent intent = new Intent(this, PlanetActivity.class);
        this.startActivity(intent);
    }

    private void setPlanetInfoContentText() {
        CharSequence txt = "Current " + viewModel.getPlanetInfo() + "\n";
        txt = txt + "\nSelected " + viewModel.getPlanetList().get((int)
                planet_spinner.getSelectedItemPosition()).getInfo();
        planetInfoContent.setText(txt);
    }

}
