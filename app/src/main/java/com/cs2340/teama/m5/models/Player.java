package com.cs2340.teama.m5.models;

import com.cs2340.teama.m5.models.enums.ShipType;
import com.cs2340.teama.m5.models.enums.SkillType;

public class Player {
    private String name;
    private SkillType[] skills;
    private ShipType ship;
    private int credits;

    public Player(String name) {
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
}
