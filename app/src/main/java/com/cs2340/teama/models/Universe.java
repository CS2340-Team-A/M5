package com.cs2340.teama.models;

import android.support.annotation.NonNull;

import com.cs2340.teama.models.enums.TechLevel;
import com.cs2340.teama.models.enums.Resources;
import com.cs2340.teama.models.realm.SolarSystemModel;
import com.cs2340.teama.models.realm.UniverseModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Represents the Universe in the game
 */
public class Universe {
    private static final String[] SYSTEM_NAMES = new String[]{"Acamar",
            "Adahn",		// The alternate personality for The Nameless One in "Planescape: Torment"
            "Aldea",
            "Andevian",
            "Antedi",
            "Balosnee",
            "Baratas",
            "Brax",			// One of the heroes in Master of Magic
            "Bretel",		// This is a Dutch device for keeping your pants up.
            "Calondia",
            "Campor",
            "Capelle",		// The city I lived in while programming this game
            "Carzon",
            "Castor",		// A Greek demi-god
            "Cestus",
            "Cheron",
            "Courteney",	// After Courteney Cox…
            "Daled",
            "Damast",
            "Davlos",
            "Deneb",
            "Deneva",
            "Devidia",
            "Draylon",
            "Drema",
            "Endor",
            "Esmee",		// One of the witches in Pratchett's Discworld
            "Exo",
    };
    private static final int xBound = 500;
    private static final int yBound = 500;
    private final List<SolarSystem> solarSystems;

    /**
     * @param universeModel from which data is loaded from the Realm database
     */
    public Universe(UniverseModel universeModel) {
        this.solarSystems = new ArrayList<>();
        for (SolarSystemModel ssm: universeModel.getSolarSystems()) {
            solarSystems.add(new SolarSystem(ssm));
        }
    }

    /**
     * Creates a Universe
     */
    public Universe() {
        Random rng = new Random();
        Collection<String> nameSet = new HashSet<>();
        Collection<Coordinates> coordinatesSet = new HashSet<>();
        int systemsLength = Universe.SYSTEM_NAMES.length;
        int resourcesLength = Resources.values().length;
        int techLevelLength = TechLevel.values().length;
        solarSystems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int nameRand = rng.nextInt(systemsLength);
            String systemName = Universe.SYSTEM_NAMES[nameRand];
            while (nameSet.contains(systemName)) {
                nameRand = rng.nextInt(systemsLength);
                systemName = Universe.SYSTEM_NAMES[nameRand];
            }
            nameSet.add(systemName);

            int coordsX = rng.nextInt(Universe.xBound);
            int coordsY = rng.nextInt(Universe.yBound);
            Coordinates coords = new Coordinates(coordsX, coordsY);
            while (coordinatesSet.contains(coords)) {
                coordsX = rng.nextInt(Universe.xBound);
                coordsY = rng.nextInt(Universe.yBound);
                coords = new Coordinates(coordsX, coordsY);
            }
            coordinatesSet.add(coords);

            int randResources = rng.nextInt(resourcesLength);
            Resources resources = Resources.values()[randResources];
            int randTechLevel = rng.nextInt(techLevelLength);
            TechLevel techLevel = TechLevel.values()[randTechLevel];


            solarSystems.add(new SolarSystem(systemName, coords, techLevel, resources));
        }
    }

    /**
     * @return a list of solar systems
     */
    public List<SolarSystem> getSolarSystems() {
        return Collections.unmodifiableList(solarSystems);
    }

    public SolarSystem getFirstSolarSystem() {
        return Collections.unmodifiableList(solarSystems).get(0);
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Solar Systems in Universe:\n");
        for (SolarSystem system : solarSystems) {
            output.append(system.toString()).append("\n");
        }
        return output.toString();
    }
}
