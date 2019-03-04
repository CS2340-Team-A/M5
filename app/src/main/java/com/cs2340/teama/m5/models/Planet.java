package com.cs2340.teama.m5.models;

public class Planet {
    private String name;

    Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Planet: " + this.name;
    }
}
