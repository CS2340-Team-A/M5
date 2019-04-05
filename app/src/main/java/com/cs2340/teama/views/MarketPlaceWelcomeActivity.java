package com.cs2340.teama.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * View for the market welcome screen. All features have been implemented.
 */
public class MarketPlaceWelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_place_activity_welcome);

        Button buy_button = findViewById(R.id.buy_button);
        Button sell_button = findViewById(R.id.sell_button);

        buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Buy button pressed");
                openMarketPlaceBuyActivity();
            }
        });

        sell_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit", "Sell button pressed");
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
