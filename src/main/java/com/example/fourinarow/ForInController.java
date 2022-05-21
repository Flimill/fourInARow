package com.example.fourinarow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
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

    String blueChip = "-fx-background-color: #0000ff; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px";
    String darkBlueChip = "-fx-background-color: #0044cc; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px";
    String greenChip = "-fx-background-color: #bbff00; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px";
    String darkGreenChip = "-fx-background-color: #00cc00; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px";
    String defaultChip = "-fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px";
    String grayChip = "-fx-background-color: #bbff00; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px"; //

    @FXML
    void initialize() {

    }

    @FXML
    protected void click1(){
        if (gameStatus) {
            searchSlotStatus(1);
        }
    }

    @FXML
    protected void click2(){
        if (gameStatus) {
            searchSlotStatus(2);
        }
    }

    @FXML
    protected void click3(){
        if (gameStatus) {
            searchSlotStatus(3);
        }
    }

    @FXML
    protected void click4(){
        if (gameStatus) {
            searchSlotStatus(4);
        }
    }

    protected void searchSlotStatus(int line){
        ArrayList<Field.Slot> list = mainField.getLine(line);
        int freePosition = findOutIfThereIsAPlace(list);
        if (freePosition != -1){
            int count = 1;
            for (Field.Slot element: list){
                if (element.status){                    //Пока не работает
                    findButton(line, count).setStyle(grayChip);
                    System.out.println("<id> " + findButton(line,count).getId()); // выводит id кнопки/слота на котором находится
                    try {
                        Thread.sleep(200);  //просто делает паузу на 200 млскнд
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    findButton(line, count).setStyle(defaultChip);
                }                                      //

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
                        return but21;
                    }
                    case 3 -> {
                        return but31;
                    }
                    case 4 -> {
                        return but41;
                    }
                }
            }
            case 2 -> {
                switch (position){
                    case 1 -> {
                        return but12;
                    }
                    case 2 -> {
                        return but22;
                    }
                    case 3 -> {
                        return  but32;
                    }
                    case 4 -> {
                        return  but42;
                    }
                }
            }
            case 3-> {
                switch (position){
                    case 1 -> {
                        return but13;
                    }
                    case 2 -> {
                        return  but23;
                    }
                    case 3 -> {
                        return but33;
                    }
                    case 4 -> {
                        return  but43;
                    }
                }
            }
            case 4-> {
                switch (position){
                    case 1 -> {
                        return but14;
                    }
                    case 2 -> {
                        return but24;
                    }
                    case 3 -> {
                        return but34;
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
        winner(lineOne);
        winner(lineTwo);
        winner(lineThree);
        winner(lineFour);
    }

    private void winner(ArrayList<Integer> line){
        int result = checkLine(line);
        FXMLLoader winner = new FXMLLoader();;
        if (result != -1){
            gameStatus = false;
            if (result == 0)
                winner.setLocation(getClass().getResource("greenWins.fxml"));
            if (result == 1)
                winner.setLocation(getClass().getResource("blueWins.fxml"));
            try {
                winner.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = winner.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        }
    }

    private int checkLine(ArrayList<Integer> line){
        int scorePlayer0 = 0;
        int scorePlayer1 = 0;
        int codeResult = -1;
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
        if (scorePlayer0 == 4) codeResult = 0;
        else if (scorePlayer1 == 4) codeResult = 1;
        return codeResult;
    }
}