package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.enums.SkillType;

import io.realm.RealmObject;

public class PlayerModel extends RealmObject {

    // --Commented out by Inspection (4/14/19, 2:14 PM):private String name;
    
    private int credits;
    private int pilotSkillPoints;
    private int fighterSkillPoints;
    private int traderSkillPoints;
    private int engineerSkillPoints;
    private ShipModel ship;

    private int xCoordinates;
    private int yCoordinates;

    public PlayerModel() {

    }

    public PlayerModel(Player player) {
        this.xCoordinates = player.getCoordinates().getX();
        this.yCoordinates = player.getCoordinates().getY();
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

    public int getEngineerSkillPoints() {
        return engineerSkillPoints;
    }

    public int getTraderSkillPoints() {
        return traderSkillPoints;
    }

    public int getFighterSkillPoints() {
        return fighterSkillPoints;
    }

    public int getPilotSkillPoints() {
        return pilotSkillPoints;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public void decrementCredits(TradeGoodModel model) {
        this.credits -= model.getValue();
    }

    public void incrementCredits(double amount) {
        this.credits += amount;
    }

    public ShipModel getShip() {
        return ship;
    }

    public void setCoordinates(int x, int y) {
        this.xCoordinates = x;
        this.yCoordinates = y;
    }

    public int getXCoords() {
        return this.xCoordinates;
    }

    public int getYCoords() {
        return this.yCoordinates;
    }

    public Coordinates getCoordinates() {
        return new Coordinates(this.getXCoords(), this.getYCoords());
    }
}
