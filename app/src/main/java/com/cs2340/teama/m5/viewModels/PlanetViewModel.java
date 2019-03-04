package com.cs2340.teama.m5.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.m5.models.Coordinates;
import com.cs2340.teama.m5.models.Game;
import com.cs2340.teama.m5.models.Planet;
import com.cs2340.teama.m5.models.SolarSystem;

public class PlanetViewModel extends ViewModel {


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
}
