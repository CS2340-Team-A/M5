package com.cs2340.teama.m5.models;

import com.cs2340.teama.m5.models.enums.Resources;
import com.cs2340.teama.m5.models.enums.TechLevel;

public class SolarSystem {

    private String name;
    private Coordinates coordinates;
    private TechLevel techLevel;
    private Resources resources;

    public SolarSystem(String name, Coordinates coordinates, TechLevel techLevel, Resources resources) {
        this.name = name;
        this.coordinates = coordinates;
        this.techLevel = techLevel;
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Coordinates: " + coordinates.toString() +
                " | Tech Level: " + techLevel + " | Resources: " + resources;
    }
}
