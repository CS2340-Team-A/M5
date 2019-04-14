package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.Ship;
import com.cs2340.teama.models.TradeGood;

import java.util.Collections;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * A Realm object that stores the information of the Ship
 */
public class ShipModel extends RealmObject {
    private String shipName;
    private int numGoodsStored;
    private double fuel;
    private double fuelCapacity;
    private RealmList<TradeGoodModel> cargoHold;

    /**
     * @param ship that whose data is to be stored
     */
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


    /**
     * @return ship name
     */
    public String getShipName() {
        return shipName;
    }
    /**
     * @return number of goods stored in the cargo hold
     */
    public int getNumGoodsStored() {
        return numGoodsStored;
    }
    /**
     * @return fuel
     */
    public double getFuel() {
        return fuel;
    }
    /**
     * @return fuel capacity
     */
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * @return cargo hold
     */
    public List<TradeGoodModel> getCargoHold() {
        return Collections.unmodifiableList(cargoHold);
    }

    /**
     * @param cargoType good to be removed
     * @param volume number of goods to removed
     */
    public void removeFromCargoHold(String cargoType, int volume) {
        for (TradeGoodModel tradeGoodModel: cargoHold) {
            if (cargoType.equals(tradeGoodModel.getType())) {
                tradeGoodModel.removeQuantity(volume);
                numGoodsStored -= volume;
            }
        }
    }

    /**
     * @param cargoType good to be added
     * @param volume number of goods to added
     */
    public void addToCargoHold(String cargoType, int volume) {
        for (TradeGoodModel tradeGoodModel: cargoHold) {
            if (cargoType.equals(tradeGoodModel.getType())) {
                tradeGoodModel.addQuantity(volume);
                numGoodsStored += volume;
            }
        }
    }

    /**
     * @param fuel amount of fuel to remove
     */
    public void removeFuel(double fuel) {
        this.fuel -= fuel;
    }

}
