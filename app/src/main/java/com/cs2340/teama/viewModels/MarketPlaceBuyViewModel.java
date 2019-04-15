package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.SolarSystem;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.enums.GoodType;
import com.cs2340.teama.models.realm.PlayerModel;
import com.cs2340.teama.models.realm.TradeGoodModel;

import java.util.List;

import io.realm.Realm;

/**
 * ViewModel containing business logic for the MarketPlaceBuyActivity
 */
public class MarketPlaceBuyViewModel extends ViewModel {

    private final Game game = Game.getInstance();

//    private Planet getPlanet() {
//        Coordinates planetCoords = game.getPlayerCoordinates();
//        return SolarSystem.findSolarSystemPlanetByCoords(
//                game.getUniverse().getSolarSystems(), planetCoords);
//    }

//    private Player getPlayer(){
//        return game.getPlayer();
//    }

    private List<TradeGood> getPlanetGoodsList() {
        Coordinates planetCoords = game.getPlayerCoordinates();
        return SolarSystem.findSolarSystemPlanetGoodsListByCoords(
                game.getSolarSystems(), planetCoords);
    }

    /**
     * @param goodName good specefied
     * @return good's volume
     */
    public int getGoodVolume(GoodType goodName) {
        List<TradeGood> goods = getPlanetGoodsList();
        for (TradeGood curGood : goods) {
            if (curGood.getGoodType() == goodName) {
                return curGood.getVolume();
            }
        }
        return 0;
    }

    /**
     * @param goodName good specified
     * @return good's volume
     */
    public double getGoodValue(GoodType goodName) {
        List<TradeGood> goods = getPlanetGoodsList();
        for (TradeGood curGood : goods) {
            if (curGood.getGoodType() == goodName) {
                return curGood.getValue();
            }
        }
        return 0;
    }

    /**
     * @return player credits
     */
    public int getPlayerCredits() {
        return game.getPlayerCredits();
    }

    /**
     * @return cargo space
     */
    public String getCargoSpace() {
        return Integer.toString(game.getNumGoodsStored()) + " / " +
                Integer.toString(game.getCargoSpace());

    }

    /**
     * @param goodName good being purchased
     */
    public void purchase(GoodType goodName) {
        List<TradeGood> goods = getPlanetGoodsList();
        for (final TradeGood curGood : goods) {
            if (curGood.getGoodType() == goodName) {
                if (game.canBuy(curGood) && curGood.inStock()) {
                    boolean wasSuccessful = game.addToPlayerCargoHold(new TradeGood(0,
                            curGood.getGoodType(), 1));
                    if(wasSuccessful) {
                        curGood.decrementVolume(1);
                        game.decrementPlayerCredits(curGood);

                        Realm realm = Realm.getDefaultInstance();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                TradeGoodModel tgm = realm.where(TradeGoodModel.class)
                                        .equalTo("system.name", game.getPlanetName())
                                        .equalTo("type", curGood.getGoodType().toString())
                                        .findFirst();
                                if (tgm != null) {
                                    tgm.decrementQuantity();
                                }
                                PlayerModel playerModel = realm
                                        .where(PlayerModel.class).findFirst();
                                if (playerModel != null) {
                                    playerModel.decrementCredits(tgm);
                                    playerModel.addToShipCargoHold(
                                            curGood.getGoodType().toString(),
                                            1
                                    );
                                }
                            }
                        });
                        realm.close();
                    } else  {
                        Log.d("Debug", "Unsuccessful purchase because cargo hold is full");
                    }
                }
            }
        }
    }
}
