package com.cs2340.teama.viewModels;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class TravelAnimationViewModel extends ViewModel {

    public boolean pirateAttack() {
        Random rand = new Random();
        int a = rand.nextInt(100);
        Log.d("Edit", "Random value: " + Integer.toString(a));
        int ATTACK_PROBABILITY = 10;
        return a < ATTACK_PROBABILITY;
    }
}
