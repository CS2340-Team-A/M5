package com.cs2340.teama.models;

import com.cs2340.teama.models.enums.ShipType;
import com.cs2340.teama.models.enums.SkillType;
import com.cs2340.teama.models.realm.PlayerModel;

import java.util.List;

/**
 * Player class this represents the user in the game and all of the attributes
 * and actions the user has and can take.
 */
public class Player {
    private final String name;
    private final SkillType[] skills;
    private final Ship ship;
    private int credits;
    private Coordinates coordinates;


    /**
     * Constructor
     * @param playerModel Realm object
     */
    public Player(PlayerModel playerModel) {
        this.name = playerModel.getName();
        this.coordinates = new Coordinates(playerModel.getXCoords(), playerModel.getYCoords());
        this.credits = playerModel.getCredits();
        this.ship = new Ship(playerModel.getShip());
        this.skills = new SkillType[SkillType.values().length];
        this.skills[0] = SkillType.PILOT;
        this.skills[0].incrementSkillPointBy(playerModel.getPilotSkillPoints());
        this.skills[1] = SkillType.FIGHTER;
        this.skills[1].incrementSkillPointBy(playerModel.getFighterSkillPoints());
        this.skills[2] = SkillType.TRADER;
        this.skills[2].incrementSkillPointBy(playerModel.getTraderSkillPoints());
        this.skills[3] = SkillType.ENGINEER;
        this.skills[3].incrementSkillPointBy(playerModel.getEngineerSkillPoints());

    }


    /**
     * Constructor
     * @param name of player
     * @param coordinates1 of player's start location
     */
    public Player(String name, Coordinates coordinates1) {
        this.coordinates = coordinates1;
        this.name = name;
        this.ship = new Ship(ShipType.GNAT);
        skills = SkillType.values();
        credits = 1000;

    }

    /**
     * @param skill specifed
     * @param increase amount ot increase by
     */
    public void incrementSkill(SkillType skill, int increase) {
        for(SkillType sk: skills) {
            if(sk == skill)  {
                sk.incrementSkillPointBy(increase);
            }
        }
    }

    /**
     * @param good specified
     */
    public void decrementCredits(TradeGood good) {
        credits -= good.getValue();
    }

    /**
     * @param good specified
     * @return if the good can be purchases
     */
    public boolean canBuy(TradeGood good) {
        return credits >= good.getValue();
    }

    /**
     * @param good specified
     * @return if the good can be sold
     */
    public boolean canSell(TradeGood good) {
        for(TradeGood g: ship.getCargoHold()) {
            if((g.getGoodType() == good.getGoodType()) && (g.getVolume() > 0)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return skills
     */
    public SkillType[] getSkills() {
        return skills.clone();
    }

    /**
     * @return ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * @param good specified
     */
    public void incrementCredits(TradeGood good) {
        this.credits += good.getValue();
    }

    /**
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * @return ship's cargo hold
     */
    public List<TradeGood> getCargoHold() {
        return ship.getCargoHold();
    }
    /**
     * @return ship's current goods
     */
    public int getShipGoodsStored() {
        return ship.getNumGoodsStored();
    }
    /**
     * @return ship's cargo space
     */
    public int getShipCargoSpace() {
        return ship.getCargoSpace();
    }

    /**
     * @param good to be added
     * @return if the good has been added properly
     */
    public boolean addToShipCargoHold(TradeGood good) {
        return ship.addToCargoHold(good);
    }

    /**
     * @param good to be removed
     */
    public void removeFromShipCargoHold(TradeGood good) {
        ship.removeFromCargoHold(good);
    }

    /**
     * @return x coordinate
     */
    public int getXCoord() {
        return coordinates.getX();
    }
    /**
     * @return y coordinate
     */
    public int getYCoord() {
        return coordinates.getY();
    }

    /**
     * @return ship's fuel level
     */
    public double getShipFuel() {
        return ship.getFuel();
    }

    /**
     * @param dist to be traveled
     * @return if the distance can be traveled
     */
    public boolean canTravelDist(double dist) {
        return ship.canTravelDist(dist);
    }

    /**
     * @return ship's fuel capacity
     */
    public double getShipFuelCapacity() {
        return ship.getFuelCapacity();
    }


    @Override
    public String toString() {
        StringBuilder playerString = new StringBuilder("\nPlayers name is " + name + ".\n");
        for (SkillType sk: skills) {
            playerString.append(name).append(" has ").append(sk.getSkillPointsAllocated()).append(" points").append(" allocated to ").append(sk).append(".\n");
        }
        playerString.append("Player's ship is the ").append(getShip()).append(".\n");
        playerString.append("Player has ").append(getCredits()).append(" credits.");
        return playerString.toString();
    }

    /**
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @param destCoord place to travel to
     */
    public void travel(Coordinates destCoord) {
        ship.travelDist(Coordinates.distTo(coordinates, destCoord));
        this.coordinates = destCoord;

    }
}
