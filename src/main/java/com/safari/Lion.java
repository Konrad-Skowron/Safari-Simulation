package com.safari;

import java.util.Random;

public class Lion extends Animal {

    private static int idCountL;
    private int damage;

    public Lion() {
        super();
        idCountL++;
        setName("Lion-" + idCountL);
        setSpeed(2);
        damage = new Random().nextInt(10)+35;
        setFoodPerRound((new Random().nextInt(2)+1));
        setWaterPerRound((new Random().nextInt(2)+1));
    }

    protected void attack(Animal target){           //Unikalna metoda dla Lwa pozwalająca zaatakowac Hipopotama
        target.setHp(target.getHp() - damage);
        setFood(getFood()+damage);
    }

}