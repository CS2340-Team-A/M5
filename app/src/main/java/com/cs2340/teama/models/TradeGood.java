package com.cs2340.teama.models;

import android.support.annotation.NonNull;
import android.util.Log;

import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.realm.TradeGoodModel;

/**
 * Represents a TradeGood object in the game
 */
public class TradeGood {

    private final double value;
    private int quantity;
    private final GoodType goodType;

    /**
     * @param tgm model class from which the Realm database data is loaded
     */
    public TradeGood(TradeGoodModel tgm) {
        this.value = tgm.getValue();
        this.quantity = tgm.getQuantity();
        this.goodType = GoodType.valueOf(tgm.getType());
    }

    /**
     * @param value of good
     * @param gT type of good
     * @param quantity of good
     */
    public TradeGood(double value, GoodType gT, int quantity) {
        this.value = value;
        this.goodType = gT;
        this.quantity = quantity;
        Log.d("Edit","Created good " + gT + " with value " + value +
                " and quantity " + quantity);
    }

    /**
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * @return quantity
     */
    public int getVolume() {
        return quantity;
    }

    /**
     * @return type of good
     */
    public GoodType getGoodType() {
        return goodType;
    }

    /**
     * @param volAdded number of goods to be added
     */
    void incrementVolume(int volAdded) {
        quantity += volAdded;
    }

    /**
     * @param volRemoved number of goods to be removed
     */
    public void decrementVolume(int volRemoved) {
        if (quantity < volRemoved) {
            return;
        }
        quantity -= volRemoved;
    }

    /**
     * @return if the player has the good
     */
    public boolean inStock() {
        return quantity > 0;
    }

    /**
     * Note I made the Ç the money sign in this game for fun
     *
     * @return a string representation of the TradeGood
     */
    @NonNull
    @Override
    public String toString() {
        return goodType + " with price Ç" + value + " takes up " + quantity +
                " units of cargo space.";
    }
}
