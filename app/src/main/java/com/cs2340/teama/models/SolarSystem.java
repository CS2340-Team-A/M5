package com.cs2340.teama.models;

import com.cs2340.teama.models.enums.Resources;
import com.cs2340.teama.models.enums.TechLevel;
import com.cs2340.teama.models.realm.SolarSystemModel;

import java.util.List;

/**
 * Represents a SolarSystem object in the game
 */
public class SolarSystem {
    private final String name;
    private final Coordinates coordinates;
    private final TechLevel techLevel;
    private final Planet planet;

    SolarSystem(SolarSystemModel ssm) {
        this.name = ssm.getName();
        this.coordinates = new Coordinates(ssm.getXCoords(), ssm.getYCoords());
        this.techLevel = TechLevel.valueOf(ssm.getTechLevel());
        this.planet = new Planet(ssm);
    }

    SolarSystem(String name, Coordinates coordinates, TechLevel techLevel, Resources resources) {
        this.name = name;
        this.coordinates = coordinates;
        this.techLevel = techLevel;
        this.planet = new Planet(name, resources, techLevel);
    }

    /**
     * @param solarSystems solar system being searched
     * @param planetCoords coordinate of solar system
     * @return solar system with matching coordinates
     */
    public static SolarSystem findSolarSystemByCoords(List<SolarSystem> solarSystems,
                                                      Coordinates planetCoords) {
        // here we should implement a good search algorithm or closest to algorithm
        SolarSystem foundSolarSystem = solarSystems.get(0);
        for (SolarSystem s :solarSystems) {
            if (s.getCoordinates().equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem;
    }

    public static Planet findSolarSystemPlanetByCoords(List<SolarSystem> solarSystems,
                                                      Coordinates planetCoords) {
        // here we should implement a good search algorithm or closest to algorithm
        SolarSystem foundSolarSystem = solarSystems.get(0);
        for (SolarSystem s :solarSystems) {
            if (s.getCoordinates().equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem.planet;
    }

    public static List<TradeGood> findSolarSystemPlanetGoodsListByCoords(List<SolarSystem> solarSystems,
                                                       Coordinates planetCoords) {
        // here we should implement a good search algorithm or closest to algorithm
        SolarSystem foundSolarSystem = solarSystems.get(0);
        for (SolarSystem s :solarSystems) {
            if (s.getCoordinates().equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem.planet.getTradeGoods();
    }

    /**
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Coordinates: " + coordinates.toString() +
                " | Tech Level: " + techLevel;
    }
}
