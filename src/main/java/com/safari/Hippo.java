package com.safari;

import java.util.Random;

public class Hippo extends Animal {

    private static int idCountH;

    public Hippo() {
        super();
        idCountH++;
        setName("Hippo-" + idCountH);
        setSpeed(3);
        setFoodPerRound((new Random().nextInt(2)+1));
        setWaterPerRound((new Random().nextInt(4)+1));
    }

}