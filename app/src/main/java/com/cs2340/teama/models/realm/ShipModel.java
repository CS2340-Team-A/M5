package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.Ship;
import com.cs2340.teama.models.TradeGood;

import java.util.Collections;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class ShipModel extends RealmObject {
    private String shipName;
    private int numGoodsStored;
    private double fuel;
    private double fuelCapacity;
    private RealmList<TradeGoodModel> cargoHold;

    public ShipModel() {}

    public ShipModel(Ship ship) {
        this.shipName = ship.getShipType().toString();
        this.numGoodsStored = ship.getNumGoodsStored();
        this.fuel = ship.getFuel();
        this.fuelCapacity = ship.getFuelCapacity();
        this.cargoHold = new RealmList<>();
        for (TradeGood tradeGood: ship.getCargoHold()) {
            cargoHold.add(new TradeGoodModel(tradeGood));
        }
    }


    public String getShipName() {
        return shipName;
    }

    public int getNumGoodsStored() {
        return numGoodsStored;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public List<TradeGoodModel> getCargoHold() {
        return Collections.unmodifiableList(cargoHold);
    }

    public void removeFromCargoHold(String cargoType, int volume) {
        for (TradeGoodModel tradeGoodModel: cargoHold) {
            if (cargoType.equals(tradeGoodModel.getType())) {
                tradeGoodModel.removeQuantity(volume);
                numGoodsStored -= volume;
            }
        }
    }

    public void addToCargoHold(String cargoType, int volume) {
        for (TradeGoodModel tradeGoodModel: cargoHold) {
            if (cargoType.equals(tradeGoodModel.getType())) {
                tradeGoodModel.addQuantity(volume);
                numGoodsStored += volume;
            }
        }
    }

    public void removeFuel(double fuel) {
        this.fuel -= fuel;
    }

}
