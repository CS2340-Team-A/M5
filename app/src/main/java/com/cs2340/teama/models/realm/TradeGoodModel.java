package com.cs2340.teama.models.realm;


import com.cs2340.teama.models.TradeGood;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;

public class TradeGoodModel extends RealmObject {

    private String type;
    private int quantity;
    private double value;

    @LinkingObjects("tradeGoods")
    private final RealmResults<SolarSystemModel> system = null;

    public TradeGoodModel() {}

    public TradeGoodModel(TradeGood tradeGood) {
        this.type = tradeGood.getGoodType().toString();
        this.quantity = tradeGood.getVolume();
        this.value = tradeGood.getValue();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
