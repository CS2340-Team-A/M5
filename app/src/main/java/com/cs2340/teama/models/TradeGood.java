package com.cs2340.teama.models;

import android.util.Log;

public class TradeGood {

    private double value;
    private int volume;

    public TradeGood(double value) {
        this(value, 1);
    }

    public TradeGood(double value, int volume) {
        this.value = value;
        this.volume = volume;
        Log.d("Edit","Created TradeGood with value " + value +" and volume " + volume);
    }

    public double getValue() {
        return value;
    }

    public int getVolume() {
        return volume;
    }

    /**
     * Note I made the Ç the money sign in this game for fun
     *
     * @return a string representation of the TradeGood
     */
    @Override
    public String toString() {
        return "Ç " + value + " Trading Good" + " takes up " + volume + " cargo spaces.";
    }
}
