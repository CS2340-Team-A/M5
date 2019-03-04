package com.cs2340.teama.m5.models;

import com.cs2340.teama.m5.models.enums.Resources;
import com.cs2340.teama.m5.models.enums.TechLevel;

import java.util.List;

public class SolarSystem {

    private String name;
    private Coordinates coordinates;
    private TechLevel techLevel;
    private Resources resources;
    private Planet planet;

    public SolarSystem(String name, Coordinates coordinates, TechLevel techLevel, Resources resources) {
        this.name = name;
        this.coordinates = coordinates;
        this.techLevel = techLevel;
        this.resources = resources;
        this.planet = new Planet(name);
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

    @Override
    public String toString() {
        return "Name: " + name + " | Coordinates: " + coordinates.toString() +
                " | Tech Level: " + techLevel + " | Resources: " + resources;
    }
}
