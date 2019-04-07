package com.cs2340.teama.models;

/**
 * Coordinates represent the location of a Planet in the SpaceTrader Universe
 */
public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the Euclidean distance between two coordinates
     * @param c1 Coordinate
     * @param c2 Coordinate
     * @return distance
     */
    public static double distTo(Coordinates c1, Coordinates c2) {
        double x = c2.x-c1.x;
        double y = c2.y-c1.y;
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
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
