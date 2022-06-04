package com.safari;

public class Vulture extends Animal {

    static int id = 1;

    public Vulture() {
        name = "Vulture-" + id;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 1;
        id++;
    }

    public Vulture(int x, int y) {
        name = "Vulture-" + id;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 5;
        this.x = x;
        this.y = y;
        id++;
    }
}