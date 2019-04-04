package com.cs2340.teama.models;

import com.cs2340.teama.models.enums.ShipType;
import com.cs2340.teama.models.enums.SkillType;
import com.cs2340.teama.models.realm.PlayerModel;

public class Player {
    private String name;
    private SkillType[] skills;
    private Ship ship;
    private int credits;
    private Coordinates coordinates;

    public Player(PlayerModel playerModel) {
        this.name = playerModel.getName();
        this.coordinates = new Coordinates(playerModel.getXCoords(), playerModel.getYCoords());
    }


    public Player(String name, Coordinates coordinates1) {
        this.coordinates = coordinates1;
        this.name = name;
        this.ship = new Ship(ShipType.GNAT);
        skills = SkillType.values();
        credits = 1000;

    }

    public void incrementSkill(SkillType skill, int increase) {
        for(SkillType sk: skills) {
            if(sk == skill)  {
                sk.incrementSkillPointBy(increase);
            }
        }
    }

    public void decrementCredits(TradeGood good) {
        credits -= good.getValue();
    }

    public boolean canBuy(TradeGood good) {
        return credits >= good.getValue();
    }

    public boolean canSell(TradeGood good) {
        for(TradeGood g: ship.getCargoHold()) {
            if(g.getGoodType() == good.getGoodType() && g.getVolume()>0) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public SkillType[] getSkills() {
        return skills;
    }

    public Ship getShip() {
        return ship;
    }

    public void incrementCredits(TradeGood good) {
        this.credits += good.getValue();
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        String playerString = "\nPlayers name is " + name + ".\n";
        for (SkillType sk: skills) {
            playerString = playerString + name + " has " + sk.getSkillPointsAllocated() + " points"
            + " allocated to " + sk + ".\n";
        }
        playerString = playerString + "Player's ship is the " + getShip() + ".\n";
        playerString = playerString + "Player has " + getCredits() + " credits.";
        return playerString;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void travel(Coordinates destCoord) {
        ship.travelDist(Coordinates.distTo(coordinates, destCoord));
        this.coordinates = destCoord;

    }
}
