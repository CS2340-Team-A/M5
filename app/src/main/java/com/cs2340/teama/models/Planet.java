package com.cs2340.teama.models;

import android.util.Log;

import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.enums.Resources;
import com.cs2340.teama.models.enums.TechLevel;
import com.cs2340.teama.models.realm.SolarSystemModel;
import com.cs2340.teama.models.realm.TradeGoodModel;

import java.util.ArrayList;
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
    private final int PRODUCTION_FACTOR = 70;
    private final int RESOURCE_QUANTITIY_FACTOR = 4;
    private final int TTP_QUANTITY_FACTOR = 5;
    private String name;
    private TechLevel tLv;
    private Resources resources;
    private List<TradeGood> tradeGoods;
    private Random random = new Random();

    public Planet(SolarSystemModel ssm) {
        this.name = ssm.getName();
        this.resources = Resources.valueOf(ssm.getResourcesName());
        this.tLv = TechLevel.valueOf(ssm.getTechLevel());
        this.tradeGoods = new ArrayList<>();
        for (TradeGoodModel tgm: ssm.getTradeGoods()) {
            this.tradeGoods.add(new TradeGood(tgm));
        }
    }

    Planet(String name, Resources res, TechLevel techLevel) {
        this.resources = res;
        this.name = name;
        this.tLv = techLevel;

        //here probably call to a tradeGoods factory
        tradeGoods = new ArrayList<>();
        for(GoodType good: GoodType.values()) {
            if(good.getMTLP() <= tLv.getTechLv() || good.getMTLU() <= tLv.getTechLv()) {
                boolean addVariance = random.nextDouble() < 0.5;
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
                int quantity = (int)(random.nextDouble() * PRODUCTION_FACTOR)
                        - RESOURCE_QUANTITIY_FACTOR*Math.abs(good.getTTP() - tLv.getTechLv());
                while(quantity <= 1) {
                    quantity = (int)(random.nextDouble() * PRODUCTION_FACTOR)
                            - TTP_QUANTITY_FACTOR*Math.abs(good.getTTP() - tLv.getTechLv());
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

    @Override
    public String toString() {
        return "Planet: " + this.name + "\n" + getInfo();
    }

    /** Getters **/
    public String getName() {
        return name;
    }

    public String getInfo() {
        return "Planet Info: \n"
                + "Name: " + name + "\n"
                + name + " has the following resource: " + resources.toString()
                + "\nIt is at the " + tLv + " age with technological level of "
                + tLv.getTechLv();
    }

    public TechLevel getTLv() {
        return tLv;
    }

    public Resources getResources() {
        return resources;
    }

    public List<TradeGood> getTradeGoods() {
        return this.tradeGoods;
    }
}
