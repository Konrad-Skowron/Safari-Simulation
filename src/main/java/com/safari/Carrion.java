package com.safari;

public class Carrion extends OObject{

    private  static int id;
    private int durabity;
    public char prev;

    Carrion(int x, int y, char prev){
        this.durabity = 100;
        this.x = x;
        this.y = y;
        this.prev = prev;
        id++;
    }

    public int getId() {
        return id;
    }


    public void setDurabity(int durabity) {
        this.durabity = durabity;
    }

    public int getDurabity() {
        return durabity;
    }
}