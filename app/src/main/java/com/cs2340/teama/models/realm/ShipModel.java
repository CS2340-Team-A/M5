package com.cs2340.teama.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ShipModel extends RealmObject {
    @PrimaryKey
    private int id;

    @Required
    private String shipName;
    private int numGoodsStored;
    private double fuel;
    private double fuelCapacity;
    private RealmList<TradeGoodModel> cargoHold;

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getNumGoodsStored() {
        return numGoodsStored;
    }

    public void setNumGoodsStored(int numGoodsStored) {
        this.numGoodsStored = numGoodsStored;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public RealmList<TradeGoodModel> getCargoHold() {
        return cargoHold;
    }

    public void setCargoHold(RealmList<TradeGoodModel> cargoHold) {
        this.cargoHold = cargoHold;
    }
}
