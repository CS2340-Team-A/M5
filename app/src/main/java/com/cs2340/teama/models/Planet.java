package com.cs2340.teama.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    private String name;
    private String planetInfo;
    private List<TradeGood> tradeGoods;

    Planet(String name) {
        this.name = name;
        this.planetInfo = "Generic Planet Info: \n" +
                "\nThis planet exists and the player is probably on it";
        //here probably call to a tradeGoods factory
        Log.d("Debug", "Planet Created: " + this);
        TradeGood t1 = new TradeGood(1200.12);
        TradeGood t2 = new TradeGood(1000.34);
        TradeGood t3 = new TradeGood(800.72);
        this.tradeGoods = new ArrayList<TradeGood>();
        this.tradeGoods.add(t1);
        this.tradeGoods.add(t2);
        this.tradeGoods.add(t3);
    }

    @Override
    public String toString() {
        return "Planet: " + this.name + "\n" + planetInfo;
    }

    /** Getters **/
    public String getName() {
        return name;
    }

    public String getInfo() {
        return planetInfo;
    }

    public List<TradeGood> getTradeGoods() {
        return this.tradeGoods;
    }
}
