package com.cs2340.teama.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.m5.R;

import java.util.List;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.GoodViewHolder> {

    public static class GoodViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public GoodViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    private List<TradeGood> tradeGoods;

    public MarketAdapter(List<TradeGood> tradeGoods) {
        this.tradeGoods = tradeGoods;
        Log.d("Debug", "Created Market Adapter with "+ tradeGoods.size() + " goods.");
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MarketAdapter.GoodViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.good_layout, parent, false);



        GoodViewHolder vh = new GoodViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(GoodViewHolder viewHolder, int i) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        viewHolder.textView.setText(tradeGoods.get(i).toString());

    }

    @Override
    public int getItemCount() {
        return tradeGoods.size();
    }
}
