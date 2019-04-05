package com.cs2340.teama.models.enums;

public enum ShipType {
    GNAT();

    private final int cargoSpace;
    ShipType() {
        this.cargoSpace = 20;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }
}
