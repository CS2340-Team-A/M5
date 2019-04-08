package com.cs2340.teama;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.SolarSystem;
import com.cs2340.teama.models.Universe;
import com.cs2340.teama.models.enums.Resources;
import com.cs2340.teama.models.enums.TechLevel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SolarSystemTest {
    private Universe universe;
    private SolarSystem solarSystem;

    @Before
    public void setup() {
        this.universe = new Universe();
        this.solarSystem = universe.getSolarSystems().get(0);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Written by Eduardo Nava.
     *
     */
    @Test
    public void testFindSolarSystemByCoords() {
        Coordinates myCoords = solarSystem.getCoordinates();
        assertEquals("Make sure we get our solar system when"
                + " it is in the list",solarSystem,
                SolarSystem.findSolarSystemByCoords(universe.getSolarSystems(),
                        myCoords));

        List<SolarSystem> list = universe.getSolarSystems();
        list.remove(solarSystem);
        assertNull("Make sure we get null when"
                + " our solar system isn't in the list", SolarSystem.findSolarSystemByCoords(list, myCoords));

        list.add(solarSystem);
        myCoords = new Coordinates(1000,1000);
        assertNull("Make sure we get null when" +
                " our solar system's coordinates don't match any coords", SolarSystem.findSolarSystemByCoords(list, myCoords));

        //we should get an exception if we input and empty list
        list = (List<SolarSystem>) new LinkedList<SolarSystem>();
        expectedException.expect(IllegalArgumentException.class);
        SolarSystem.findSolarSystemByCoords(list, myCoords);

        expectedException.expect(NullPointerException.class);
        SolarSystem.findSolarSystemByCoords(null, myCoords);
    }
}
