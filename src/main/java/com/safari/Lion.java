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
        setFoodPerRound((new Random().nextInt(4)+1) * getSpeed());
        setWaterPerRound((new Random().nextInt(3)+1) * getSpeed());
        idCountL++;
    }

    protected void attack(Animal target){           //unikalna metoda dla Lwa pozwalająca zaatakowac Hipopotama
        target.setHp(target.getHp() - damage);
    }
}