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

public class MarketPlaceBuyViewModel extends ViewModel {

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

    public int getGoodVolume(GoodType goodName) {
        List<TradeGood> goods = getPlanetGoodsList();
        for (TradeGood curGood : goods) {
            if (curGood.getGoodType() == goodName) {
                return curGood.getVolume();
            }
        }
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



    public void purchase(GoodType goodName) {
        List<TradeGood> goods = getPlanetGoodsList();
        for (TradeGood curGood : goods) {
            if (curGood.getGoodType() == goodName) {
                if (getPlayer().canBuy(curGood) && curGood.inStock()) {
                    curGood.decrementVolume();
                    getPlayer().decrementCredits(curGood);
                }
            }
        }
    }
}
