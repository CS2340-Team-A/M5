package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.SolarSystem;
import com.cs2340.teama.models.TradeGood;

import java.util.Collections;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * A Realm object that stores the information of the SolarSystem
 */
public class SolarSystemModel extends RealmObject {

    private String name;

    private int xCoords;
    private int yCoords;
    private String techLevel;
    private String resourcesName;
    private RealmList<TradeGoodModel> tradeGoods;

    /**
     * Constructor
     */
    public SolarSystemModel() {
    }
    /**
     * @param solarSystem whose data is to be stored
     */
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


    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return xCoords
     */
    public int getXCoords() {
        return xCoords;
    }

    /**
     * @return yCoords
     */
    public int getYCoords() {
        return yCoords;
    }

    /**
     * @return techLevel
     */
    public String getTechLevel() {
        return techLevel;
    }

    /**
     * @return resourcesName
     */
    public String getResourcesName() {
        return resourcesName;
    }

    /**
     * @return list pf trade goods
     */
    public List<TradeGoodModel> getTradeGoods() {
        return Collections.unmodifiableList(this.tradeGoods);
    }
}


