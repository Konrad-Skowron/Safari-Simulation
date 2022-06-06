package com.safari;

import java.util.Random;

public class Vulture extends Animal {
    private static int id;

    public Vulture() {
        super();
        name = "Vulture-" + id;
        speed = 3;
        foodPerRound = new Random().nextInt(2)+1;;
        waterPerRound = new Random().nextInt(2)+1;
        id++;
    }

    public Vulture(int x, int y) {
        super();
        name = "Vulture-" + id;
        speed = 3;
        foodPerRound = new Random().nextInt(2)+1;;
        waterPerRound = new Random().nextInt(2)+1;
        id++;
    }
}