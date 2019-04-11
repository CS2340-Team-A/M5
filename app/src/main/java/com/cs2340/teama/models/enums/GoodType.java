package com.cs2340.teama.models.enums;

/**
 *
 */
public enum GoodType {
    WATER(0, 0, 2, 30, 3, 4, Resources.LOTS_OF_WATER, Resources.DESERT),
    FURS(0, 0, 0, 250, 10, 10, Resources.RICH_FAUNA, Resources.LIFELESS),
    FOOD(1, 0, 1, 100, 5, 5, Resources.RICH_SOIL, Resources.POOR_SOIL),
    ORE(2, 2, 3, 350, 20, 10, Resources.MINERAL_RICH, Resources.MINERAL_POOR),
    GAMES(3, 1, 6, 250, -10, 5, Resources.ARTISTIC, Resources.NO_SPECIAL_RESOURCES),
    FIREARMS(3, 1, 5, 1250, -75, 100, Resources.WARLIKE, Resources.NO_SPECIAL_RESOURCES),
    MEDICINE(4, 1, 6, 650, -20, 10, Resources.LOTS_OF_HERBS, Resources.NO_SPECIAL_RESOURCES),
    MACHINES(4, 3, 5, 900, -30, 5, Resources.NO_SPECIAL_RESOURCES, Resources.NO_SPECIAL_RESOURCES),
    NARCOTICS(5, 0, 5, 3500, -125, 150, Resources.WEIRD_MUSHROOMS, Resources.NO_SPECIAL_RESOURCES),
    ROBOTS(6, 4, 7, 5000, -150, 100, Resources.NO_SPECIAL_RESOURCES,
            Resources.NO_SPECIAL_RESOURCES);

    private final int MTLP;
    private final int MTLU;
    private final int TTP;
    private final int basePrice;
    private final int IPL;
    private final int var;
    private final Resources CR;
    private final Resources ER;

    GoodType(int mtlp, int mtlu, int ttp, int baseP, int ipl, int v, Resources cr, Resources er) {
        this.MTLP = mtlp;
        this.MTLU = mtlu;
        this.TTP = ttp;
        this.basePrice = baseP;
        this.IPL = ipl;
        this.var = v;
        this.CR = cr;
        this.ER = er;
    }

    public int getMTLP() {
        return this.MTLP;
    }

    public int getMTLU() {
        return this.MTLU;
    }

    public int getTTP() {
        return this.TTP;
    }

    public int getBasePrice() {
        return this.basePrice;
    }

    public int getIPL() {
        return this.IPL;
    }

    public int getVar() {
        return this.var;
    }

    public Resources getCR() {
        return this.CR;
    }

    public Resources getER() {
        return this.ER;
    }
}
