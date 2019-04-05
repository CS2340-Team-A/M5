package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Planet;
import com.cs2340.teama.models.Ship;
import com.cs2340.teama.models.SolarSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TravelAnimationViewModel extends ViewModel {


    public boolean pirateAttack() {
        Random rand = new Random();
        int a = rand.nextInt(100);
        Log.d("Edit", "Random value: " + Integer.toString(a));
        int ATTACK_PROBABILITY = 10;
        return a < ATTACK_PROBABILITY;
    }

    private Planet getPlanet() {
        return Game.game.getPlanet();
    }

    /**
     * Gets a list of reachable planets
     * @return List of Reachable Planets*/
    public List<Planet> getPlanetList(){
        List<Planet> reachablePlanets = new ArrayList<>();
        Coordinates playerCoords = Game.game.getPlayer().getCoordinates();
        double distToPlanet;
        Ship ship = Game.game.getPlayer().getShip();
        for (SolarSystem system : Game.game.getUniverse().getSolarSystems()) {

            distToPlanet = Coordinates.distTo(playerCoords, system.getCoordinates());
            if (ship.canTravelDist(distToPlanet)) {
                reachablePlanets.add(system.getPlanet());
            }

        }
        return reachablePlanets;
    }

    private List<SolarSystem> getSolarSystems() {
        List<SolarSystem> reachableSystems = new ArrayList<>();
        Coordinates playerCoords = Game.game.getPlayer().getCoordinates();
        double distToPlanet;
        Ship ship = Game.game.getPlayer().getShip();
        for (SolarSystem system : Game.game.getUniverse().getSolarSystems()) {

            distToPlanet = Coordinates.distTo(playerCoords, system.getCoordinates());
            if (ship.canTravelDist(distToPlanet)) {
                reachableSystems.add(system);
            }

        }
        return reachableSystems;
    }
}
