package com.cs2340.teama.models;

import android.util.Log;

import com.cs2340.teama.models.enums.GoodType;

public class TradeGood {

    private double value;
    private int volume;
    private GoodType goodType;

    public TradeGood(double value, GoodType gT) {
        this(value, gT, 1);
    }

    public TradeGood(double value, GoodType gT, int volume) {
        this.value = value;
        this.goodType = gT;
        this.volume = volume;
        Log.d("Edit","Created good " + gT + " with value " + value +" and volume " + volume);
    }

    public double getValue() {
        return value;
    }

    public int getVolume() {
        return volume;
    }

    public GoodType getGoodType() {
        return goodType;
    }

    /**
     * Note I made the Ç the money sign in this game for fun
     *
     * @return a string representation of the TradeGood
     */
    @Override
    public String toString() {
        return goodType + "with price Ç" + value + " takes up " + volume + " units of cargo space.";
    }
}
