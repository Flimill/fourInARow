package Model;

import java.util.ArrayList;
import java.util.List;

public class Field {



    private Slot slot11 = new Slot(1,1,true, Constants.Empty);
    private Slot slot12 = new Slot(1,2, true,Constants.Empty);
    private Slot slot13 = new Slot(1,3,true,Constants.Empty);
    private Slot slot14 = new Slot(1,4,true,Constants.Empty);
    private Slot slot15 = new Slot(1,5,true,Constants.Empty);
    private Slot slot16 = new Slot(1,6,true,Constants.Empty);


    private Slot slot21 = new Slot(2,1,true,Constants.Empty);
    private Slot slot22 = new Slot(2,2, true,Constants.Empty);
    private Slot slot23 = new Slot(2,3,true,Constants.Empty);
    private Slot slot24 = new Slot(2,4,true,Constants.Empty);

    private Slot slot25 = new Slot(2,5,true,Constants.Empty);
    private Slot slot26 = new Slot(2,6,true,Constants.Empty);

    private Slot slot31 = new Slot(3,1,true,Constants.Empty);
    private Slot slot32 = new Slot(3,2, true,Constants.Empty);
    private Slot slot33 = new Slot(3,3,true,Constants.Empty);
    private Slot slot34 = new Slot(3,4,true,Constants.Empty);

    private Slot slot35 = new Slot(3,5,true,Constants.Empty);
    private Slot slot36 = new Slot(3,6,true,Constants.Empty);

    private Slot slot41 = new Slot(4,1,true,Constants.Empty);
    private Slot slot42 = new Slot(4,2, true,Constants.Empty);
    private Slot slot43 = new Slot(4,3,true,Constants.Empty);
    private Slot slot44 = new Slot(4,4,true,Constants.Empty);

    private Slot slot45 = new Slot(4,5,true,Constants.Empty);
    private Slot slot46 = new Slot(4,6,true,Constants.Empty);

    private Slot slot51 = new Slot(5,1,true,Constants.Empty);
    private Slot slot52 = new Slot(5,2, true,Constants.Empty);
    private Slot slot53 = new Slot(5,3,true,Constants.Empty);
    private Slot slot54 = new Slot(5,4,true,Constants.Empty);

    private Slot slot55 = new Slot(5,5,true,Constants.Empty);
    private Slot slot56 = new Slot(5,6,true,Constants.Empty);

    private Slot slot61 = new Slot(6,1,true,Constants.Empty);
    private Slot slot62 = new Slot(6,2, true,Constants.Empty);
    private Slot slot63 = new Slot(6,3,true,Constants.Empty);
    private Slot slot64 = new Slot(6,4,true,Constants.Empty);

    private Slot slot65 = new Slot(6,5,true,Constants.Empty);
    private Slot slot66 = new Slot(6,6,true,Constants.Empty);

    private Slot slot71 = new Slot(7,1,true,Constants.Empty);
    private Slot slot72 = new Slot(7,2, true,Constants.Empty);
    private Slot slot73 = new Slot(7,3,true,Constants.Empty);
    private Slot slot74 = new Slot(7,4,true,Constants.Empty);

    private Slot slot75 = new Slot(7,5,true,Constants.Empty);
    private Slot slot76 = new Slot(7,6,true,Constants.Empty);

    private List<Slot> list1 = List.of(slot11,slot12,slot13,slot14,slot15,slot16);

    private List<Slot> list2 = List.of(slot21,slot22,slot23,slot24,slot25,slot26);

    private List<Slot> list3 = List.of(slot31,slot32,slot33,slot34,slot35,slot36);

    private List<Slot> list4 = List.of(slot41,slot42,slot43,slot44,slot45,slot46);

    private List<Slot> list5 = List.of(slot51,slot52,slot53,slot54,slot55,slot56);

    private List<Slot> list6 = List.of(slot61,slot62,slot63,slot64,slot65,slot66);

    private List<Slot> list7 = List.of(slot71,slot72,slot73,slot74,slot75,slot76);



    public List<Slot> getLine(int line){
        List<List<Slot>> lists = List.of(list1, list2, list3, list4, list5, list6, list7);
        return lists.get(line - 1);
    }

    public List<List<Slot>> getAllLines(){
        return List.of(list1, list2, list3, list4, list5, list6, list7);
    }

    public List<Slot> getMatrix(){
        List<List<Slot>> arrayLines = getAllLines();
        List<Slot> result = new ArrayList<>();
        int count = 0;
        while (count != 6){
            for (List<Slot> lines : arrayLines) {
                result.add(lines.get(count));
            }
            count++;
        }
        return result;
    }
}
