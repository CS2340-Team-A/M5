package com.cs2340.teama.models;

import android.support.annotation.NonNull;

import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.enums.Resources;
import com.cs2340.teama.models.enums.TechLevel;
import com.cs2340.teama.models.realm.SolarSystemModel;
import com.cs2340.teama.models.realm.TradeGoodModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Planet is a possible location for a the player to be located on. It contians several attributes
 * that determine the price of goods that are sold in the Planet's marketplace.
 *
 * production factor - VALUE SHOULD BE ADJUSTED TO CHANGE THE OVERALL PRODUCTION ON ANY GIVEN PLANET
 * resourceQuantityAdjust - Factor that adjusts production of a given good in the scenario that the
 * resources of the planet
 * TTPQuantityAdjust - factor based on planet's tech level matching the optimal tech level for
 * production of the given good
 */
public class Planet {
    private final String name;
    private final TechLevel tLv;
    private final Resources resources;
    private final List<TradeGood> tradeGoods;
    private final int id;
    private static int count;
    private final int numberOfPlanetPictures = 7;
    private static final int PRODUCTION_FACTOR = 70;
    private static final double VARIANCE_THRESHOLD = 0.5;


    Planet(SolarSystemModel ssm) {
        this.name = ssm.getName();
        this.resources = Resources.valueOf(ssm.getResourcesName());
        this.tLv = TechLevel.valueOf(ssm.getTechLevel());
        this.tradeGoods = new ArrayList<>();
        this.id = count % numberOfPlanetPictures;
        incrementCount();
        for (TradeGoodModel tgm: ssm.getTradeGoods()) {
            this.tradeGoods.add(new TradeGood(tgm));
        }
    }

    Planet(String name, Resources res, TechLevel techLevel) {
        this.resources = res;
        this.name = name;
        this.tLv = techLevel;
        this.id = count % numberOfPlanetPictures;
        incrementCount();

        //here probably call to a tradeGoods factory
        tradeGoods = new ArrayList<>();
        for(GoodType good: GoodType.values()) {
            if((good.getMTLP() <= tLv.getTechLv()) || (good.getMTLU() <= tLv.getTechLv())) {
                Random random = new Random();
                boolean addVariance = random.nextDouble() < VARIANCE_THRESHOLD;
                int price = good.getBasePrice();

                if (good.getMTLP() > tLv.getTechLv()) {
                    price += good.getIPL() * (tLv.getTechLv()-good.getMTLU());
                } else {
                    price += good.getIPL() * (tLv.getTechLv()-good.getMTLP());
                }

                if (addVariance) {
                    double varianceFactor = (random.nextDouble() * (good.getVar() + 1));
                    price += good.getBasePrice() * varianceFactor;
                }
                int RESOURCE_QUANTITIY_FACTOR = 4;
                int quantity = (int) (random.nextDouble() * PRODUCTION_FACTOR)
                        - (RESOURCE_QUANTITIY_FACTOR * Math.abs(good.getTTP() - tLv.getTechLv()));
                while(quantity <= 1) {
                    int TTP_QUANTITY_FACTOR = 5;
                    quantity = (int) (random.nextDouble() * PRODUCTION_FACTOR)
                            - (TTP_QUANTITY_FACTOR * Math.abs(good.getTTP() - tLv.getTechLv()));
                }
                if(this.resources == good.getCR()) {
                    quantity *= RESOURCE_QUANTITIY_FACTOR;
                } else if(this.resources == good.getER()) {
                    quantity /= RESOURCE_QUANTITIY_FACTOR;
                }
                tradeGoods.add(new TradeGood(price, good, quantity));
            }
        }
    }

    /**
     * Increments counter for the number of Planets
     *
     */
    private static void incrementCount() {
        count++;
    }

    @NonNull
    @Override
    public String toString() {
        return "Planet: " + this.name + "\n" + getInfo();
    }

    /**
     * Method to get the planet's name
     *
     * @return name
     ***/
    public String getName() {
        return name;
    }

    /**
     * Method to get the planet's info in a string
     *
     * @return info
     */
    public String getInfo() {
        return "Planet Info: \n"
                + "Name: " + name + "\n"
                + name + " has the following resource: " + resources.toString()
                + "\nIt is at the " + tLv + " age with technological level of "
                + tLv.getTechLv();
    }

    /**
     * Method to get the planet's tech level
     *
     * @return techlevel
     */
    public TechLevel getTLv() {
        return tLv;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Method to get the Resources on the planet instance
     *
     * @return resources
     */
    public Resources getResources() {
        return resources;
    }

    /**
     * Method that gets the TradeGoods on a planet instance
     *
     * @return tradeGoods
     */
    public List<TradeGood> getTradeGoods() {
        return Collections.unmodifiableList(this.tradeGoods);
    }
}
