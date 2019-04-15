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
            if (s.coordinates.equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem;
    }

    /**
     * @param solarSystems list of solar systems
     * @param planetCoords coordinates of planet
     * @return planet
     */
    public static Planet findSolarSystemPlanetByCoords(List<SolarSystem> solarSystems,
                                                      Coordinates planetCoords) {
        // here we should implement a good search algorithm or closest to algorithm
        SolarSystem foundSolarSystem = solarSystems.get(0);
        for (SolarSystem s :solarSystems) {
            if (s.coordinates.equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem.planet;
    }
    /**
     * @param solarSystems list of solar systems
     * @param planetCoords coordinates of planet
     * @return planet's list og goods
     */
    public static List<TradeGood> findSolarSystemPlanetGoodsListByCoords(
            List<SolarSystem> solarSystems, Coordinates planetCoords) {
        // here we should implement a good search algorithm or closest to algorithm
        SolarSystem foundSolarSystem = solarSystems.get(0);
        for (SolarSystem s :solarSystems) {
            if (s.coordinates.equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem.planet.getTradeGoods();
    }
    /**
     * @param solarSystems list of solar systems
     * @param planetCoords coordinates of planet
     * @return planet's name
     */
    public static String findSolarSystemPlanetNameByCoords(List<SolarSystem> solarSystems,
                                                                         Coordinates planetCoords) {
        // here we should implement a good search algorithm or closest to algorithm
        SolarSystem foundSolarSystem = solarSystems.get(0);
        for (SolarSystem s :solarSystems) {
            if (s.coordinates.equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem.planet.getName();
    }
    /**
     * @param solarSystems list of solar systems
     * @param planetCoords coordinates of planet
     * @return planet's info
     */
    public static String findSolarSystemPlanetInfoByCoords(List<SolarSystem> solarSystems,
                                                           Coordinates planetCoords) {
        // here we should implement a good search algorithm or closest to algorithm
        SolarSystem foundSolarSystem = solarSystems.get(0);
        for (SolarSystem s :solarSystems) {
            if (s.coordinates.equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem.planet.getInfo();
    }
    /**
     * @param solarSystems list of solar systems
     * @param planetCoords coordinates of planet
     * @return planet's id
     */
    public static int findSolarSystemPlanetIDByCoords(List<SolarSystem> solarSystems,
                                                           Coordinates planetCoords) {
        // here we should implement a good search algorithm or closest to algorithm
        SolarSystem foundSolarSystem = solarSystems.get(0);
        for (SolarSystem s :solarSystems) {
            if (s.coordinates.equals(planetCoords)) {
                foundSolarSystem = s;
            }
        }
        return foundSolarSystem.planet.getId();
    }

    /**
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return x coordinate
     */
    public int getXCoordinates() {
        return coordinates.getX();
    }
    /**
     * @return y coordinate
     */
    public int getYCoordinates() {
        return coordinates.getY();
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

    /**
     * @return list of trade goods
     */
    public List<TradeGood> getTradeGoods() {
        return planet.getTradeGoods();
    }
    /**
     * @return planet's tech level
     */
    public TechLevel getPlanetTlv() {
        return planet.getTLv();
    }
    /**
     * @return planet's resources
     */
    public Resources getPlanetResources() {
        return planet.getResources();
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Coordinates: " + coordinates.toString() +
                " | Tech Level: " + techLevel;
    }
}
