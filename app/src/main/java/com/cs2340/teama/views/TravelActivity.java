package com.cs2340.teama.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.cs2340.teama.m5.R;
import com.cs2340.teama.models.enums.GameDifficulty;
import com.cs2340.teama.viewModels.ConfigViewModel;
import com.cs2340.teama.viewModels.TravelViewModel;

public class TravelActivity extends AppCompatActivity {

    private Button travel_button;
    private Spinner planet_spinner;
    private CardView planet_info_cardView;

    private TravelViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel);
        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);

        travel_button = findViewById(R.id.travel_button);
        planet_spinner = findViewById(R.id.travel_spinner);
        planet_info_cardView = findViewById(R.id.planet_info_cardView);

        ArrayAdapter<String> difficulty_adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item, viewModel.getPlanetList());
        difficulty_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planet_spinner.setAdapter(difficulty_adapter);

        travel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Travel Button Pressed");
            }
        });
    }

}
