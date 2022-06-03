package com.safari;

import java.util.Random;

public abstract class Animal {

    String name;
    char sex;
    int food;
    int water;
    int hp;
    int speed;
    int x;
    int y;
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

    public char sexR(){
        if(new Random().nextInt(2) == 1){
            return 'F';
        }
        else return 'M';
    }

    public String getName() {
        return name;
    }
}