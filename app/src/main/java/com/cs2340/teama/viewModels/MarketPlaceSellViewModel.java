package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Planet;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.SolarSystem;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.realm.PlayerModel;

import java.util.List;

import io.realm.Realm;

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
        List<TradeGood> goods = getPlayer().getShip().getCargoHold();
        for (TradeGood curGood : goods) {
            if (curGood.getGoodType() == goodName) {
                return curGood.getVolume();
            }
        }
        return 0;
    }

    /**
     * returns number of slots available in the cargohold
     * @return
     */
    public String getCargoSpace() {
        return Integer.toString(getPlayer().getShip().getNumGoodsStored()) + " / " +
                Integer.toString(getPlayer().getShip().getShipType().getCargoSpace());
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

    public void sell(GoodType goodName) {
        List<TradeGood> goods = getPlayer().getShip().getCargoHold();
        for (final TradeGood curGood : goods) {
            if (curGood.getGoodType() == goodName) {
                if (getPlayer().canSell(curGood)) {
                    getPlayer().getShip().removeFromCargoHold(new TradeGood(0,
                            curGood.getGoodType(), 1));
                    List<TradeGood> gs = getPlanetGoodsList();
                    for (final TradeGood cG : gs) {
                        if(cG.getGoodType() == goodName) {
                            getPlayer().incrementCredits(cG);

                            Realm realm = Realm.getDefaultInstance();
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    PlayerModel playerModel = realm.where(PlayerModel.class).findFirst();
                                    if (playerModel != null) {
                                        playerModel.incrementCredits(cG.getValue());
                                        playerModel.getShip().
                                                removeFromCargoHold(
                                                        curGood.getGoodType().toString(),
                                                        1
                                                );
                                    }
                                }
                            });
                            realm.close();
                        }
                    }
                }
            }
        }
    }
}
