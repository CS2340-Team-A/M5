package com.cs2340.teama.models.enums;

/**
 * An enum representing all possible tradegoods in the game
 */
public enum TradeGoodType {

    /**
     * The following tradegoods were taken directly from the game. Here is the description of each
     * field according to the M7 assignment page:
     *
     * MTLP = Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
     * MTLU = Minimum Tech Level to Use this resource (You can't sell on planets below this level)
     * TTP = Tech Level which produces the most of this item
     * IPL = Price increase per tech level
     * Var = variance is the maximum percentage that the price can vary above or below the base
     * CR = When this condition is present, the price of this resource is unusually low
     * ER = When this condition is present, the resource is expensive
     * MTL = Min price offered in space trade with random trader (not on a planet)
     * MTH = Max price offered in space trade with random trader (not on a planet)
     *
     * The IE field was not implemented
     */
    Water	  (0, 0, 2, 30, 3, 4, Resources.LOTS_OF_WATER, Resources.DESERT, 30, 0),
    Furs	  (0, 0, 0, 250, 10, 10, Resources.RICH_FAUNA, Resources.LIFELESS, 230	, 280),
    Food	  (1, 0, 1, 100, 5, 5, Resources.RICH_SOIL, Resources.POOR_SOIL, 90, 160),
    Ore	  (2, 2, 3, 350, 20, 10, Resources.MINERAL_RICH, Resources.MINERAL_POOR, 350, 420),
    Games	  (3, 1, 6, 250	, -10,  5, Resources.ARTISTIC, null, 160, 270),
    Firearms	  (3, 1, 5, 1250, -75, 100, Resources.WARLIKE, null, 600, 1100),
    Medicine	  (4, 1, 6, 650, -20, 10, Resources.LOTS_OF_HERBS, null, 400, 700),
    Machines	  (4, 3, 5, 900,	-30, 5, null, null, 600, 0),
    Narcotics	  (5, 0, 5, 3500, -125, 150,  Resources.WEIRD_MUSHROOMS, null, 2000, 3000),
    Robots	  (6, 4, 7, 5000, -150, 100, null, null, 3500, 5000);

    private final int MTLP;
    private final int MTLU;
    private final int TTP;
    private final int base_price;
    private final int IPL;
    private final int Var;
    private final Resources CR;
    private final Resources ER;
    private final int MTL;
    private final int MTH;

    TradeGoodType(int MTLP, int MTLU, int TTP, int base_price,	int IPL, int Var,
                Resources CR, Resources ER, int MTL, int MTH) {
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.TTP = TTP;
        this.base_price = base_price;
        this.IPL = IPL;
        this.Var = Var;
        this.CR = CR;
        this.ER = ER;
        this.MTL = MTL;
        this.MTH = MTH;

    }

    public int getMTLP() {
        return MTLP;
    }

    public int getMTLU() {
        return MTLU;
    }

    public int getTTP() {
        return TTP;
    }

    public int getBase_price() {
        return base_price;
    }

    public int getIPL() {
        return IPL;
    }

    public int getVar() {
        return Var;
    }

    public Resources getCR() {
        return CR;
    }

    public Resources getER() {
        return ER;
    }

    public int getMTL() {
        return MTL;
    }

    public int getMTH() {
        return MTH;
    }
}
