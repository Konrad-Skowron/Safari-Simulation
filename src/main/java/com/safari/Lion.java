package com.safari;

import java.util.Random;

public class Lion extends Animal {

    private static int id;
    private int damage;

    public Lion() {
        super();
        name = "Lion-" + id;
        speed = 2;
        damage = new Random().nextInt(10)+35;
        foodPerRound = new Random().nextInt(4)+1;;
        waterPerRound = new Random().nextInt(3)+1;
        id++;
    }

    public Lion(int x, int y) {
        super();
        name = "Vulture-" + id;
        speed = 2;
        foodPerRound = new Random().nextInt(4)+1;;
        waterPerRound = new Random().nextInt(3)+1;
        id++;
    }

    public void attack(Animal target){
        target.hp -= damage;
    }
}