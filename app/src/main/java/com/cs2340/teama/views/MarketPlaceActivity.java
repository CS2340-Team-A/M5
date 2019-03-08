package com.cs2340.teama.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cs2340.teama.m5.R;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.viewModels.PlanetViewModel;
import com.cs2340.teama.views.adapters.MarketAdapter;

import java.util.List;


/**
 * Note that the ViewModel for this class is PlanetViewModel.
 */
public class MarketPlaceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    MarketAdapter mAdapter;
    PlanetViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

        viewModel = new PlanetViewModel();
        List<TradeGood> goodsList = viewModel.getPlanetGoodsList();
        Log.d("Debug", goodsList.toString() + (goodsList==null));

        recyclerView = (RecyclerView) findViewById(R.id.market_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        Log.d("Debug", goodsList.get(0).toString());
        mAdapter = new MarketAdapter(goodsList);
        recyclerView.setAdapter(mAdapter);

    }

}
