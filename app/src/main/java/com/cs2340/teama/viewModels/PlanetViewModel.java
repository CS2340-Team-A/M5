package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Planet;
import com.cs2340.teama.models.TradeGood;

import java.util.List;

public class PlanetViewModel extends ViewModel {


    private Planet getPlanet() {
        return Game.game.getPlanet();
    }

    public CharSequence getPlanetName() {
        return this.getPlanet().getName();
    }

    public CharSequence getPlanetInfo() {
        return this.getPlanet().getInfo();
    }

}
