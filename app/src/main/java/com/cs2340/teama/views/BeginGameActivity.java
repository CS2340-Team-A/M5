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

import com.cs2340.teama.m5.R;
import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Universe;
import com.cs2340.teama.models.enums.GameDifficulty;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.enums.SkillType;
import com.cs2340.teama.viewModels.ConfigViewModel;

public class BeginGameActivity extends AppCompatActivity {
    private Button BeginGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_game);

        BeginGame = (Button) findViewById(R.id.BeginGameButton);
        BeginGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfigActivity();
            }
        });
    }
    public void openConfigActivity() {
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }
}
