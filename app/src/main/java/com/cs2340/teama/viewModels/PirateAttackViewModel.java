package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.realm.PlayerModel;

import java.util.List;

import io.realm.Realm;

public class PirateAttackViewModel extends ViewModel {

    public void pillage() {
        List<TradeGood> goods = getPlayer().getShip().getCargoHold();
        for (final TradeGood curGood : goods) {
            if (getPlayer().canSell(curGood)) {
                getPlayer().getShip().removeFromCargoHold(new TradeGood(0,
                        curGood.getGoodType(), 1));
                Realm realm = Realm.getDefaultInstance();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        PlayerModel playerModel = realm.where(PlayerModel.class).findFirst();
                        if (playerModel != null) {
                            playerModel.getShip().removeFromCargoHold(
                                    curGood.getGoodType().toString(), 1
                            );
                        }
                    }
                });
            }
        }
    }

    private Player getPlayer(){
        return Game.game.getPlayer();
    }
}
