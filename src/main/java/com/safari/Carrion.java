package com.safari;

public class Carrion{
    public int id;
    public int time;
    public int x;
    public int y;

    int i=0;

    Carrion(int x, int y){
        i++;
        this.id = i;
        this.time = 10;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
