package com.cs2340.teama.models.enums;

/**
 *
 */
public enum SkillType {
    PILOT(), FIGHTER(), TRADER(), ENGINEER();

    private int skillPointsAllocated;

    SkillType() {
        skillPointsAllocated = 0;
    }

    public int getSkillPointsAllocated() {
        return skillPointsAllocated;
    }

    /**
     * @param increase
     */
    public void incrementSkillPointBy(int increase) {
        this.skillPointsAllocated += increase;
    }
}
