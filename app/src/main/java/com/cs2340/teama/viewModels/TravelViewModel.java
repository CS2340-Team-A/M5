package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Planet;
import com.cs2340.teama.models.SolarSystem;

import java.util.ArrayList;

public class TravelViewModel extends ViewModel {

    private Planet getPlanet() {
        Coordinates planetCoords = Game.game.getPlayer().getCoordinates();
        SolarSystem s = SolarSystem.findSolarSystemByCoords(
                Game.game.getUniverse().getSolarSystems(), planetCoords);
        return s.getPlanet();
    }

    public CharSequence getPlanetName() {
        return this.getPlanet().getName();
    }

    public CharSequence getPlanetInfo() {
        return this.getPlanet().getInfo();
    }

    public ArrayList<String> getPlanetList(){
        ArrayList<String> ret = new ArrayList<>();

        for (SolarSystem system : Game.game.getUniverse().getSolarSystems()) {
            ret.add(system.getName());
        }
        return ret;
    }
}
