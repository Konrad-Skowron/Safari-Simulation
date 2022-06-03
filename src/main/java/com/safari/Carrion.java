package com.safari;

public class Carrion {

    public int id;
    public int time;
    public int x;
    public int y;
    public char prev;

    int i=0;

    Carrion(int x, int y, char prev){
        i++;
        this.id = i;
        this.time = 10;
        this.x = x;
        this.y = y;
        this.prev = prev;
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