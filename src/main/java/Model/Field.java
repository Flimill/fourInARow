package Model;

import java.util.ArrayList;
import java.util.List;

public class Field {


    private static Field mainField;
    static boolean gameStatus = true;
    private static Constants stage = Constants.GreenPlayer;




    private final Slot slot11 = new Slot(1,1, Constants.Empty);
    private final Slot slot12 = new Slot(1,2, Constants.Empty);
    private final Slot slot13 = new Slot(1,3,Constants.Empty);
    private final Slot slot14 = new Slot(1,4,Constants.Empty);
    private final Slot slot15 = new Slot(1,5,Constants.Empty);
    private final Slot slot16 = new Slot(1,6,Constants.Empty);


    private final Slot slot21 = new Slot(2,1,Constants.Empty);
    private final Slot slot22 = new Slot(2,2, Constants.Empty);
    private final Slot slot23 = new Slot(2,3,Constants.Empty);
    private final Slot slot24 = new Slot(2,4,Constants.Empty);

    private final Slot slot25 = new Slot(1,5,Constants.Empty);
    private final Slot slot26 = new Slot(1,6,Constants.Empty);

    private final Slot slot31 = new Slot(3,1,Constants.Empty);
    private final Slot slot32 = new Slot(3,2, Constants.Empty);
    private final Slot slot33 = new Slot(3,3,Constants.Empty);
    private final Slot slot34 = new Slot(3,4,Constants.Empty);

    private final Slot slot35 = new Slot(1,5,Constants.Empty);
    private final Slot slot36 = new Slot(1,6,Constants.Empty);

    private final Slot slot41 = new Slot(4,1,Constants.Empty);
    private final Slot slot42 = new Slot(4,2, Constants.Empty);
    private final Slot slot43 = new Slot(4,3,Constants.Empty);
    private final Slot slot44 = new Slot(4,4,Constants.Empty);

    private final Slot slot45 = new Slot(4,5,Constants.Empty);
    private final Slot slot46 = new Slot(4,6,Constants.Empty);

    private final Slot slot51 = new Slot(5,1,Constants.Empty);
    private final Slot slot52 = new Slot(5,2, Constants.Empty);
    private final Slot slot53 = new Slot(5,3,Constants.Empty);
    private final Slot slot54 = new Slot(5,4,Constants.Empty);

    private final Slot slot55 = new Slot(5,5,Constants.Empty);
    private final Slot slot56 = new Slot(5,6,Constants.Empty);

    private final Slot slot61 = new Slot(6,1,Constants.Empty);
    private final Slot slot62 = new Slot(6,2, Constants.Empty);
    private final Slot slot63 = new Slot(6,3,Constants.Empty);
    private final Slot slot64 = new Slot(6,4,Constants.Empty);

    private final Slot slot65 = new Slot(6,5,Constants.Empty);
    private final Slot slot66 = new Slot(6,6,Constants.Empty);

    private final Slot slot71 = new Slot(7,1,Constants.Empty);
    private final Slot slot72 = new Slot(7,2, Constants.Empty);
    private final Slot slot73 = new Slot(7,3,Constants.Empty);
    private final Slot slot74 = new Slot(7,4,Constants.Empty);

    private final Slot slot75 = new Slot(7,5,Constants.Empty);
    private final Slot slot76 = new Slot(7,6,Constants.Empty);

    public final List<Slot> list1 = List.of(slot11,slot12,slot13,slot14,slot15,slot16);

    public final List<Slot> list2 = List.of(slot21,slot22,slot23,slot24,slot25,slot26);

    public final List<Slot> list3 = List.of(slot31,slot32,slot33,slot34,slot35,slot36);

    public final List<Slot> list4 = List.of(slot41,slot42,slot43,slot44,slot45,slot46);

    public final List<Slot> list5 = List.of(slot51,slot52,slot53,slot54,slot55,slot56);

    public final List<Slot> list6 = List.of(slot61,slot62,slot63,slot64,slot65,slot66);

    public final List<Slot> list7 = List.of(slot71,slot72,slot73,slot74,slot75,slot76);



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


    public static int findFreePosition(List<Slot> line){
        int freePosition = -1;
        int count = 1;
        for (Slot element: line){
            if (element.belonging == Constants.Empty) freePosition = count;
            count++;
        }
        return freePosition;
    }



    public static List<List<Constants>> getHorizontalLinesFromMatrix(List<Slot> matrix){
        List<Constants> lineOne = new ArrayList<>();
        List<Constants> lineTwo = new ArrayList<>();
        List<Constants> lineThree = new ArrayList<>();
        List<Constants> lineFour = new ArrayList<>();
        List<Constants> lineFive = new ArrayList<>();
        List<Constants> lineSix = new ArrayList<>();
        int i = 0;
        while (i < 7){
            lineOne.add(matrix.get(i).belonging);
            lineTwo.add(matrix.get(i + 7).belonging);
            lineThree.add(matrix.get(i + 14).belonging);
            lineFour.add(matrix.get(i + 21).belonging);
            lineFive.add(matrix.get(i + 28).belonging);
            lineSix.add(matrix.get(i + 35).belonging);
            i++;
        }
        return List.of(lineOne,lineTwo,lineThree,lineFour,lineFive,lineFive,lineSix);
    }

