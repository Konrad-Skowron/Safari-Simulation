package com.safari;

public class Carrion extends OObject{

    private static int id;
    private int durabity;

    Carrion(int x, int y, char prev){
        super(x, y, prev);
        this.durabity = 100;
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