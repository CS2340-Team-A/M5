package com.cs2340.teama.models;

import com.cs2340.teama.models.enums.Resources;
import com.cs2340.teama.models.enums.TechLevel;

import java.util.List;

public class SolarSystem {
    private String name;
    private Coordinates coordinates;
    private TechLevel techLevel;
    private Planet planet;

    public SolarSystem(String name, Coordinates coordinates, TechLevel techLevel, Resources resources) {
        this.name = name;
        this.coordinates = coordinates;
        this.techLevel = techLevel;
        this.planet = new Planet(name, resources);
    }

    public static SolarSystem findSolarSystemByCoords(List<SolarSystem> solarSystems, Coordinates planetCoords) {
        // here we should implement a good search algorithm or closest to algorithm
        SolarSystem foundSolarSystem = solarSystems.get(0);
        for (SolarSystem s :solarSystems) {
            if (s.getCoordinates().equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Planet getPlanet() {
        return planet;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Coordinates: " + coordinates.toString() +
                " | Tech Level: " + techLevel;
    }
}
