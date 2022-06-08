package com.safari;

import java.util.Random;

public class Hippo extends Animal {

    private static int idCountH;

    public Hippo() {
        super();
        setName("Hippo-" + idCountH);
        setSpeed(1);
        setFoodPerRound(new Random().nextInt(3)+1);
        setWaterPerRound(new Random().nextInt(5)+1);
        idCountH++;
    }
}