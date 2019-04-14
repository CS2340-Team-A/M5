package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.SolarSystem;
import com.cs2340.teama.models.Universe;

import java.util.Collections;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class UniverseModel extends RealmObject {

    private RealmList<SolarSystemModel> solarSystems;

    public UniverseModel() {}
    public UniverseModel(Universe universe) {
        this.solarSystems = new RealmList<>();
        for (SolarSystem solarSystem: universe.getSolarSystems()) {
            solarSystems.add(new SolarSystemModel(solarSystem));
        }
    }


    public List<SolarSystemModel> getSolarSystems() {
        return Collections.unmodifiableList(solarSystems);
    }

    public void setSolarSystems(RealmList<SolarSystemModel> solarSystems) {
        this.solarSystems = solarSystems;
    }

}
