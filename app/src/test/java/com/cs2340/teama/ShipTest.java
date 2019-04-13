package com.cs2340.teama;

import com.cs2340.teama.models.Ship;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.enums.ShipType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShipTest {

    private Ship ship;


    @Before
    public void setup() {
        this.ship = new Ship(ShipType.GNAT);
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
                        "volume of the GoodType in the ship's cargo should be unchanged" +
                                "if the cargo space is full",
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
                        "volume of the GoodType in the ship's cargo updated by" +
                                " amount added",
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

    //Animesh's Individual JUnit Test Code for M10
    @Test
    public void testRemoveFromCargoHold() {
        final int defaultVal = 0;
        final int initWaterQ =  2;
        final int initFirearmQ = 5;
        final int initFoodQ = 13;
        List<TradeGood> initialCargoHoldStore = new ArrayList<>();
        initialCargoHoldStore.add(new TradeGood(defaultVal, GoodType.WATER, initWaterQ));
        initialCargoHoldStore.add(new TradeGood(defaultVal, GoodType.FURS, 0));
        initialCargoHoldStore.add(new TradeGood(defaultVal, GoodType.FOOD, initFoodQ));
        initialCargoHoldStore.add(new TradeGood(defaultVal, GoodType.ORE, 0));
        initialCargoHoldStore.add(new TradeGood(defaultVal, GoodType.GAMES, 0));
        initialCargoHoldStore.add(new TradeGood(defaultVal, GoodType.FIREARMS, initFirearmQ));
        initialCargoHoldStore.add(new TradeGood(defaultVal,GoodType.MEDICINE, 0));
        initialCargoHoldStore.add(new TradeGood(defaultVal,GoodType.MACHINES, 0));
        initialCargoHoldStore.add(new TradeGood(defaultVal,GoodType.NARCOTICS, 0));
        initialCargoHoldStore.add(new TradeGood(defaultVal,GoodType.ROBOTS, 0));

        for(TradeGood t: initialCargoHoldStore) {
            ship.addToCargoHold(t);
        }
        List<TradeGood> shipCargoHoldStore = ship.getCargoHold();
        boolean isEqual = true;
        for (int i  = 0; i < shipCargoHoldStore.size(); i++) {
            if (shipCargoHoldStore.get(i).getVolume() != initialCargoHoldStore.get(i)
                    .getVolume()) {
                isEqual = false;
                break;
            }
        }
        ship.removeFromCargoHold(new TradeGood(defaultVal, GoodType.FOOD, 14));
        Assert.assertTrue("Shouldn't remove anything from cargo hold if there isn't "
                + "enough of that particular good in store", isEqual);

        int removeFoodAmount = (int)(Math.random() * 13);
        ship.removeFromCargoHold(new TradeGood(defaultVal, GoodType.FOOD, removeFoodAmount));
        initialCargoHoldStore.get(2).decrementVolume(removeFoodAmount);
        shipCargoHoldStore =  ship.getCargoHold();
        isEqual = true;
        for (int i  = 0; i < shipCargoHoldStore.size(); i++) {
            if (shipCargoHoldStore.get(i).getVolume() != initialCargoHoldStore.get(i)
                    .getVolume()) {
                isEqual = false;
                break;
            }
        }
        Assert.assertTrue("Should remove the specified good by the correct amount when at"
                + " least that much is present in the cargo hold", isEqual);
        Assert.assertEquals("numGoodsStore should be decremented appropriately when" +
                " a certain "
                + "amount of a particular good is removed", (initFirearmQ + initFoodQ
                + initWaterQ) - removeFoodAmount, ship.getNumGoodsStored());

        TradeGood nonExistentGood = new TradeGood(defaultVal, null, 1);
        ship.removeFromCargoHold(nonExistentGood);
        shipCargoHoldStore = ship.getCargoHold();
        isEqual = true;
        for (int i  = 0; i < shipCargoHoldStore.size(); i++) {
            if (shipCargoHoldStore.get(i).getVolume() != initialCargoHoldStore.get(i)
                    .getVolume()) {
                isEqual = false;
                break;
            }
        }
        Assert.assertTrue("If an unknown good is inputted, nothing should be removed",
                isEqual);
        TradeGood negativeGood = new TradeGood(defaultVal, GoodType.FOOD, -1);
        ship.removeFromCargoHold(negativeGood);
        shipCargoHoldStore = ship.getCargoHold();
        isEqual = true;
        for (int i  = 0; i < shipCargoHoldStore.size(); i++) {
            if (shipCargoHoldStore.get(i).getVolume() != initialCargoHoldStore.get(i)
                    .getVolume()) {
                isEqual = false;
                break;
            }
        }
        Assert.assertTrue("If an good with negative quantity is inputted, nothing should"
                + " be removed", isEqual);
    }
}
