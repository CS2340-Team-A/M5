package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.Universe;
import com.cs2340.teama.models.realm.PlayerModel;
import com.cs2340.teama.models.realm.UniverseModel;

import io.realm.Realm;

public class ConfigViewModel extends ViewModel {

    public void addPlayerUniverse(final Player p, final Universe u){
        if (Game.game == null) {
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    PlayerModel stagedPlayer = new PlayerModel(p);
                    UniverseModel stagedUniverse = new UniverseModel(u);
                    realm.copyToRealm(stagedPlayer);
                    realm.copyToRealm(stagedUniverse);
                }
            });
            realm.close();
            Game.game = new Game(p, u);
        }
    }

    public boolean calculatePoints(int p, int f, int e, int t) {
        return (p + f + e + t) != 16;
    }
}
