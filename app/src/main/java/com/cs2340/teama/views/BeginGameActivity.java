package com.cs2340.teama.views;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cs2340.teama.m5.R;

import com.cs2340.teama.models.Game;

import io.realm.Realm;

public class BeginGameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_game);

        Button beginGame = findViewById(R.id.begin_button);
        beginGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfigActivity();
            }
        });

        Button continueButton = findViewById(R.id.continue_button);
        if (Game.game == null) {
            continueButton.setVisibility(View.INVISIBLE);
        }
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoadingActivity();
            }
        });

    }

    public void openLoadingActivity() {
        Intent intent = new Intent(this, LoadScreenActivity.class);
        startActivity(intent);
    }

    public void openConfigActivity() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);

    }
}
