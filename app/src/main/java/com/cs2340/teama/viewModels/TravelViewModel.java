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

public class TravelViewModel extends ViewModel {

    private Planet getPlanet() {
        return Game.game.getPlanet();
    }

    public CharSequence getPlanetName() {
        return this.getPlanet().getName();
    }

    public CharSequence getPlanetInfo() {
        return this.getPlanet().getInfo();
    }

    public Ship getShip() {
        return Game.game.getPlayer().getShip();
    }

    /**
     * Gets a list of reachable planets
     * @return List of Reachable Planets*/
    public List<Planet> getPlanetList(){
        List<Planet> reachablePlanets = new ArrayList<Planet>();
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

    /**
     * Gets a list of reachable planets
     * @return List of Reachable Planets*/
    public List<String> getPlanetNameList() {
        List<String> reachablePlanets = new ArrayList<String>();
        Coordinates playerCoords = Game.game.getPlayer().getCoordinates();
        double distToPlanet;
        Ship ship = Game.game.getPlayer().getShip();
        for (SolarSystem system : Game.game.getUniverse().getSolarSystems()) {

            distToPlanet = Coordinates.distTo(playerCoords, system.getCoordinates());
            if (ship.canTravelDist(distToPlanet)) {
                reachablePlanets.add(system.getPlanet().getName());
            }

        }
        return reachablePlanets;
    }

    private List<SolarSystem> getSolarSystems() {
        List<SolarSystem> reachableSystems = new ArrayList<SolarSystem>();
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

    public void travelTo(int planetPos) {
        Planet planet = this.getPlanetList().get(planetPos);
        Log.d("Edit", "Got planet " + planet);

        SolarSystem system = this.getSolarSystems().get(planetPos);
        Coordinates destCoord = system.getCoordinates();

        Game.game.getPlayer().travel(destCoord);

    }
}
