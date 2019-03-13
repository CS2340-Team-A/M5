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
public class MarketPlaceBuyActivity extends AppCompatActivity {
    private Button buy_water_button;
    private Button buy_fur_button;
    private Button buy_ore_button;
    private Button buy_firearms_button;
    private Button buy_medicine_button;
    private Button buy_machines_button;
    private Button buy_narcotics_button;
    private Button buy_robots_button;
    private Button buy_games_button;
    private Button buy_food_button;

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
        setContentView(R.layout.market_place_activity_buy);

        buy_water_button = findViewById(R.id.water_button);
        buy_fur_button = findViewById(R.id.furs_button);
        buy_ore_button = findViewById(R.id.ore_button);
        buy_firearms_button = findViewById(R.id.firearms_button);
        buy_medicine_button = findViewById(R.id.medicine_button);
        buy_machines_button = findViewById(R.id.machines_button);
        buy_narcotics_button = findViewById(R.id.narcotics_button);
        buy_robots_button = findViewById(R.id.robots_button);
        buy_games_button = findViewById(R.id.game_button);
        buy_food_button = findViewById(R.id.food_button);

        buy_water_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        buy_fur_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        buy_ore_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        buy_firearms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        buy_medicine_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        buy_machines_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        buy_narcotics_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        buy_robots_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        buy_games_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        buy_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }
}
