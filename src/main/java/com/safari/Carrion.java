package com.safari;

public class Carrion extends OObject{

    private static int idCountC;
    private int durability;                             //"wytrwałość" truchła

    Carrion(int x, int y, char prev){
        super(x, y, prev);
        this.durability = 100;
        idCountC++;
    }

    protected void setDurability(int durabity) {
        this.durability = durabity;
    }

    public int getDurability() {
        return durability;
    }
}