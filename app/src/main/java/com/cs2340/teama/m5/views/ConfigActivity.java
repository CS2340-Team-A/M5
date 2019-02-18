package com.cs2340.teama.m5.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cs2340.teama.m5.R;
import com.cs2340.teama.m5.models.GameDifficulty;
import com.cs2340.teama.m5.models.Player;
import com.cs2340.teama.m5.models.SkillType;
import com.cs2340.teama.m5.viewModels.ConfigViewModel;

public class ConfigActivity extends AppCompatActivity {

    private final int SKILL_POINTS = 16;

    private ConfigViewModel viewModel;

    private Player player;

    /*
    The widgets
     */
    private Spinner difficultySpinner;
    private Button beginButton;
    private EditText nameField;
    private EditText trader;
    private EditText fighter;
    private EditText engineer;
    private EditText pilot;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        /*
        Grabbing the widgets
         */
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        nameField = findViewById(R.id.name_input);
        trader = findViewById(R.id.trader_number);
        fighter = findViewById(R.id.fighter_number);
        engineer = findViewById(R.id.engineer_number);
        pilot = findViewById(R.id.pilot_number);
        start = findViewById(R.id.begin_game_button);

        /*
        Set up the spinner
         */

        ArrayAdapter<String> difficulty_adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        difficulty_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficulty_adapter);


    }

    /**
     * Button handler for the begin game button
     */
    public void onBeginPressed(View view) {
        Log.d("Edit", "Intializing Game");
        int traderPoints = Integer.parseInt(trader.getText().toString());
        int fighterPoints = Integer.parseInt(fighter.getText().toString());
        int pilotPoints = Integer.parseInt(pilot.getText().toString());
        int engineerPoints = Integer.parseInt(engineer.getText().toString());
         if (traderPoints + fighterPoints + pilotPoints + engineerPoints == SKILL_POINTS) {
            SkillType.PILOT.incrementSkillPointBy(pilotPoints);
            SkillType.TRADER.incrementSkillPointBy(traderPoints);
            SkillType.FIGHTER.incrementSkillPointBy(fighterPoints);
            SkillType.ENGINEER.incrementSkillPointBy(engineerPoints);

             player = new Player(nameField.getText().toString());
             Log.d("Edit", "Player created");
         } else {
             Toast.makeText(this, "You have not properly allocated your skill points",
                     Toast.LENGTH_LONG).show();
         }


    }
}
