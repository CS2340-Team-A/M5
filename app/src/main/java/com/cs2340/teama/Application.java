package com.cs2340.teama;

import android.util.Log;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Player;
import com.cs2340.teama.models.Universe;
import com.cs2340.teama.models.realm.PlayerModel;
import com.cs2340.teama.models.realm.UniverseModel;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("spacetraders.realm").build();
        Realm.setDefaultConfiguration(config);
        //Realm.deleteRealm(config);

        try (Realm realm = Realm.getDefaultInstance()) {
            PlayerModel playerModel = realm.where(PlayerModel.class).findFirst();
            UniverseModel universeModel = realm.where(UniverseModel.class).findFirst();
            if (playerModel != null && universeModel != null) {
                Player player = new Player(playerModel);
                Universe universe = new Universe(universeModel);
                Game.game = new Game(player, universe);
            }
        } catch (Exception e) {
            Log.e("Error Occured", e.toString());
        }
    }

}
