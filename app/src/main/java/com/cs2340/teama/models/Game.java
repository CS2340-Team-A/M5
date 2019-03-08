package com.cs2340.teama.models;

public class Game {
    private Universe universe;
    private Player player;

    public static Game game = null;


    public Game(Player p, Universe u) {
        this.player = p;
        this.universe = u;
    }

    public Player getPlayer() {
        return player;
    }

    public Universe getUniverse() {
        return universe;
    }
}
