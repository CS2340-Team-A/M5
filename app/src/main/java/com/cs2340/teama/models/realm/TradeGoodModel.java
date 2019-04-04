package com.cs2340.teama.models.realm;

import android.util.Log;

import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.enums.GoodType;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

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
}
