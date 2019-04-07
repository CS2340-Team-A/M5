package com.cs2340.teama;

import com.cs2340.teama.models.Ship;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.enums.ShipType;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShipTest {

    private Ship ship;


    @Before
    public void setup() {
        ship = new Ship(ShipType.GNAT);
    }

    @Test
    public void testAddToCargoHold() {
        boolean addSuccess = ship.addToCargoHold(new TradeGood(0, GoodType.WATER, 21));
    }

}
