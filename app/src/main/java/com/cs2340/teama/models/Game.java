package com.cs2340.teama.models;

/**
 * Game currently being played. Top-level class.
 */
public class Game {
    private final Universe universe;
    private final Player player;

    public static Game game = null;

    public Game(Player p, Universe u) {
        this.player = p;
        this.universe = u;
    }

    public Player getPlayer() {
        return player;
    }

    public Universe getUniverse() {
        return universe;
    }

    /**
     * @return planet specefied
     */
    public Planet getPlanet() {
        Coordinates planetCoords = Game.game.getPlayer().getCoordinates();
        SolarSystem s = SolarSystem.findSolarSystemByCoords(
                Game.game.getUniverse().getSolarSystems(), planetCoords);
        return s.getPlanet();
    }
}
