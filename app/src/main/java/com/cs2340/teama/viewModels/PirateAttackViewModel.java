package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.TradeGood;
import com.cs2340.teama.models.realm.PlayerModel;

import java.util.List;

import io.realm.Realm;

/**
 * ViewModel containing business logic for the PirateActivity
 */
public class PirateAttackViewModel extends ViewModel {

    private final Game game = Game.getInstance();

    /**
     * Decreases the quantity of every good a player has by one
     */
    public void pillage() {
        List<TradeGood> goods = game.getCargoHold();
        for (final TradeGood curGood : goods) {
            if (game.canSell(curGood)) {
                game.removeFromPlayerCargoHold(new TradeGood(0,
                        curGood.getGoodType(), 1));
                Realm realm = Realm.getDefaultInstance();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(@NonNull Realm realm) {
                        PlayerModel playerModel = realm.where(PlayerModel.class).findFirst();
                        if (playerModel != null) {
                            playerModel.removeFromCargoHold(
                                    curGood.getGoodType().toString(), 1
                            );
                        }
                    }
                });
            }
        }
    }

    private Player getPlayer(){
        return game.getPlayer();
    }
}
