package com.cs2340.teama.models;

/**
 * Game currently being played. Top-level class.
 */
public final class Game {
    private final Universe universe;
    private final Player player;

    private static Game game;

    private Game(Player p, Universe u) {
        this.player = p;
        this.universe = u;
    }

    public static void getInstance(Player p, Universe u) {
        if (Game.game == null) {
            Game.game = new Game(p, u);
        }
    }

    public static void deleteInstance() {
        game = null;
    }

    public static Game getInstance() {
        return Game.game;
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
