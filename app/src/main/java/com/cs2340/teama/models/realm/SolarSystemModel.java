package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.SolarSystem;
import com.cs2340.teama.models.TradeGood;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SolarSystemModel extends RealmObject {

    private String name;

    private int xCoords;
    private int yCoords;
    private String techLevel;
    private String resourcesName;
    private RealmList<TradeGoodModel> tradeGoods;

    public SolarSystemModel() {}

    public SolarSystemModel(SolarSystem solarSystem) {
        this.name = solarSystem.getName();
        this.xCoords = solarSystem.getCoordinates().getX();
        this.yCoords = solarSystem.getCoordinates().getY();
        this.techLevel = solarSystem.getPlanet().getTLv().toString();
        this.resourcesName = solarSystem.getPlanet().getResources().toString();
        this.tradeGoods = new RealmList<>();
        for (TradeGood tradeGood: solarSystem.getPlanet().getTradeGoods()) {
            tradeGoods.add(new TradeGoodModel(tradeGood));
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(int x, int y) {
        this.xCoords = x;
        this.yCoords = y;
    }
}


