package com.cs2340.teama.m5.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.m5.models.Coordinates;
import com.cs2340.teama.m5.models.Game;
import com.cs2340.teama.m5.models.SolarSystem;

public class PlanetViewModel extends ViewModel {


    public CharSequence getPlanetName() {
        Coordinates planetCoords = Game.game.getPlayer().getCoordinates();
        SolarSystem s = SolarSystem.findSolarSystemByCoords(
                Game.game.getUniverse().getSolarSystems(), planetCoords);
        return s.getName();
    }
}
