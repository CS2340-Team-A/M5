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

    /**
     * @param p player
     * @param u universe
     */
    public static void getInstance(Player p, Universe u) {
        if (Game.game == null) {
            Game.game = new Game(p, u);
        }
    }

    /**
     * Deletes the game
     */
    public static void deleteInstance() {
        game = null;
    }

    /**
     * @return game
     */
    public static Game getInstance() {
        return Game.game;
    }

    /**
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return universe
     */
    public Universe getUniverse() {
        return universe;
    }

    /**
     * @return player credits
     */
    public int getPlayerCredits() {
        return player.getCredits();
    }

    public int getNumGoodsStored() {
        return player.getShipGoodsStored();
    }

    public int getCargoSpace() {
        return player.getShipCargoSpace();
    }

    public boolean canBuy(TradeGood good) {
        return player.canBuy(good);
    }

    public boolean addToPlayerCargoHold(TradeGood good) {
        return player.addToShipCargoHold(good);
    }

    public void decrementPlayerCredits(TradeGood good) {
        player.decrementCredits(good);
    }
    /**
     * @return planet specefied
     */
    public Planet getPlanet() {
        Coordinates planetCoords = Game.game.player.getCoordinates();
        return SolarSystem.findSolarSystemPlanetByCoords(
                Game.game.universe.getSolarSystems(), planetCoords);
    }

    public Coordinates getPlayerCoordinates() {
        return player.getCoordinates();
    }
}
