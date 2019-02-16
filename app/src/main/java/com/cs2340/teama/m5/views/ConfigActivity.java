package com.cs2340.teama.m5.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cs2340.teama.m5.R;
import com.cs2340.teama.m5.models.GameDifficulty;

public class ConfigActivity extends AppCompatActivity {


    private Spinner difficultySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        /*
        Grabbing the widgets
         */
        difficultySpinner = findViewById(R.id.difficulty_spinner);

        /*
        Set up the spinner
         */

        ArrayAdapter<String> difficulty_adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        difficulty_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficulty_adapter);


    }
}
