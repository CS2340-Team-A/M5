package com.cs2340.teama.models;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object comp) {

        // If the object is compared with itself then return true
        if (comp == this) {
            return true;
        }
        if (!(comp instanceof Coordinates)) {
            return false;
        }
        Coordinates compCoords = (Coordinates) comp;
        return compCoords.getX() == getX() && compCoords.getY() == getY();
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }
}
