package com.safari;

public class Lion extends Animal {

    int i = 1;
    int damage = 20;

    public Lion() {
        name = "Lion-" + i;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 2;
        i++;
    }

    public Lion(int x, int y) {
        name = "Lion-" + i;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 2;
        this.x = x;
        this.y = y;
        i++;
    }
}