package com.safari;

import java.util.Random;

public class Vulture extends Animal {
    private static int id;

    public Vulture() {
        super();
        setName("Vulture-" + id);
        setSpeed(2);
        setFoodPerRound(new Random().nextInt(2)+1);
        setWaterPerRound(new Random().nextInt(2)+1);
        id++;
    }
}