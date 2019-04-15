package com.cs2340.teama.models;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Game currently being played. Top-level class.
 */
public final class Game {
    private final Universe universe;
    private final Player player;

    @Nullable
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

    /**
     * @return number of goods stored
     */
    public int getNumGoodsStored() {
        return player.getShipGoodsStored();
    }

    /**
     * @return player's ship's cargo space
     */
    public int getCargoSpace() {
        return player.getShipCargoSpace();
    }

    /**
     * @return player's cargo hold
     */
    public List<TradeGood> getCargoHold() {
        return player.getCargoHold();
    }

    /**
     * @param good to be purchased
     * @return if the good can be purchased
     */
    public boolean canBuy(TradeGood good) {
        return player.canBuy(good);
    }

    /**
     * @param good to be sold
     * @return if the good can be sold
     */
    public boolean canSell(TradeGood good) {
        return player.canSell(good);
    }

    /**
     * @param good to be added to cargo hold
     * @return if the good has been added
     */
    public boolean addToPlayerCargoHold(TradeGood good) {
        return player.addToShipCargoHold(good);
    }

    /**
     * @param good to be removed
     */
    public void removeFromPlayerCargoHold(TradeGood good) {
        player.removeFromShipCargoHold(good);
    }

    /**
     * @param good whose value is to be removed from player credits
     */
    public void decrementPlayerCredits(TradeGood good) {
        player.decrementCredits(good);
    }

    /**
     * @param val of credits to be added
     */
    public void incrementPlayerCredits(TradeGood val) {
        player.incrementCredits(val);
    }
    /**
     * @return planet specefied
     */
    public Planet getPlanet() {
        Coordinates planetCoords = Game.game.player.getCoordinates();
        return SolarSystem.findSolarSystemPlanetByCoords(
                Game.game.universe.getSolarSystems(), planetCoords);
    }

    /**
     * @return planet's name
     */
    public String getPlanetName() {
        Coordinates planetCoords = Game.game.player.getCoordinates();
        return SolarSystem.findSolarSystemPlanetNameByCoords(
                Game.game.universe.getSolarSystems(), planetCoords);
    }

    /**
     * @return planet's info
     */
    public String getPlanetInfo() {
        Coordinates planetCoords = Game.game.player.getCoordinates();
        return SolarSystem.findSolarSystemPlanetInfoByCoords(
                Game.game.universe.getSolarSystems(), planetCoords);
    }

    /**
     * @return planet's id
     */
    public int getPlanetId() {
        Coordinates planetCoords = Game.game.player.getCoordinates();
        return SolarSystem.findSolarSystemPlanetIDByCoords(
                Game.game.universe.getSolarSystems(), planetCoords);
    }

    /**
     * @return solar system
     */
    public List<SolarSystem> getSolarSystems() {
        return universe.getSolarSystems();
    }

    /**
     * @return player's location in coordinates
     */
    public Coordinates getPlayerCoordinates() {
        return player.getCoordinates();
    }

    /**
     * @return player's ship
     */
    public Ship getShip(){
        return player.getShip();
    }

    /**
     * @return ship fuel level
     */
    public double getShipFuel() {
        return player.getShipFuel();
    }

    /**
     * @return ship's fuel capacity
     */
    public double getShipFuelCapacity() {
        return player.getShipFuelCapacity();
    }

    /**
     * @param dist to be traveled
     * @return if distance can be traveled
     */
    public boolean canTravelDist(double dist) {
        return player.canTravelDist(dist);
    }

    /**
     * @param dest to travel to
     */
    public void travel(Coordinates dest) {
        player.travel(dest);
    }
}
