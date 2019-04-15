package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.cs2340.teama.models.Coordinates;
import com.cs2340.teama.models.Game;
import com.cs2340.teama.models.Planet;
import com.cs2340.teama.models.Ship;
import com.cs2340.teama.models.SolarSystem;
import com.cs2340.teama.models.realm.PlayerModel;
import com.cs2340.teama.models.realm.ShipModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * ViewModel containing business logic for the TravelActivity
 */
public class TravelViewModel extends ViewModel {

    private final Game game = Game.getInstance();

    private Planet getPlanet() {
        return game.getPlanet();
    }

    /**
     * @return the planets information
     */
    public CharSequence getPlanetInfo() {
        return game.getPlanetInfo();
    }

    /**
     * @return the ship
     */
    public Ship getShip() {
        return game.getShip();
    }

    /**
     * @return ship's fuel level
     */
    public double getShipFuel() {
        return game.getShipFuel();
    }
    /**
     * @return ship's fuel capacity
     */
    public double getShipFuelCapacity() {
        return game.getShipFuelCapacity();
    }

    /**
     * Gets a list of reachable planets
     * @return List of Reachable Planets*/
    public List<Planet> getPlanetList(){
        List<Planet> reachablePlanets = new ArrayList<>();
        Coordinates playerCoords = game.getPlayerCoordinates();
        double distToPlanet;
        Ship ship = game.getShip();
        for (SolarSystem system : game.getSolarSystems()) {

            distToPlanet = Coordinates.distTo(playerCoords, system.getCoordinates());
            if (game.canTravelDist(distToPlanet)) {
                reachablePlanets.add(system.getPlanet());
            }

        }
        return reachablePlanets;
    }

    /**
     * Gets a list of reachable planets
     * @return List of Reachable Planets
     */
    public List<String> getPlanetNameList() {
        List<String> reachablePlanets = new ArrayList<>();
        Coordinates playerCoords = game.getPlayerCoordinates();
        double distToPlanet;
        Ship ship = game.getShip();
        for (SolarSystem system : game.getSolarSystems()) {

            distToPlanet = Coordinates.distTo(playerCoords, system.getCoordinates());
            if (game.canTravelDist(distToPlanet)) {
                reachablePlanets.add(system.getName());
            }

        }
        return reachablePlanets;
    }

    /**
     * @return list containing all solar systems
     */
    private List<SolarSystem> getSolarSystems() {
        List<SolarSystem> reachableSystems = new ArrayList<>();
        Coordinates playerCoords = game.getPlayerCoordinates();
        double distToPlanet;
        Ship ship = game.getShip();
        for (SolarSystem system : game.getSolarSystems()) {

            distToPlanet = Coordinates.distTo(playerCoords, system.getCoordinates());
            if (game.canTravelDist(distToPlanet)) {
                reachableSystems.add(system);
            }

        }
        return reachableSystems;
    }

    /**
     * @param planetPos destination planet
     */
    public void travelTo(int planetPos) {
        Planet planet = this.getPlanetList().get(planetPos);
        Log.d("Edit", "Got planet " + planet);

        final SolarSystem system = this.getSolarSystems().get(planetPos);
        final Coordinates destCoord = system.getCoordinates();

        game.travel(destCoord);

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                PlayerModel playerModel = realm.where(PlayerModel.class).findFirst();
                if (playerModel != null) {
                    ShipModel shipModel = playerModel.getShip();
                    shipModel.removeFuel(Coordinates.distTo(
                            playerModel.getCoordinates(),
                            destCoord
                    ) / Ship.FUEL_EFFICIENCY);
                    playerModel.setCoordinates(system.getXCoordinates(), system.getYCoordinates());
                }
            }
        });
        realm.close();
    }
}
