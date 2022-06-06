package com.safari;

import java.util.Random;

public class Hippo extends Animal {

    private static int id;

    public Hippo() {
        super();
        name = "Hippo-" + id;
        speed = 1;
        foodPerRound = new Random().nextInt(3)+1;;
        waterPerRound = new Random().nextInt(5)+1;
        id++;
    }

    public Hippo(int x, int y) {
        super();
        name = "Hippo-" + id;
        speed = 1;
        foodPerRound = new Random().nextInt(3)+1;;
        waterPerRound = new Random().nextInt(5)+1;
        id++;
    }


}