package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Planet;

/**
 * ViewModel containing business logic for the PlanetActivity
 */
public class PlanetViewModel extends ViewModel {

    private final Game game = Game.getInstance();

    private Planet getPlanet() {
        return game.getPlanet();
    }

    /**
     * @return planet
     */
    public CharSequence getPlanetName() {
        return game.getPlanetName();
    }

    /**
     * @return planet's infor
     */
    public CharSequence getPlanetInfo() {
        return game.getPlanetInfo();
    }

    /**
     * @return planet's unique id
     */
    public int getPlanetID() {
        return game.getPlanetId();
    }



}
