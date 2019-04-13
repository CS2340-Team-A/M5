package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Planet;

public class PlanetViewModel extends ViewModel {

    private final Game game = Game.getInstance();

    private Planet getPlanet() {
        return game.getPlanet();
    }

    public CharSequence getPlanetName() {
        return this.getPlanet().getName();
    }

    public CharSequence getPlanetInfo() {
        return this.getPlanet().getInfo();
    }

    public int getPlanetID() {
        return this.getPlanet().getId();
    }



}
