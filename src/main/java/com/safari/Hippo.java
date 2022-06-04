package com.safari;
public class Hippo extends Animal {

    int i = 1;

    public Hippo() {
        name = "Hippo-" + i;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 1;
        i++;
    }
    public Hippo(int x, int y) {
        name = "Hippo-" + i;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 1;
        this.x = x;
        this.y = y;
        i++;
    }


}