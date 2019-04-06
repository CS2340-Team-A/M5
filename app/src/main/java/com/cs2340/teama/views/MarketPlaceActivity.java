package com.cs2340.teama.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cs2340.teama.m5.R;

/**
 * Note that the ViewModel for this class is PlanetViewModel.
 */
public class MarketPlaceActivity extends AppCompatActivity implements OnClickListener {

    private Button buy_wat;
    private Button buy_fur;
    private Button buy_foo;
    private Button buy_or;
    private Button buy_game;
    private Button buy_firearm;
    private Button buy_meds;
    private Button buy_machine;
    private Button buy_narc;
    private Button buy_robot;


    private Button sell_wat;
    private Button sell_fur;
    private Button sell_foo;
    private Button sell_or;
    private Button sell_game;
    private Button sell_firearm;
    private Button sell_meds;
    private Button sell_machine;
    private Button sell_narc;
    private Button sell_robot;

    private EditText water;
    private EditText fur;
    private EditText food;
    private EditText ore;
    private EditText games;
    private EditText firearms;
    private EditText medicine;
    private EditText machines;
    private EditText narcotics;
    private EditText robots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_market_place);

        water = findViewById(R.id.waterText);
        water.addTextChangedListener(listen);

        fur = findViewById(R.id.fursText);
        fur.addTextChangedListener(listen);

        food = findViewById(R.id.foodText);
        food.addTextChangedListener(listen);

        ore = findViewById(R.id.oreText);
        ore.addTextChangedListener(listen);

        games = findViewById(R.id.gamesText);
        games.addTextChangedListener(listen);

        firearms = findViewById(R.id.firearmsText);
        firearms.addTextChangedListener(listen);

        machines = findViewById(R.id.machinesText);
        machines.addTextChangedListener(listen);

        medicine = findViewById(R.id.medicineText);
        medicine.addTextChangedListener(listen);

        narcotics = findViewById(R.id.narcoticsText);
        narcotics.addTextChangedListener(listen);

        robots = findViewById(R.id.robotsText);
        robots.addTextChangedListener(listen);

        buy_wat = findViewById(R.id.buy_water);
        buy_fur = findViewById(R.id.buy_furs);
        buy_foo = findViewById(R.id.buy_food);
        buy_or = findViewById(R.id.buy_ore);
        buy_game = findViewById(R.id.buy_games);
        buy_firearm = findViewById(R.id.buy_firearms);
        buy_meds = findViewById(R.id.buy_medicine);
        buy_machine = findViewById(R.id.buy_machines);
        buy_narc = findViewById(R.id.buy_narcotics);
        buy_robot = findViewById(R.id.buy_robots);

        sell_wat = findViewById(R.id.sell_water);
        sell_fur = findViewById(R.id.sell_furs);
        sell_foo = findViewById(R.id.sell_food);
        sell_or = findViewById(R.id.sell_ore);
        sell_game = findViewById(R.id.sell_games);
        sell_firearm = findViewById(R.id.sell_firearms);
        sell_meds = findViewById(R.id.sell_medicine);
        sell_machine = findViewById(R.id.sell_machines);
        sell_narc = findViewById(R.id.sell_narcotics);
        sell_robot = findViewById(R.id.sell_robots);

        buy_wat.setOnClickListener(this);
        buy_fur.setOnClickListener(this);
        buy_foo.setOnClickListener(this);
        buy_or.setOnClickListener(this);
        buy_game.setOnClickListener(this);
        buy_firearm.setOnClickListener(this);
        buy_meds.setOnClickListener(this);
        buy_machine.setOnClickListener(this);
        buy_narc.setOnClickListener(this);
        buy_robot.setOnClickListener(this);

        sell_wat.setOnClickListener(this);
        sell_fur.setOnClickListener(this);
        sell_foo.setOnClickListener(this);
        sell_or.setOnClickListener(this);
        sell_game.setOnClickListener(this);
        sell_firearm.setOnClickListener(this);
        sell_meds.setOnClickListener(this);
        sell_machine.setOnClickListener(this);
        sell_narc.setOnClickListener(this);
        sell_robot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy_water:
                Toast.makeText(this, "Buy Water button Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.buy_furs:
                // Code for button 2 click
                break;

            case R.id.buy_food:
                // Code for button 3 click
                break;
            case R.id.buy_ore:
                // Code for button 3 click
                break;
            case R.id.buy_games:
                // Code for button 3 click
                break;
            case R.id.buy_firearms:
                // Code for button 3 click
                break;
            case R.id.buy_medicine:
                // Code for button 3 click
                break;
            case R.id.buy_machines:
                // Code for button 3 click
                break;
            case R.id.buy_narcotics:
                // Code for button 3 click
                break;
            case R.id.buy_robots:
                // Code for button 3 click
                break;
            case R.id.sell_water:
                // Code for button 3 click
                break;
            case R.id.sell_furs:
                // Code for button 3 click
                break;
            case R.id.sell_food:
                // Code for button 3 click
                break;
            case R.id.sell_ore:
                // Code for button 3 click
                break;
            case R.id.sell_games:
                // Code for button 3 click
                break;
            case R.id.sell_firearms:
                // Code for button 3 click
                break;
            case R.id.sell_medicine:
                // Code for button 3 click
                break;
            case R.id.sell_machines:
                // Code for button 3 click
                break;
            case R.id.sell_narcotics:
                // Code for button 3 click
                break;
            case R.id.sell_robots:
                // Code for button 3 click
                break;
        }
    }
    private final TextWatcher listen = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String waterInput = water.getText().toString();
            String fursInput = fur.getText().toString();
            String foodInput = food.getText().toString();
            String oreInput = ore.getText().toString();
            String gamesInput = games.getText().toString();
            String firearmsInput = firearms.getText().toString();
            String medicineInput = medicine.getText().toString();
            String machinesInput = machines.getText().toString();
            String narcoticsInput = narcotics.getText().toString();
            String robotsInput = robots.getText().toString();


            buy_wat.setEnabled(!waterInput.isEmpty());
            sell_wat.setEnabled(!waterInput.isEmpty());

            buy_fur.setEnabled(!fursInput.isEmpty());
            sell_fur.setEnabled(!fursInput.isEmpty());

            buy_foo.setEnabled(!foodInput.isEmpty());
            sell_foo.setEnabled(!foodInput.isEmpty());

            buy_or.setEnabled(!oreInput.isEmpty());
            sell_or.setEnabled(!oreInput.isEmpty());

            buy_game.setEnabled(!gamesInput.isEmpty());
            sell_game.setEnabled(!gamesInput.isEmpty());

            buy_firearm.setEnabled(!firearmsInput.isEmpty());
            sell_firearm.setEnabled(!firearmsInput.isEmpty());

            buy_meds.setEnabled(!medicineInput.isEmpty());
            sell_meds.setEnabled(!medicineInput.isEmpty());

            buy_machine.setEnabled(!machinesInput.isEmpty());
            sell_machine.setEnabled(!machinesInput.isEmpty());

            buy_narc.setEnabled(!narcoticsInput.isEmpty());
            sell_narc.setEnabled(!narcoticsInput.isEmpty());

            buy_robot.setEnabled(!robotsInput.isEmpty());
            sell_robot.setEnabled(!robotsInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}




