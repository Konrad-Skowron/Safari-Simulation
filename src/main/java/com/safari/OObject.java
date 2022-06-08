package com.safari;

public abstract class OObject {
    private int x;
    private int y;
    private char prev;

    public OObject(int x, int y, char prev) {
        this.x = x;
        this.y = y;
        this.prev = prev;
    }

    protected OObject() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public char getPrev() {
        return prev;
    }

    public void setPrev(char prev) {
        this.prev = prev;
    }
}
