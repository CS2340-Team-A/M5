package com.cs2340.teama.m5.models;

public class Planet {
    private String name;
    private String planetInfo;

    Planet(String name) {
        this.name = name;
        this.planetInfo = "Generic Planet Info: \n" +
                "\nThis planet exists and the player is probably on it";
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return planetInfo;
    }

    @Override
    public String toString() {
        return "Planet: " + this.name;
    }
}
