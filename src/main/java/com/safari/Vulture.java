package com.safari;

public class Vulture extends Animal {

    int i = 1;

    public Vulture() {
        name = "Vulture-" + i;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 1;
        i++;
    }

    public Vulture(int x, int y) {
        name = "Vulture-" + i;
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