package com.safari;

import java.util.Random;

public abstract class Animal extends OObject{

    String name;
    private int food;
    private int water;
    int hp;
    int speed;
    int foodPerRound;
    int waterPerRound;
    char prev;

    public void move() {
        int direction = new Random().nextInt(8);
        switch (direction) {
            case 0:
                this.y -= speed;
                break;
            case 1:
                this.x += speed;
                break;
            case 2:
                this.y += speed;
                break;
            case 3:
                this.x -= speed;
                break;
            case 4:
                this.y -= speed;
                this.x -= speed;
                break;
            case 5:
                this.y -= speed;
                this.x += speed;
                break;
            case 6:
                this.y += speed;
                this.x -= speed;
                break;
            case 7:
                this.y += speed;
                this.x += speed;
                break;
        }
    }

    public Animal() {
        food = 100;
        water = 100;
        hp = 100;
    }

    public Animal(int x, int y) {
        food = 100;
        water = 100;
        hp = 100;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void drink(){
        water += waterPerRound;
        if (water > 100) water = 100;
    }

    public void eat(){
        water += foodPerRound;
        if (water > 100) water = 100;
    }

    public void hp(){
        if (food <= 0 )
            hp -= 10;
        if (water <= 0 )
            hp -= 10;
    }
}