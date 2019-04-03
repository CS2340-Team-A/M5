package com.cs2340.teama;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("spacetraders.realm").build();
        Realm.setDefaultConfiguration(config);
    }

}
