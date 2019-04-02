package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.TradeGood;

import java.util.List;

public class PirateAttackViewModel extends ViewModel {

    public void pillage() {
        List<TradeGood> goods = getPlayer().getShip().getCargoHold();
        for (TradeGood curGood : goods) {
            if (getPlayer().canSell(curGood)) {
                getPlayer().getShip().removeFromCargoHold(new TradeGood(0,
                        curGood.getGoodType(), 1));
            }
        }
    }

    private Player getPlayer(){
        return Game.game.getPlayer();
    }
}
