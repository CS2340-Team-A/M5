package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.Ship;
import com.cs2340.teama.models.TradeGood;

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

    public void removeFromCargoHold(String cargoType, int volume) {
        for (TradeGoodModel tradeGoodModel: cargoHold) {
            if (cargoType.equals(tradeGoodModel.getType())) {
                tradeGoodModel.removeQuantity(volume);
            }
        }
    }

    public void addToCargoHold(String cargoType, int volume) {
        for (TradeGoodModel tradeGoodModel: cargoHold) {
            if (cargoType.equals(tradeGoodModel.getType())) {
                tradeGoodModel.addQuantity(volume);
            }
        }
    }

}
