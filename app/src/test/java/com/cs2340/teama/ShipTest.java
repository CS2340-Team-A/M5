package com.cs2340.teama;

import com.cs2340.teama.models.Ship;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.enums.ShipType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {

    private Ship ship;


    @Before
    public void setup() {
        ship = new Ship(ShipType.GNAT);
    }

    @Test
    public void testAddToCargoHold() {
        boolean addSuccess = ship.addToCargoHold(
                new TradeGood(
                        0,
                        GoodType.WATER,
                        ship.getShipType().getCargoSpace() + 1
                )
        );
                ;
        Assert.assertFalse(
                "should return false if cargo space is full",
                addSuccess
        );
        Assert.assertEquals(
                "numGoodsStored should be unchanged if cargo space is full",
                ship.getNumGoodsStored(),
                0
        );
        for (TradeGood tg: ship.getCargoHold()) {
            if (tg.getGoodType() == GoodType.WATER) {
                Assert.assertEquals(
                        "volume of the GoodType in the ship's cargo should be unchanged if the cargo space is full",
                        tg.getVolume(),
                        0
                );
            }
        }
        int addAmount = (int) (Math.random() * 19);
        addSuccess = ship.addToCargoHold(new TradeGood(0, GoodType.WATER, addAmount));
        Assert.assertTrue("should return true if good is added successfully", addSuccess);
        Assert.assertEquals(
                "numGoodsStored should be incremented if good is added successfully",
                ship.getNumGoodsStored(),
                addAmount
        );
        for (TradeGood tg: ship.getCargoHold()) {
            if (tg.getGoodType() == GoodType.WATER) {
                Assert.assertEquals(
                        "volume of the GoodType in the ship's cargo updated by amount added",
                        tg.getVolume(),
                        addAmount
                );
            }
        }
        TradeGood invalidGood = ship.getCargoHold().get(0);
        ship.getCargoHold().remove(invalidGood);
        addSuccess = ship.addToCargoHold(new TradeGood(0, invalidGood.getGoodType(), 1));
        Assert.assertFalse("should return false if unknown goodtype is added", addSuccess);
        Assert.assertEquals(
                "numGoodsStored should remain the same if unknown goodtype is added",
                ship.getNumGoodsStored(),
                addAmount
        );
    }
}
