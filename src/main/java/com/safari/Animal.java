package com.safari;

import java.util.Random;

public abstract class Animal extends OObject{

    private String name;
    private int food;
    private int water;
    private int hp;
    private int speed;
    private int foodPerRound;
    private int waterPerRound;


    public Animal() {
        food = 100;
        water = 100;
        hp = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setFoodPerRound(int foodPerRound) {
        this.foodPerRound = foodPerRound;
    }

    public void setWaterPerRound(int waterPerRound) {
        this.waterPerRound = waterPerRound;
    }

    public void move() {
        int direction = new Random().nextInt(8);
        switch (direction) {
            case 0:
                setY(getY() - speed);
                break;
            case 1:
                setX(getX() + speed);
                break;
            case 2:
                setY(getY() + speed);
                break;
            case 3:
                setX(getX() - speed);
                break;
            case 4:
                setY(getY() - speed);
                setX(getX() - speed);
                break;
            case 5:
                setY(getY() - speed);
                setX(getX() + speed);
                break;
            case 6:
                setY(getY() + speed);
                setX(getX() - speed);
                break;
            case 7:
                setY(getY() + speed);
                setX(getX() + speed);
                break;
        }
    }

    public void drink(){
        water += waterPerRound;
        if (water > 100) water = 100;
    }

    public void eat(){
        food += foodPerRound;
        if (food > 100) food = 100;
    }

    public void hp(){
        if (food <= 0 )
            hp -= 10;
        if (water <= 0 )
            hp -= 10;
    }
}