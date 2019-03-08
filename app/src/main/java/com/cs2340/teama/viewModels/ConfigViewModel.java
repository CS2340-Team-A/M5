package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.Universe;

public class ConfigViewModel extends ViewModel {

    public void addPlayerUniverse(Player p, Universe u){
        if (Game.game == null) {
            Game.game = new Game(p, u);
        }
    }

    public boolean calculatePoints(int p, int f, int e, int t) {
        if ((p + f + e + t) != 16 || (p + f + e + t) > 16 ||
                (p + f + e + t) < 16) {
            return true;
        } else {
            return false;
        }
    }
}