    public static List<List<Constants>> getVerticalLinesFromMatrix(List<Slot> matrix){
        List<Constants> lineOne = new ArrayList<>();
        List<Constants> lineTwo = new ArrayList<>();
        List<Constants> lineThree = new ArrayList<>();
        List<Constants> lineFour = new ArrayList<>();
        List<Constants> lineFive = new ArrayList<>();
        List<Constants> lineSix = new ArrayList<>();
        List<Constants> lineSeven = new ArrayList<>();
        int i = 0;
        int s = 0;
        while (i < 6){
            lineOne.add(matrix.get(s).belonging);
            lineTwo.add(matrix.get(s + 1).belonging);
            lineThree.add(matrix.get(s + 2).belonging);
            lineFour.add(matrix.get(s + 3).belonging);
            lineFive.add(matrix.get(s + 4).belonging);
            lineSix.add(matrix.get(s + 5).belonging);
            lineSeven.add(matrix.get(s + 6).belonging);
            s += 7;
            i++;
        }
        return List.of(lineOne,lineTwo,lineThree,lineFour,lineFive,lineFive,lineSix,lineSeven);
    }

    public static List<List<Constants>> getDiagonalLinesFromMatrix(List<Slot> matrix){
        List<Constants> diagonalOne = new ArrayList<>();
        List<Constants> diagonalTwo = new ArrayList<>();
        List<Constants> diagonalThree = new ArrayList<>();
        List<Constants> diagonalFour = new ArrayList<>();
        List<Constants> diagonalFive = new ArrayList<>();
        List<Constants> diagonalSix = new ArrayList<>();

        List<Constants> diagonalSeven = new ArrayList<>();
        List<Constants> diagonalEight = new ArrayList<>();
        List<Constants> diagonalNine = new ArrayList<>();
        List<Constants> diagonalTen = new ArrayList<>();
        List<Constants> diagonalEleven = new ArrayList<>();
        List<Constants> diagonalTwelve = new ArrayList<>();

        int i = 0;
        int rightDiagonalCounter = 0;  // нужен для сдвига.
        int leftDiagonalCounter = 0;
        int start1 = 3;     //стартовые индексы диагонали
        int start2 = 4;
        int start3 = 5;
        int start4 = 6;
        int start5 = 13;
        int start6 = 20;
        int start7 = 14;
        int start8 = 7;
        int start9 = 0;
        int start10 = 1;
        int start11 = 2;
        int start12 = 3;
        while (i < 4) {
            diagonalOne.add(matrix.get(start1 + rightDiagonalCounter).belonging);
            diagonalSix.add(matrix.get(start6 + rightDiagonalCounter).belonging);
            diagonalSeven.add(matrix.get(start7 + leftDiagonalCounter).belonging);
            diagonalTwelve.add(matrix.get(start12 + leftDiagonalCounter).belonging);
            rightDiagonalCounter += 6;
            leftDiagonalCounter += 8;
            i++;
        }
        rightDiagonalCounter = 0;
        leftDiagonalCounter = 0;
        i = 0;
        while (i < 5){
            diagonalTwo.add(matrix.get(start2 + rightDiagonalCounter).belonging);
            diagonalFive.add(matrix.get(start5 + rightDiagonalCounter).belonging);
            diagonalEight.add(matrix.get(start8 + leftDiagonalCounter).belonging);
            diagonalEleven.add(matrix.get(start11 + leftDiagonalCounter).belonging);
            rightDiagonalCounter += 6;
            leftDiagonalCounter += 8;
            i++;
        }
        rightDiagonalCounter = 0;
        leftDiagonalCounter = 0;
        i = 0;
        while (i < 6){
            diagonalThree.add(matrix.get(start3 + rightDiagonalCounter).belonging);
            diagonalFour.add(matrix.get(start4 + rightDiagonalCounter).belonging);
            diagonalNine.add(matrix.get(start9 + leftDiagonalCounter).belonging);
            diagonalTen.add(matrix.get(start10 + leftDiagonalCounter).belonging);

            rightDiagonalCounter += 6;
            leftDiagonalCounter += 8;
            i++;
        }

        return List.of(diagonalOne,diagonalTwo,diagonalThree,diagonalFour,diagonalFive,diagonalSix,diagonalSeven,
                diagonalEight,diagonalNine,diagonalTen,diagonalEleven,diagonalTwelve);
    }


    public static boolean getGameStatus(){
        return gameStatus;
    }

    public static Field getMainField(){return mainField;}

    public static void turnOffGameStatus(){
        gameStatus = false;
    }

    public static void turnOnGameStatus(){
        gameStatus = true;
    }

    public static Constants getStage(){return stage;}


    public static void createNewField(){
        mainField = new Field();
    }

    public static void setStage(Constants constants){
        stage = constants;
    }


}
