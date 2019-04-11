package com.cs2340.teama.views;

import android.content.Intent;
import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.cs2340.teama.m5.R;

import com.cs2340.teama.viewModels.PirateAttackViewModel;

public class PirateAttackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pirate_attack);

        Button continue_button = findViewById(R.id.continue_button);
        PirateAttackViewModel viewModel = ViewModelProviders.of(this)
                .get(PirateAttackViewModel.class);

        viewModel.pillage();

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Continue Button Pressed.");
                loadContinue();
            }
        });
    }

    private void loadContinue() {
        Intent intent = new Intent(this, PlanetActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}
