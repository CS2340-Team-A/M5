package com.cs2340.teama.m5.models.enums;

public enum SkillType {
    PILOT(0), FIGHTER(0), TRADER(0), ENGINEER(0);

    private int skillPointsAllocated;

    SkillType(int initSkillPts) {
        skillPointsAllocated = initSkillPts;
    }

    public int getSkillPointsAllocated() {
        return skillPointsAllocated;
    }

    public void incrementSkillPointBy(int increase) {
        this.skillPointsAllocated += increase;
    }
}
