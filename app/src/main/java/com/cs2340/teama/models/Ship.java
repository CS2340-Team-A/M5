package com.cs2340.teama.models;

import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.enums.ShipType;
import com.cs2340.teama.models.enums.TradeGoodType;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private ShipType shipType;
    private List<TradeGood> cargoHold;
    private int numGoodsStored;
    public Ship (ShipType shipType) {
        this.cargoHold = new ArrayList<TradeGood>();
        for(GoodType t: GoodType.values()) {
            cargoHold.add(new TradeGood(0, t, 0));
        }
        this.shipType = shipType;
        numGoodsStored = 0;
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

    public boolean removeFromCargoHold(TradeGood removedGood) {
        for(TradeGood g: cargoHold) {
            if(g.getGoodType() == removedGood.getGoodType()) {
                if(g.getVolume() < removedGood.getVolume()) {
                    return false;
                }
                g.decrementVolume(removedGood.getVolume());
                numGoodsStored -= removedGood.getVolume();
                return true;
            }
        }
        return false;
    }
}
