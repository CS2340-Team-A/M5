package com.cs2340.teama.m5.viewModels;

import android.arch.lifecycle.ViewModel;

import com.cs2340.teama.m5.models.Player;

public class ConfigViewModel extends ViewModel {
    public void addPlayer(Player p){

    }
    public boolean calculatePoints(int p, int f, int e, int t) {
        if ((p + f + e + t) != 16 || (p + f + e + t) > 16 ||
                (p + f + e + t) < 16) {
            return true;
        } else {
            return false;
        }
    }
}
