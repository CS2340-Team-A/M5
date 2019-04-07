package com.cs2340.teama.models;

import android.util.Log;

import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.enums.ShipType;
import com.cs2340.teama.models.realm.ShipModel;
import com.cs2340.teama.models.realm.TradeGoodModel;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final ShipType shipType;
    private final List<TradeGood> cargoHold;
    private int numGoodsStored;
    private double fuel;
    private final double fuelCapacity;

    public static final double FUEL_EFFICIENCY = 1.0;

    Ship(ShipModel shipModel) {
        this.shipType = ShipType.valueOf(shipModel.getShipName());
        this.numGoodsStored = shipModel.getNumGoodsStored();
        this.fuel = shipModel.getFuel();
        this.fuelCapacity = shipModel.getFuelCapacity();
        this.cargoHold = new ArrayList<>();
        for (TradeGoodModel tradeGoodModel: shipModel.getCargoHold()) {
            cargoHold.add(new TradeGood(tradeGoodModel));
        }
    }

    Ship (ShipType shipType) {
        this.cargoHold = new ArrayList<>();
        for(GoodType t: GoodType.values()) {
            cargoHold.add(new TradeGood(0, t, 0));
        }
        this.shipType = shipType;
        numGoodsStored = 0;
        this.fuel = 200;
        this.fuelCapacity = 200;
    }

    public ShipType  getShipType() {
        return shipType;
    }

    public List<TradeGood> getCargoHold() {
        return cargoHold;
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

    /**
     * @param addedGood
     * @return
     */
    public boolean addToCargoHold(TradeGood addedGood) {
        if((addedGood.getVolume()+numGoodsStored) > shipType.getCargoSpace()) {
            return false;
        }
        for(TradeGood g: cargoHold) {
            if(g.getGoodType() == addedGood.getGoodType()) {
                g.incrementVolume(addedGood.getVolume());
                numGoodsStored += addedGood.getVolume();
                return true;
            }
        }
        return false;
    }

    /**
     * @param removedGood
     */
    public void removeFromCargoHold(TradeGood removedGood) {
        for(TradeGood g: cargoHold) {
            if(g.getGoodType() == removedGood.getGoodType()) {
                if(g.getVolume() < removedGood.getVolume()) {
                    return;
                }
                g.decrementVolume(removedGood.getVolume());
                numGoodsStored -= removedGood.getVolume();
                return;
            }
        }
    }

    /**
     * @param distance
     * @return
     */
    public boolean canTravelDist(double distance) {
        return distance/ FUEL_EFFICIENCY < fuel;
    }

    /**
     * @param distance
     */
    void travelDist(double distance) {
        if (!canTravelDist(distance)) {
            throw new RuntimeException("Not enough fuel to travel distance");
        } else {
            fuel -= distance / FUEL_EFFICIENCY;
            Log.d("Edit", "Fuel level at " + fuel);
        }
    }

}
