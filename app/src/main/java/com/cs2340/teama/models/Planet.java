package com.cs2340.teama.models;

import android.util.Log;

import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.enums.TechLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Planet {
    private String name;
    private String planetInfo;
    private TechLevel tLv;
    private List<TradeGood> tradeGoods;
    private Random random = new Random();
    Planet(String name) {
        this.name = name;
        int lv = (int)(random.nextDouble() * 8);
        for(TechLevel tl: TechLevel.values()) {
            if(tl.getTechLv() == lv) {
                this.tLv = tl;
                break;
            }
        }
        this.planetInfo = "Generic Planet Info: \n"
                + "\nThis planet exists and the player is probably on it"
                + "\nThis planet is at the " + tLv + " age with technological level of "
                + tLv.getTechLv();
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

                tradeGoods.add(new TradeGood(price, good));
            }
        }
    }

    @Override
    public String toString() {
        return "Planet: " + this.name + "\n" + planetInfo;
    }

    /** Getters **/
    public String getName() {
        return name;
    }

    public String getInfo() {
        return planetInfo;
    }

    public TechLevel getTLv() {
        return tLv;
    }

    public List<TradeGood> getTradeGoods() {
        return this.tradeGoods;
    }
}
