package com.cs2340.teama.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.viewModels.MarketPlaceSellViewModel;

/**
 * View for the marketplace buy scree.
 *
 * TODO: Link TextViews to Planet List<TradeGood>.
 * TODO: Link Player's ship's cargohold and Player's money
 */
public class MarketPlaceSellActivity extends AppCompatActivity {

    private MarketPlaceSellViewModel viewModel;


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

    private TextView water_price;
    private TextView fur_price;
    private TextView ore_price;
    private TextView firearms_price;
    private TextView medicine_price;
    private TextView machine_price;
    private TextView narcotics_price;
    private TextView robots_price;
    private TextView games_price;
    private TextView food_price;

    private TextView money_text;
    private TextView cargo_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_place_activity_sell);

        viewModel = ViewModelProviders.of(this).get(MarketPlaceSellViewModel.class);

        Button sell_water_button = findViewById(R.id.water_button);
        Button sell_fur_button = findViewById(R.id.furs_button);
        Button sell_ore_button = findViewById(R.id.ore_button);
        Button sell_firearms_button = findViewById(R.id.firearms_button);
        Button sell_medicine_button = findViewById(R.id.medicine_button);
        sell_machines_button = findViewById(R.id.machines_button);
        sell_narcotics_button = findViewById(R.id.narcotics_button);
        sell_robots_button = findViewById(R.id.robots_button);
        sell_games_button = findViewById(R.id.game_button);
        sell_food_button = findViewById(R.id.food_button);

        water_text = findViewById(R.id.water_text);
        fur_text = findViewById(R.id.furs_text);
        ore_text = findViewById(R.id.ore_text);
        firearms_text = findViewById(R.id.firearms_text);
        medicine_text = findViewById(R.id.medicine_text);
        machine_text = findViewById(R.id.machines_text);
        narcotics_text = findViewById(R.id.narcotics_text);
        robots_text = findViewById(R.id.robots_text);
        games_text = findViewById(R.id.games_text);
        food_text = findViewById(R.id.food_text);

        water_price = findViewById(R.id.water_price);
        fur_price = findViewById(R.id.furs_price);
        ore_price = findViewById(R.id.ore_price);
        firearms_price = findViewById(R.id.firearms_price);
        medicine_price = findViewById(R.id.medicine_price);
        machine_price = findViewById(R.id.machines_price);
        narcotics_price = findViewById(R.id.narcotics_price);
        robots_price = findViewById(R.id.robots_price);
        games_price = findViewById(R.id.games_price);
        food_price = findViewById(R.id.food_price);

        money_text = findViewById(R.id.money_text);
        cargo_text = findViewById(R.id.cargo_text);

        sell_water_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell water button pressed");
                viewModel.sell(GoodType.WATER);
                water_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.WATER)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        sell_fur_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell fur button pressed");
                viewModel.sell(GoodType.FURS);
                fur_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.FURS)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        sell_ore_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell ore button pressed");
                viewModel.sell(GoodType.ORE);
                ore_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.ORE)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        sell_firearms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell ore button pressed");
                viewModel.sell(GoodType.FIREARMS);
                firearms_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.FIREARMS)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        sell_medicine_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell medicine button pressed");
                viewModel.sell(GoodType.MEDICINE);
                medicine_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.MEDICINE)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        sell_machines_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell machines button pressed");
                viewModel.sell(GoodType.MACHINES);
                machine_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.MACHINES)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        sell_narcotics_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell narcotics button pressed");
                viewModel.sell(GoodType.NARCOTICS);
                narcotics_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.NARCOTICS)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        sell_robots_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell robots button pressed");
                viewModel.sell(GoodType.ROBOTS);
                robots_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.ROBOTS)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        sell_games_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell games button pressed");
                viewModel.sell(GoodType.GAMES);
                games_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.GAMES)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        sell_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell food button pressed");
                viewModel.sell(GoodType.FOOD);
                food_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.FOOD)));
                money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
                cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());
            }
        });

        water_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.WATER)));
        fur_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.FURS)));
        ore_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.ORE)));
        firearms_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.FIREARMS)));
        medicine_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.MEDICINE)));
        machine_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.MACHINES)));
        narcotics_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.NARCOTICS)));
        robots_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.ROBOTS)));
        games_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.GAMES)));
        food_text.setText(Integer.toString(viewModel.getGoodVolume(GoodType.FOOD)));

        water_price.setText(Double.toString(viewModel.getGoodValue(GoodType.WATER)));
        fur_price.setText(Double.toString(viewModel.getGoodValue(GoodType.FURS)));
        ore_price.setText(Double.toString(viewModel.getGoodValue(GoodType.ORE)));
        firearms_price.setText(Double.toString(viewModel.getGoodValue(GoodType.FIREARMS)));
        medicine_price.setText(Double.toString(viewModel.getGoodValue(GoodType.MEDICINE)));
        machine_price.setText(Double.toString(viewModel.getGoodValue(GoodType.MACHINES)));
        narcotics_price.setText(Double.toString(viewModel.getGoodValue(GoodType.NARCOTICS)));
        robots_price.setText(Double.toString(viewModel.getGoodValue(GoodType.ROBOTS)));
        games_price.setText(Double.toString(viewModel.getGoodValue(GoodType.GAMES)));
        food_price.setText(Double.toString(viewModel.getGoodValue(GoodType.FOOD)));

        money_text.setText("Money: " + Integer.toString(viewModel.getPlayerCredits()));
        cargo_text.setText("Cargo Space: " + viewModel.getCargoSpace());

    }



}
