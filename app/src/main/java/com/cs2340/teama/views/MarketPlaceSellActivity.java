package com.cs2340.teama.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.teama.m5.R;

/**
 * View for the marketplace buy scree.
 *
 * TODO: Link TextViews to Planet List<TradeGood>.
 * TODO: Link Player's ship's cargohold and Player's money
 */
public class MarketPlaceSellActivity extends AppCompatActivity {
    private Button sell_water_button;
    private Button sell_fur_button;
    private Button sell_ore_button;
    private Button sell_firearms_button;
    private Button sell_medicine_button;
    private Button sell_machines_button;
    private Button sell_narcotics_button;
    private Button sell_robots_button;
    private Button sell_games_button;
    private Button sell_food_button;

    private TextView water_text;
    private TextView fur_text;
    private TextView ore_text;
    private TextView firearms_text;
    private TextView medicine_text;
    private TextView machine_text;
    private TextView narcotics_text;
    private TextView robots_text;
    private TextView games_text;
    private TextView food_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_place_activity_sell);

        sell_water_button = findViewById(R.id.water_button);
        sell_fur_button = findViewById(R.id.furs_button);
        sell_ore_button = findViewById(R.id.ore_button);
        sell_firearms_button = findViewById(R.id.firearms_button);
        sell_medicine_button = findViewById(R.id.medicine_button);
        sell_machines_button = findViewById(R.id.machines_button);
        sell_narcotics_button = findViewById(R.id.narcotics_button);
        sell_robots_button = findViewById(R.id.robots_button);
        sell_games_button = findViewById(R.id.game_button);
        sell_food_button = findViewById(R.id.food_button);

        sell_water_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        sell_fur_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        sell_ore_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        sell_firearms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        sell_medicine_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        sell_machines_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        sell_narcotics_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        sell_robots_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        sell_games_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        sell_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });


    }



}
