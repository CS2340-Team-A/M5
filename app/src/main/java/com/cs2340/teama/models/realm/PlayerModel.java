package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.enums.SkillType;

import io.realm.RealmObject;

/**
 * A Realm object that stores the information of the Player
 */
public class PlayerModel extends RealmObject {

    private String name;

    private int credits;
    private int pilotSkillPoints;
    private int fighterSkillPoints;
    private int traderSkillPoints;
    private int engineerSkillPoints;
    private ShipModel ship;

    private int xCoordinates;
    private int yCoordinates;

    /**
     * Constructor
     */
    public PlayerModel() {
    }

    /**
     * Constructor
     *
     * @param player containing stored information
     */
    public PlayerModel(Player player) {
        this.xCoordinates = player.getXCoord();
        this.yCoordinates = player.getYCoord();
        this.credits = player.getCredits();
        for (SkillType skillType: player.getSkills()) {
            switch (skillType.toString()) {
                case "PILOT":
                    this.pilotSkillPoints = skillType.getSkillPointsAllocated();
                    break;
                case "FIGHTER":
                    this.fighterSkillPoints = skillType.getSkillPointsAllocated();
                    break;
                case "TRADER":
                    this.traderSkillPoints = skillType.getSkillPointsAllocated();
                    break;
                case "ENGINEER":
                    this.engineerSkillPoints = skillType.getSkillPointsAllocated();
                    break;
            }
        }
        this.ship = new ShipModel(player.getShip());
    }

    /**
     * @return engineer skill points
     */
    public int getEngineerSkillPoints() {
        return engineerSkillPoints;
    }

    /**
     * @return trader skill points
     */
    public int getTraderSkillPoints() {
        return traderSkillPoints;
    }

    /**
     * @return fighter skill points
     */
    public int getFighterSkillPoints() {
        return fighterSkillPoints;
    }

    /**
     * @return pilot skill points
     */
    public int getPilotSkillPoints() {
        return pilotSkillPoints;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * @param model the trade good whose value is being deducted
     */
    public void decrementCredits(TradeGoodModel model) {
        this.credits -= model.getValue();
    }

    /**
     * @param amount the amount to increment the credits by
     */
    public void incrementCredits(double amount) {
        this.credits += amount;
    }

    /**
     * @return ship
     */
    public ShipModel getShip() {
        return ship;
    }

    /**
     * @param x coordinate
     * @param y coordinate
     */
    public void setCoordinates(int x, int y) {
        this.xCoordinates = x;
        this.yCoordinates = y;
    }

    /**
     * @return x coordinate
     */
    public int getXCoords() {
        return this.xCoordinates;
    }

    /**
     * @return y coordinate
     */
    public int getYCoords() {
        return this.yCoordinates;
    }

    /**
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return new Coordinates(this.getXCoords(), this.getYCoords());
    }

    /**
     * @param good to be added
     * @param vol of good to be added
     */
    public void addToShipCargoHold(String good, int vol) {
        ship.addToCargoHold(good, vol);
    }
    /**
     * @param good to be removed
     * @param vol of good to be removed
     */
    public void removeFromCargoHold(String good, int vol) {
        ship.removeFromCargoHold(good, vol);
    }
}
