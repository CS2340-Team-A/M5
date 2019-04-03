package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.SolarSystem;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UniverseModel extends RealmObject {

    @PrimaryKey
    private int id;

    private RealmList<SolarSystemModel> solarSystems;

    public RealmList<SolarSystemModel> getSolarSystems() {
        return solarSystems;
    }

    public void setSolarSystems(RealmList<SolarSystemModel> solarSystems) {
        this.solarSystems = solarSystems;
    }
}
