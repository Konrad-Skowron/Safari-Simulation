package com.safari;

import java.util.Random;

public class Lion extends Animal {

    private static int idCountL;
    private int damage;

    public Lion() {
        super();
        setName("Lion-" + idCountL);
        setSpeed(2);
        damage = new Random().nextInt(10)+35;
        setFoodPerRound(new Random().nextInt(4)+1);
        setWaterPerRound(new Random().nextInt(3)+1);
        idCountL++;
    }

    public void attack(Animal target){
        target.setHp(target.getHp() - damage);
    }
}