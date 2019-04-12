package com.cs2340.teama;
import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.enums.GoodType;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests written for the canSell() method in the Player class
 *
 * @author zjames7
 */
public class PlayerTest {
    private Player player;


    @Before
    public void setup() {
        player = new Player("Names,", new Coordinates(10,10));
    }

    @Test
    public void testCanSell() {
        TradeGood water = new TradeGood(0, GoodType.WATER, 2);
        TradeGood ore = new TradeGood(0, GoodType.ORE, 3);
        TradeGood medicine = new TradeGood(0, GoodType.MEDICINE, 1);

        //Cannot sell if cargo hold is empty
        assertFalse(player.canSell(water));
        assertFalse(player.canSell(ore));
        assertFalse(player.canSell(medicine));

        player.getShip().addToCargoHold(water);
        player.getShip().addToCargoHold(ore);
        player.getShip().addToCargoHold(medicine);

        //Can sell if item is in cargo hold and quantity is greater than zero
        assertTrue(player.canSell(water));
        assertTrue(player.canSell(ore));
        assertTrue(player.canSell(medicine));

        //Cannot sell if item has quantity of zero
        assertFalse(player.canSell(new TradeGood(0, GoodType.MACHINES, 2)));
        assertFalse(player.canSell(new TradeGood(10, GoodType.FIREARMS, 2)));
        assertFalse(player.canSell(new TradeGood(90, GoodType.NARCOTICS, 2)));
    }

    @Test (expected = NullPointerException.class)
    public void testCanSellNullException() {
        player.canSell(null);
    }
}
