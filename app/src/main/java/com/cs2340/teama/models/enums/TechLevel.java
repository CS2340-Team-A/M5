package com.cs2340.teama.models.enums;

/**
 *
 */
public enum TechLevel {
    PreAgriculture(0),
    Agriculture(1),
    Medieval(2),
    Renaissance(3),
    EarlyIndustrial(4),
    Industrial(5),
    PostIndustrial(6),
    HiTech(7);

    private int techLv = 0;

    TechLevel(int lv) {
        techLv = lv;
    }

    /**
     * @return
     */
    public int getTechLv() {
        return techLv;
    }
}
