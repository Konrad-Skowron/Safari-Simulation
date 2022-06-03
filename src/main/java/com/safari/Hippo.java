package com.safari;

import java.util.Random;

public class Hippo extends Animal {

    int i = 1;

    public Hippo(int size) {
        name = "hippo-" + i;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 5;
        x = new Random().nextInt(size);
        y = new Random().nextInt(size);
        i++;
    }
    public Hippo(int x, int y) {
        name = "hippo-" + i;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 5;
        this.x = x;
        this.y = y;
        i++;
    }
}
