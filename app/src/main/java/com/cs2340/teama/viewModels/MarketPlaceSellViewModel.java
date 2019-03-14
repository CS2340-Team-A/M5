package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Planet;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.SolarSystem;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.enums.GoodType;

import java.util.List;

/**
 * TODO: implement getGoodVolume
 * TODO: implement getCargoHoldSpaceAvailable
 */
public class MarketPlaceSellViewModel extends ViewModel {

    private Planet getPlanet() {
        Coordinates planetCoords = Game.game.getPlayer().getCoordinates();
        SolarSystem s = SolarSystem.findSolarSystemByCoords(
                Game.game.getUniverse().getSolarSystems(), planetCoords);
        return s.getPlanet();
    }

    private Player getPlayer(){
        return Game.game.getPlayer();
    }

    public List<TradeGood> getPlanetGoodsList() {
        return this.getPlanet().getTradeGoods();
    }

    /**
     * returns the quantity of the good present in the ship's cargohold
     * @param goodName
     * @return
     */
    public int getGoodVolume(GoodType goodName) {
        return 0;
    }

    /**
     * returns number of slots available in the cargohold
     * @return
     */
    public int getCargoHoldSpaceAvailable(){
        return 0;
    }

    public double getGoodValue(GoodType goodName) {
        List<TradeGood> goods = getPlanetGoodsList();
        for (TradeGood curGood : goods) {
            if (curGood.getGoodType() == goodName) {
                return curGood.getValue();
            }
        }
        return 0;
    }

    public int getPlayerCredits() {
        return getPlayer().getCredits();
    }
}
