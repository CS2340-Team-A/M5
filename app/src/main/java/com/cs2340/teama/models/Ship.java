package com.cs2340.teama.models;

import android.util.Log;

import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.enums.ShipType;
import com.cs2340.teama.models.realm.ShipModel;
import com.cs2340.teama.models.realm.TradeGoodModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ship {
    private final ShipType shipType;
    private final List<TradeGood> cargoHold;
    private int numGoodsStored;
    private double fuel;
    private final double fuelCapacity;

    public static final double FUEL_EFFICIENCY = 1.0;
    private static final int INITIAL_FUEL = 500;

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

    public Ship (ShipType shipType) {
        this.cargoHold = new ArrayList<>();
        for(GoodType t: GoodType.values()) {
            cargoHold.add(new TradeGood(0, t, 0));
        }
        this.shipType = shipType;
        numGoodsStored = 0;
        this.fuel = INITIAL_FUEL;
        this.fuelCapacity = INITIAL_FUEL;
    }

    public ShipType  getShipType() {
        return shipType;
    }

    public List<TradeGood> getCargoHold() {
        return Collections.unmodifiableList(cargoHold);
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
     * @param addedGood good to add to cargo hold
     * @return if the good was successfully added
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
     * @param removedGood good to be removed
     */
    public void removeFromCargoHold(TradeGood removedGood) {
        for(TradeGood g: cargoHold) {
            if(g.getGoodType() == removedGood.getGoodType()) {
                if((g.getVolume() < removedGood.getVolume()) || (removedGood.getVolume() < 0)) {
                    return;
                }
                g.decrementVolume(removedGood.getVolume());
                numGoodsStored -= removedGood.getVolume();
                return;
            }
        }
    }

    /**
     * Checks current fuel level to see if it can travel said distance. If the
     * distance is negative or too far for the ship to travel on current fuel
     * levels, the method will return false. It will return true otherwise.
     *
     * @param distance distance value
     * @return if it can travel the distance
     */
    public boolean canTravelDist(double distance) {
        if (distance >= 0 ) {
            return (distance / FUEL_EFFICIENCY) < fuel;
        } else {
            return false;
        }

    }

    /**
     * Attempts to travel the distance inputted.
     *
     * @param distance the distance to travel must be >= 0
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
