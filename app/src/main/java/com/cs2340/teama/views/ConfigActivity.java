package com.cs2340.teama.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Universe;
import com.cs2340.teama.models.enums.GameDifficulty;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.enums.SkillType;
import com.cs2340.teama.viewModels.ConfigViewModel;

import com.cs2340.teama.R;

public class ConfigActivity extends AppCompatActivity {

    private Spinner difficultySpinner;
    private EditText fighter;
    private EditText pilot;
    private EditText trader;
    private EditText engineer;
    private EditText nameGiven;
    private ConfigViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        viewModel = ViewModelProviders.of(this).get(ConfigViewModel.class);

        /*
        Grabbing the widgets
         */
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        fighter = findViewById(R.id.pilot_number);
        pilot = findViewById(R.id.fighter_number);
        trader = findViewById(R.id.trader_number);
        engineer = findViewById(R.id.editText5);
        Button startGame = findViewById(R.id.begin_game_button);
        nameGiven = findViewById(R.id.medicineText);

        /*
        Set up the spinner
         */

        ArrayAdapter<String> difficulty_adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        difficulty_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficulty_adapter);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Add Player Pressed");
                try {
                    int pil = Integer.parseInt(pilot.getText().toString());
                    int fight = Integer.parseInt(fighter.getText().toString());
                    int trad = Integer.parseInt(trader.getText().toString());
                    int engin = Integer.parseInt(engineer.getText().toString());
                    Log.d("Edit", pil + " " + fight + " " + trad + " " + engin);

                    if (viewModel.calculatePoints(pil, fight, trad, engin)) {
                        Log.d("Edit", "" + viewModel.calculatePoints(pil, fight, trad, engin));
                        showToast();
                        pilot.invalidate();
                        fighter.invalidate();
                        trader.invalidate();
                        engineer.invalidate();

                    } else {
                        Log.d("Edit", "" + viewModel.calculatePoints(pil, fight, trad, engin));
                        // Create Universe
                        /* Note all of this Universe Creation should probably take place in the
                         viewModel or models*/
                        Universe universe = new Universe();
                        Log.d("Edit", "Created Universe: \n" + universe);

                        GameDifficulty diff = (GameDifficulty) difficultySpinner.getSelectedItem();

                        if (nameGiven.getText().toString().length() == 0) {
                            throw new IllegalArgumentException();
                        }

                        Coordinates startingCoords = universe.getSolarSystems().get(0).getCoordinates();

                        Player player = new Player(nameGiven.getText().toString(), startingCoords);

                        player.incrementSkill(SkillType.FIGHTER, fight);
                        player.incrementSkill(SkillType.ENGINEER, engin);
                        player.incrementSkill(SkillType.TRADER, trad);
                        player.incrementSkill(SkillType.PILOT, pil);


                        Log.d("Edit", "Got new player" + player);





                        viewModel.addPlayerUniverse(player, universe);
                        openBlankActivity();

                    }
                } catch (IllegalArgumentException e){
                    showNameToast();
                } catch (Exception e) {
                    showToast();
                    pilot.invalidate();
                    fighter.invalidate();
                    trader.invalidate();
                    engineer.invalidate();
                }

            }
        });
    }

    public void openBlankActivity() {
        Intent intent = new Intent(this, LoadScreenActivity.class);
        startActivity(intent);
    }
    public void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }

    public void showNameToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout_name, (ViewGroup) findViewById(R.id.toast_root_name));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }

}
