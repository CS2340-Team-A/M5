package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.Universe;
import com.cs2340.teama.models.realm.PlayerModel;
import com.cs2340.teama.models.realm.UniverseModel;

import io.realm.Realm;

/**
 * ViewModel containing business logic for the ConfigActivity
 */
public class ConfigViewModel extends ViewModel {

    private static final int MIN_POINTS = 16;

    /**
     * @param p the player
     * @param u the universe
     */
    public void addPlayerUniverse(final Player p, final Universe u){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                realm.deleteAll();
                PlayerModel stagedPlayer = new PlayerModel(p);
                UniverseModel stagedUniverse = new UniverseModel(u);
                realm.copyToRealm(stagedPlayer);
                realm.copyToRealm(stagedUniverse);
            }
        });
        realm.close();
        Game.getInstance(p, u);
    }

    /**
     * @param p pilot points
     * @param f fighter points
     * @param e engineer points
     * @param t trader points
     * @return if points add up to 16
     */
    public boolean calculatePoints(int p, int f, int e, int t) {
        return (p + f + e + t) != ConfigViewModel.MIN_POINTS;
    }
}
