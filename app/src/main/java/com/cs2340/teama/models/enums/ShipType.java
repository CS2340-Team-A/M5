package com.cs2340.teama.models.enums;

public enum ShipType {
    GNAT(20);

    private int cargoSpace;
    ShipType(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }
}
