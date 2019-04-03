package com.cs2340.teama.views;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cs2340.teama.m5.R;

public class BeginGameActivity extends AppCompatActivity {
    private Button BeginGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_game);

        BeginGame = findViewById(R.id.begin_button);
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
