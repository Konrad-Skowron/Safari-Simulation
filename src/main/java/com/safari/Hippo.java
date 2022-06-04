package com.safari;
public class Hippo extends Animal {

    static int id = 1;

    public Hippo() {
        name = "Hippo-" + id;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 1;
        id++;
    }
    public Hippo(int x, int y) {
        name = "Hippo-" + id;
        sex = sexR();
        food = 100;
        water = 100;
        hp = 200;
        speed = 1;
        this.x = x;
        this.y = y;
        id++;
    }


}