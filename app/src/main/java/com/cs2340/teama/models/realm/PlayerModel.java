package com.cs2340.teama.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PlayerModel extends RealmObject {

    @PrimaryKey
    private String name;
    
    private int credits;
    private int pilotSkillPoints;
    private int fighterSkillPoints;
    private int traderSkillPoints;
    private int engineerSkillPoints;
    private ShipModel ship;

    private int xCoordinates;
    private int yCoordinates;



    public int getEngineerSkillPoints() {
        return engineerSkillPoints;
    }

    public void setEngineerSkillPoints(int engineerSkillPoints) {
        this.engineerSkillPoints = engineerSkillPoints;
    }

    public int getTraderSkillPoints() {
        return traderSkillPoints;
    }

    public int getFighterSkillPoints() {
        return fighterSkillPoints;
    }

    public void setFighterSkillPoints(int fighterSkillPoints) {
        this.fighterSkillPoints = fighterSkillPoints;
    }

    public int getPilotSkillPoints() {
        return pilotSkillPoints;
    }

    public void setPilotSkillPoints(int pilotSkillPoints) {
        this.pilotSkillPoints = pilotSkillPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTraderSkillPoints(int traderSkillPoints) {
        this.traderSkillPoints = traderSkillPoints;
    }

    public ShipModel getShip() {
        return ship;
    }

    public void setShip(ShipModel ship) {
        this.ship = ship;
    }

    public void setCoordinates(int x, int y) {
        this.xCoordinates = x;
        this.yCoordinates = y;
    }
}
