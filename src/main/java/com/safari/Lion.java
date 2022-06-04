package com.safari;

public class Lion extends Animal {

    static int id = 1;
    int damage = 20;

    public Lion() {
        name = "Lion-" + id;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 2;
        id++;
    }

    public Lion(int x, int y) {
        name = "Lion-" + id;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 2;
        this.x = x;
        this.y = y;
        id++;
    }
}