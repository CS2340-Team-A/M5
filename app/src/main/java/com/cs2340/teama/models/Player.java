package com.cs2340.teama.models;

import com.cs2340.teama.models.enums.ShipType;
import com.cs2340.teama.models.enums.SkillType;

public class Player {
    private String name;
    private SkillType[] skills;
    private ShipType ship;
    private int credits;
    private Coordinates coordinates;

    public Player(String name, Coordinates coordinates1) {
        this.coordinates = coordinates1;
        this.name = name;
        this.ship = ShipType.GNAT;
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

    public String getName() {
        return name;
    }

    public SkillType[] getSkills() {
        return skills;
    }

    public ShipType getShip() {
        return ship;
    }

    public void setCredits(int newCreditValue) {
        this.credits = newCreditValue;
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
}
