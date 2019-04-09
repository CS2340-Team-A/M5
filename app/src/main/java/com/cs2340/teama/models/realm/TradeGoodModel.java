package com.cs2340.teama.models.realm;


import com.cs2340.teama.models.TradeGood;

import io.realm.RealmObject;

public class TradeGoodModel extends RealmObject {

    private String type;
    private int quantity;
    private double value;

    public TradeGoodModel() {}

    public TradeGoodModel(TradeGood tradeGood) {
        this.type = tradeGood.getGoodType().toString();
        this.quantity = tradeGood.getVolume();
        this.value = tradeGood.getValue();
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getValue() {
        return value;
    }

    public void removeQuantity(int amount) {
        this.quantity -= amount;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void decrementQuantity() {
        this.quantity--;
    }
}
