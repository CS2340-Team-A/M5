package com.cs2340.teama.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SolarSystemModel extends RealmObject {

    @PrimaryKey
    private String name;

    private int xCoords;
    private int yCoords;
    private int techLevel;
    private int resourcesName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(int x, int y) {
        this.xCoords = x;
        this.yCoords = y;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    public int getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(int resourcesName) {
        this.resourcesName = resourcesName;
    }
}


