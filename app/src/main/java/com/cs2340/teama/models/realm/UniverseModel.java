package com.cs2340.teama.models.realm;

import com.cs2340.teama.models.SolarSystem;
import com.cs2340.teama.models.Universe;

import java.util.Collections;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * A Realm object that stores the information of the Universe
 */
public class UniverseModel extends RealmObject {

    private RealmList<SolarSystemModel> solarSystems;
    /**
     * Constructor
     */
    public UniverseModel() {
    }
    /**
     * @param universe whose data is to be stored
     */
    public UniverseModel(Universe universe) {
        this.solarSystems = new RealmList<>();
        for (SolarSystem solarSystem: universe.getSolarSystems()) {
            solarSystems.add(new SolarSystemModel(solarSystem));
        }
    }


    /**
     * @return solar systems
     */
    public List<SolarSystemModel> getSolarSystems() {
        return Collections.unmodifiableList(solarSystems);
    }

    /**
     * @param solarSystems to be stored
     */
    public void setSolarSystems(RealmList<SolarSystemModel> solarSystems) {
        this.solarSystems = solarSystems;
    }

}
