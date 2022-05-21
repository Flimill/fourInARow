package com.example.fourinarow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ForInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private javafx.scene.control.Button but22;

    @FXML
    private Button but11;

    @FXML
    private Button but12;

    @FXML
    private Button but13;

    @FXML
    private Button but14;

    @FXML
    private Button but21;

    @FXML
    private Button but23;

    @FXML
    private Button but24;

    @FXML
    private Button but31;

    @FXML
    private Button but32;

    @FXML
    private Button but33;

    @FXML
    private Button but34;

    @FXML
    private Button but41;

    @FXML
    private Button but42;

    @FXML
    private Button but43;

    @FXML
    private Button but44;

    private Integer[][] Button;
    private Integer move = 0;
    Field mainField = new Field();
    boolean gameStatus = true; //стутс игры, если равен false, значит кто-то выйграл
    int stage = 0; //ход какого игрока (0 или 1)

    @FXML
    void initialize() {

    }

    @FXML
    protected void click1(){
        searchSlotStatus(1);
        }

    @FXML
    protected void click2(){
        searchSlotStatus(2);
    }

    @FXML
    protected void click3(){
        searchSlotStatus(3);
    }

    @FXML
    protected void click4(){
        searchSlotStatus(4);
    }

    protected void searchSlotStatus(int line){
        ArrayList<Field.Slot> list = mainField.getLine(line);
        int freePosition = findOutIfThereIsAPlace(list);
        if (freePosition != -1){
            int count = 1;
            for (Field.Slot element: list){
                if (count == freePosition){
                    element.status = false;
                    if (stage == 0){
                        element.belonging = 0;
                        findButton(line,freePosition).setStyle("-fx-background-color: #bbff00; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px");
                        stage = 1;
                    } else {
                        element.belonging = 1;
                        findButton(line,freePosition).setStyle("-fx-background-color: #0000ff; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px");
                        stage = 0;
                    }
                }
                count++;
            }
        }
        checkStatus();
    }

    protected int findOutIfThereIsAPlace(ArrayList<Field.Slot> line){
        int freePosition = -1;
        int count = 1;
        for (Field.Slot element: line){
            if (element.status) freePosition = count;
            count++;
        }
        return freePosition;
    }

    protected Button findButton(int line, int position){
        switch (line){
            case 1 -> {
                switch (position){
                    case 1 -> {
                        return but11;
                    }
                    case 2 -> {
                        return but12;
                    }
                    case 3 -> {
                        return but13;
                    }
                    case 4 -> {
                        return but14;
                    }
                }
            }
            case 2 -> {
                switch (position){
                    case 1 -> {
                        return but21;
                    }
                    case 2 -> {
                        return but22;
                    }
                    case 3 -> {
                        return but23;
                    }
                    case 4 -> {
                        return but24;
                    }
                }
            }
            case 3-> {
                switch (position){
                    case 1 -> {
                        return but31;
                    }
                    case 2 -> {
                        return but32;
                    }
                    case 3 -> {
                        return but33;
                    }
                    case 4 -> {
                        return but34;
                    }
                }
            }
            case 4-> {
                switch (position){
                    case 1 -> {
                        return but41;
                    }
                    case 2 -> {
                        return but42;
                    }
                    case 3 -> {
                        return but43;
                    }
                    case 4 -> {
                        return but44;
                    }
                }
            }
        }
        return null;
    }

    private void checkStatus(){
        ArrayList<ArrayList<Field.Slot>> arrayLists = mainField.getAllLines();
        ArrayList<Integer> lineOne = new ArrayList<>();
        ArrayList<Integer> lineTwo = new ArrayList<>();
        ArrayList<Integer> lineThree = new ArrayList<>();
        ArrayList<Integer> lineFour = new ArrayList<>();
        for (ArrayList<Field.Slot> element: arrayLists){
            lineOne.add(element.get(0).belonging);
            lineTwo.add(element.get(1).belonging);
            lineThree.add(element.get(2).belonging);
            lineFour.add(element.get(3).belonging);
        }
        if (checkLine(lineOne) != 0){
            if (checkLine(lineOne) == 10){
                System.out.println("Зеленый игрок выйграл");
            } else {
                System.out.println("Синий игрок выйграл");
            }
            gameStatus = false;   // Этот флаг будет останавливать игру
        }

        if (checkLine(lineTwo) != 0){
            if (checkLine(lineTwo) == 10){
                System.out.println("Зеленый игрок выйграл");
            } else {
                System.out.println("Синий игрок выйграл");
            }
            gameStatus = false;
        }

        if (checkLine(lineThree) != 0){
            if (checkLine(lineThree) == 10){
                System.out.println("Зеленый игрок выйграл");
            } else {
                System.out.println("Синий игрок выйграл");
            }
            gameStatus = false;
        }

        if (checkLine(lineFour) != 0){
            if (checkLine(lineFour) == 10){
                System.out.println("Зеленый игрок выйграл");
            } else {
                System.out.println("Синий игрок выйграл");
            }
            gameStatus = false;
        }
    }

    private int checkLine(ArrayList<Integer> line){
        int scorePlayer0 = 0;
        int scorePlayer1 = 0;
        int codeResult = 0;
        for (Integer element: line){
            switch (element){
                case 0 -> {
                    scorePlayer0++;
                }
                case 1 -> {
                    scorePlayer1++;
                }
            }
        }
        if (scorePlayer0 == 4) codeResult = 10;  //коды результата (1 - значит победа, а следующая цифра говорит о том кто)
        if (scorePlayer1 == 4) codeResult = 11;
        return codeResult;
    }
}