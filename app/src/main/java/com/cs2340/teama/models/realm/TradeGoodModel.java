package com.cs2340.teama.models.realm;


import com.cs2340.teama.models.TradeGood;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;

/**
 * A Realm object that stores the information of the TradeGoods
 */
public class TradeGoodModel extends RealmObject {

    private String type;
    private int quantity;
    private double value;

    @SuppressWarnings("ALL")
    @LinkingObjects("tradeGoods")
    private final RealmResults<SolarSystemModel> system = null;

    /**
     * Constructor
     */
    public TradeGoodModel() {
    }
    /**
     * @param tradeGood whose data is to be stored
     */
    public TradeGoodModel(TradeGood tradeGood) {
        this.type = tradeGood.getGoodType().toString();
        this.quantity = tradeGood.getVolume();
        this.value = tradeGood.getValue();
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param amount to reduce quantity by
     */
    public void removeQuantity(int amount) {
        this.quantity -= amount;
    }

    /**
     * @param amount to increase quantity by
     */
    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    /**
     * Decrements quantity by one
     */
    public void decrementQuantity() {
        this.quantity--;
    }
}
