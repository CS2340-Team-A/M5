package com.cs2340.teama.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cs2340.teama.m5.R;

/**
 * View for the market welcome screen. All features have been implemented.
 */
public class MarketPlaceWelcomeActivity extends AppCompatActivity {

    private Button buy_button;
    private Button sell_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_place_activity_welcome);

        buy_button = findViewById(R.id.buy_button);
        sell_button = findViewById(R.id.sell_button);

        buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMarketPlaceBuyActivity();
            }
        });

        sell_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMarketPlaceSellActivity();
            }
        });
    }

    public void openMarketPlaceBuyActivity() {
        Intent intent = new Intent(this, MarketPlaceBuyActivity.class);
        startActivity(intent);
    }

    public void openMarketPlaceSellActivity() {
        Intent intent = new Intent(this, MarketPlaceSellActivity.class);
        startActivity(intent);
    }


}
