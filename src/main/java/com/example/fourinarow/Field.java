package com.example.fourinarow;

import java.util.ArrayList;

public class Field {
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
    ArrayList<Slot> list1 = new ArrayList<Slot>();

    ArrayList<Slot> list2 = new ArrayList<Slot>();

    ArrayList<Slot> list3 = new ArrayList<Slot>();

    ArrayList<Slot> list4 = new ArrayList<Slot>();

    ArrayList<Slot> list5 = new ArrayList<Slot>();

    ArrayList<Slot> list6 = new ArrayList<Slot>();

    ArrayList<Slot> list7 = new ArrayList<Slot>();


    private Slot defaultSlot = new Slot(0,0,false,-1);
    private Slot slot11 = new Slot(1,1,true,-1);
    private Slot slot12 = new Slot(1,2, true,-1);
    private Slot slot13 = new Slot(1,3,true,-1);
    private Slot slot14 = new Slot(1,4,true,-1);
    private Slot slot15 = new Slot(1,5,true,-1);
    private Slot slot16 = new Slot(1,6,true,-1);


    private Slot slot21 = new Slot(2,1,true,-1);
    private Slot slot22 = new Slot(2,2, true,-1);
    private Slot slot23 = new Slot(2,3,true,-1);
    private Slot slot24 = new Slot(2,4,true,-1);

    private Slot slot25 = new Slot(1,5,true,-1);
    private Slot slot26 = new Slot(1,6,true,-1);

    private Slot slot31 = new Slot(3,1,true,-1);
    private Slot slot32 = new Slot(3,2, true,-1);
    private Slot slot33 = new Slot(3,3,true,-1);
    private Slot slot34 = new Slot(3,4,true,-1);

    private Slot slot35 = new Slot(1,5,true,-1);
    private Slot slot36 = new Slot(1,6,true,-1);

    private Slot slot41 = new Slot(4,1,true,-1);
    private Slot slot42 = new Slot(4,2, true,-1);
    private Slot slot43 = new Slot(4,3,true,-1);
    private Slot slot44 = new Slot(4,4,true,-1);

    private Slot slot45 = new Slot(4,5,true,-1);
    private Slot slot46 = new Slot(4,6,true,-1);

    private Slot slot51 = new Slot(5,1,true,-1);
    private Slot slot52 = new Slot(5,2, true,-1);
    private Slot slot53 = new Slot(5,3,true,-1);
    private Slot slot54 = new Slot(5,4,true,-1);

    private Slot slot55 = new Slot(5,5,true,-1);
    private Slot slot56 = new Slot(5,6,true,-1);

    private Slot slot61 = new Slot(6,1,true,-1);
    private Slot slot62 = new Slot(6,2, true,-1);
    private Slot slot63 = new Slot(6,3,true,-1);
    private Slot slot64 = new Slot(6,4,true,-1);

    private Slot slot65 = new Slot(6,5,true,-1);
    private Slot slot66 = new Slot(6,6,true,-1);

    private Slot slot71 = new Slot(7,1,true,-1);
    private Slot slot72 = new Slot(7,2, true,-1);
    private Slot slot73 = new Slot(7,3,true,-1);
    private Slot slot74 = new Slot(7,4,true,-1);

    private Slot slot75 = new Slot(7,5,true,-1);
    private Slot slot76 = new Slot(7,6,true,-1);


    public Field(){
        addSlotInLine(list1,slot11,slot12,slot13,slot14,slot15,slot16);
        addSlotInLine(list2,slot21,slot22,slot23,slot24,slot25,slot26);
        addSlotInLine(list3,slot31,slot32,slot33,slot34,slot35,slot36);
        addSlotInLine(list4,slot41,slot42,slot43,slot44,slot45,slot46);
        addSlotInLine(list5,slot51,slot52,slot53,slot54,slot55,slot56);
        addSlotInLine(list6,slot61,slot62,slot63,slot64,slot65,slot66);
        addSlotInLine(list7,slot71,slot72,slot73,slot74,slot75,slot76);
    }

    public void addSlotInLine(ArrayList<Slot> list,Slot slot1, Slot slot2, Slot slot3, Slot slot4, Slot slot5, Slot slot6){
        list.add(slot1);
        list.add(slot2);
        list.add(slot3);
        list.add(slot4);
        list.add(slot5);
        list.add(slot6);
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
            case 5 -> {
                return list5;
            }
            case 6 -> {
                return list6;
            }
            case 7 -> {
                return list7;
            }
        }
        return null;
    }

    public ArrayList<ArrayList<Slot>> getAllLines(){
        ArrayList<ArrayList<Slot>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);
        result.add(list3);
        result.add(list4);
        result.add(list5);
        result.add(list6);
        result.add(list7);
        return result;
    }

    public ArrayList<Slot> getMatrix(){
        ArrayList<ArrayList<Field.Slot>> arrayLines = getAllLines();
        ArrayList<Field.Slot> result = new ArrayList<>();
        int count = 0;
        while (count != 6){
            for (ArrayList<Field.Slot> lines : arrayLines) {
                result.add(lines.get(count));
            }
            count++;
        }
        return result;
    }
}
