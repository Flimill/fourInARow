package com.example.fourinarow;

public class Slot {
    int posX;
    int posY;

    boolean status;

    int belonging;

    public Slot(int x, int y, boolean status,int belonging) {
        this.posX = x;
        this.posY = y;
        this.status = status;
        this.belonging = belonging;
    }
}