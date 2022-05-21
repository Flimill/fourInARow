package com.example.fourinarow;

import java.util.ArrayList;

public class Field {
    public class Slot { //private
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
    ArrayList<Slot> list1 = new ArrayList<Slot>();

    ArrayList<Slot> list2 = new ArrayList<Slot>();

    ArrayList<Slot> list3 = new ArrayList<Slot>();

    ArrayList<Slot> list4 = new ArrayList<Slot>();


    private Slot defaultSlot = new Slot(0,0,false,-1);
    private Slot slot11 = new Slot(1,1,true,-1);
    private Slot slot12 = new Slot(1,2, true,-1);
    private Slot slot13 = new Slot(1,3,true,-1);
    private Slot slot14 = new Slot(1,4,true,-1);


    private Slot slot21 = new Slot(2,1,true,-1);
    private Slot slot22 = new Slot(2,2, true,-1);
    private Slot slot23 = new Slot(2,3,true,-1);
    private Slot slot24 = new Slot(2,4,true,-1);

    private Slot slot31 = new Slot(3,1,true,-1);
    private Slot slot32 = new Slot(3,2, true,-1);
    private Slot slot33 = new Slot(3,3,true,-1);
    private Slot slot34 = new Slot(3,4,true,-1);

    private Slot slot41 = new Slot(4,1,true,-1);
    private Slot slot42 = new Slot(4,2, true,-1);
    private Slot slot43 = new Slot(4,3,true,-1);
    private Slot slot44 = new Slot(4,4,true,-1);


    public Field(){
        addSlotInLine(list1,slot11,slot12,slot13,slot14);
        addSlotInLine(list2,slot21,slot22,slot23,slot24);
        addSlotInLine(list3,slot31,slot32,slot33,slot34);
        addSlotInLine(list4,slot41,slot42,slot43,slot44);
    }

    public void addSlotInLine(ArrayList<Slot> list,Slot slot1, Slot slot2, Slot slot3, Slot slot4){
        list.add(slot1);
        list.add(slot2);
        list.add(slot3);
        list.add(slot4);
    }


    public ArrayList<Slot> getLine(int line){
        switch (line){
            case 1 -> {
                return list1;
            }
            case 2 -> {
                return list2;
            }
            case 3 -> {
                return list3;
            }
            case 4 -> {
                return list4;
            }
        }
        return null;
    }
    private Slot searchSlot(int position){ //Пока не нужен
        switch (position) {
            case 11 -> {
                return slot11;
            }
            case 12 -> {
                return slot12;
            }
            case 13 -> {
                return slot13;
            }
            case 14 -> {
                return slot14;
            }
            default -> {
                return defaultSlot;
            }
        }
    }

    public ArrayList<ArrayList<Slot>> getAllLines(){
        ArrayList<ArrayList<Slot>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);
        result.add(list3);
        result.add(list4);
        return result;
    }
}
