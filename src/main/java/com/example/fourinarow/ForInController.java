package com.example.fourinarow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button but15;
    @FXML
    private Button but16;
    @FXML
    private Button but17;
    @FXML
    private Button but21;
    @FXML
    private Button but23;
    @FXML
    private Button but24;
    @FXML
    private Button but25;
    @FXML
    private Button but26;
    @FXML
    private Button but27;

    @FXML
    private Button but31;

    @FXML
    private Button but32;

    @FXML
    private Button but33;

    @FXML
    private Button but34;

    @FXML
    private Button but35;
    @FXML
    private Button but36;
    @FXML
    private Button but37;

    @FXML
    private Button but41;

    @FXML
    private Button but42;

    @FXML
    private Button but43;

    @FXML
    private Button but44;
    @FXML
    private Button but45;
    @FXML
    private Button but46;
    @FXML
    private Button but47;

    @FXML
    private Button but51;

    @FXML
    private Button but52;

    @FXML
    private Button but53;

    @FXML
    private Button but54;

    @FXML
    private Button but55;
    @FXML
    private Button but56;
    @FXML
    private Button but57;

    @FXML
    private Button but61;
    @FXML
    private Button but62;
    @FXML
    private Button but63;
    @FXML
    private Button but64;
    @FXML
    private Button but65;
    @FXML
    private Button but66;
    @FXML
    private Button but67;
    @FXML
    private Button move;
    @FXML
    private Button reset;


    Field mainField = new Field();
    boolean gameStatus = true;
    int stage = 0;

    String blueChip = "-fx-background-color: #0000ff; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px; -fx-border-color: black; -fx-border-radius: 25em; -fx-border-width: 3px";
    String greenChip = "-fx-background-color: #bbff00; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px; -fx-border-color: black; -fx-border-radius: 25em; -fx-border-width: 3px";
    String defaultChip = "-fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px";



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
    @FXML
    protected void click5(){
        if (gameStatus) {
            searchSlotStatus(5);
        }
    }

    @FXML
    protected void click6(){
        if (gameStatus) {
            searchSlotStatus(6);
        }
    }

    @FXML
    protected void click7(){
        if (gameStatus) {
            searchSlotStatus(7);
        }
    }

    @FXML
    protected void restart(){
        reload();
    }


    protected void searchSlotStatus(int line){
        greenChip = greenChip;
        blueChip = blueChip;
        ArrayList<Slot> list = mainField.getLine(line);
        int freePosition = findOutIfThereIsAPlace(list);
        if (freePosition != -1){
            int count = 1;
            for (Slot element: list){
                if (element.status){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (count == freePosition){
                    element.status = false;
                    if (stage == 0){
                        element.belonging = 0;
                        findButton(line,freePosition).setStyle(greenChip);
                        stage = 1;
                        move.setStyle(blueChip);
                    } else {
                        element.belonging = 1;
                        findButton(line,freePosition).setStyle(blueChip);
                        stage = 0;
                        move.setStyle(greenChip);
                    }
                }
                count++;
            }
        }
        checkStatus();
        if (findOutIfThereIsAPlace(list) == -1){
            checkForDraw();
        }
    }

    protected int findOutIfThereIsAPlace(ArrayList<Slot> line){
        int freePosition = -1;
        int count = 1;
        for (Slot element: line){
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
                    case 5 -> {
                        return but51;
                    }
                    case 6 -> {
                        return but61;
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
                    case 5 -> {
                        return  but52;
                    }
                    case 6 -> {
                        return  but62;
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
                    case 5 -> {
                        return  but53;
                    }
                    case 6 -> {
                        return  but63;
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
                    case 5 -> {
                        return but54;
                    }
                    case 6 -> {
                        return but64;
                    }
                }
            }
            case 5-> {
                switch (position){
                    case 1 -> {
                        return but15;
                    }
                    case 2 -> {
                        return but25;
                    }
                    case 3 -> {
                        return but35;
                    }
                    case 4 -> {
                        return but45;
                    }
                    case 5 -> {
                        return but55;
                    }
                    case 6 -> {
                        return but65;
                    }
                }
            }
            case 6-> {
                switch (position){
                    case 1 -> {
                        return but16;
                    }
                    case 2 -> {
                        return but26;
                    }
                    case 3 -> {
                        return but36;
                    }
                    case 4 -> {
                        return but46;
                    }
                    case 5 -> {
                        return but56;
                    }
                    case 6 -> {
                        return but66;
                    }
                }
            }
            case 7-> {
                switch (position){
                    case 1 -> {
                        return but17;
                    }
                    case 2 -> {
                        return but27;
                    }
                    case 3 -> {
                        return but37;
                    }
                    case 4 -> {
                        return but47;
                    }
                    case 5 -> {
                        return but57;
                    }
                    case 6 -> {
                        return but67;
                    }
                }
            }
        }
        return null;
    }

    private void checkStatus(){
        ArrayList<Slot> matrix = mainField.getMatrix();
        ArrayList<ArrayList<Integer>> horizontalLines = getHorizontalLinesFromMatrix(matrix);
        ArrayList<ArrayList<Integer>> verticalLines = getVerticalLinesFromMatrix(matrix);
        ArrayList<ArrayList<Integer>> diagonalLines = getDiagonalLinesFromMatrix(matrix);
        for (ArrayList<Integer> line: horizontalLines){
            checkForWinner(line);
        }
        for (ArrayList<Integer> line: verticalLines){
            checkForWinner(line);
        }
        for (ArrayList<Integer> line: diagonalLines){
            checkForWinner(line);
        }


    }

    private void checkForWinner(ArrayList<Integer> line){
        int result = checkLine(line);
        FXMLLoader winner = new FXMLLoader();
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

    private void checkForDraw(){
        ArrayList<Slot> matrix = mainField.getMatrix();
        ArrayList<Integer> topLine = getHorizontalLinesFromMatrix(matrix).get(0);
        boolean allFilled = true;
        for (Integer cell: topLine){
            if (cell == -1) {
                allFilled = false;
                break;
            }
        }
        if (allFilled){
            FXMLLoader draw = new FXMLLoader();
            gameStatus = false;
            draw.setLocation(getClass().getResource("draw.fxml"));
            try {
                draw.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = draw.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
    }

    private int checkLine(ArrayList<Integer> line){
        int scorePlayer0 = 0;
        int scorePlayer1 = 0;
        int codeResult = -1;
        int prevResult = -2;
        for (Integer element: line){
            if (element != prevResult){
                scorePlayer0 = 0;
                scorePlayer1 = 0;
            }
            switch (element){
                case 0 -> {
                    scorePlayer0++;
                }
                case 1 -> {
                    scorePlayer1++;
                }
            }
            if (scorePlayer0 == 4) return 0;
            else if (scorePlayer1 == 4) return 1;
            prevResult = element;
        }
        return codeResult;
    }

    private ArrayList<ArrayList<Integer>> getHorizontalLinesFromMatrix(ArrayList<Slot> matrix){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();;
        ArrayList<Integer> lineOne = new ArrayList<>();
        ArrayList<Integer> lineTwo = new ArrayList<>();
        ArrayList<Integer> lineThree = new ArrayList<>();
        ArrayList<Integer> lineFour = new ArrayList<>();
        ArrayList<Integer> lineFive = new ArrayList<>();
        ArrayList<Integer> lineSix = new ArrayList<>();
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
        result.add(lineOne);
        result.add(lineTwo);
        result.add(lineThree);
        result.add(lineFour);
        result.add(lineFive);
        result.add(lineSix);
        return result;
    }

    private ArrayList<ArrayList<Integer>> getVerticalLinesFromMatrix(ArrayList<Slot> matrix){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> lineOne = new ArrayList<>();
        ArrayList<Integer> lineTwo = new ArrayList<>();
        ArrayList<Integer> lineThree = new ArrayList<>();
        ArrayList<Integer> lineFour = new ArrayList<>();
        ArrayList<Integer> lineFive = new ArrayList<>();
        ArrayList<Integer> lineSix = new ArrayList<>();
        ArrayList<Integer> lineSeven = new ArrayList<>();
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
        result.add(lineOne);
        result.add(lineTwo);
        result.add(lineThree);
        result.add(lineFour);
        result.add(lineFive);
        result.add(lineSix);
        result.add(lineSeven);
        return result;
    }

    private ArrayList<ArrayList<Integer>> getDiagonalLinesFromMatrix(ArrayList<Slot> matrix){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> diagonalOne = new ArrayList<>();
        ArrayList<Integer> diagonalTwo = new ArrayList<>();
        ArrayList<Integer> diagonalThree = new ArrayList<>();
        ArrayList<Integer> diagonalFour = new ArrayList<>();
        ArrayList<Integer> diagonalFive = new ArrayList<>();
        ArrayList<Integer> diagonalSix = new ArrayList<>();

        ArrayList<Integer> diagonalSeven = new ArrayList<>();
        ArrayList<Integer> diagonalEight = new ArrayList<>();
        ArrayList<Integer> diagonalNine = new ArrayList<>();
        ArrayList<Integer> diagonalTen = new ArrayList<>();
        ArrayList<Integer> diagonalEleven = new ArrayList<>();
        ArrayList<Integer> diagonalTwelve = new ArrayList<>();

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

        result.add(diagonalOne);
        result.add(diagonalTwo);
        result.add(diagonalThree);
        result.add(diagonalFour);
        result.add(diagonalFive);
        result.add(diagonalSix);
        result.add(diagonalSeven);
        result.add(diagonalEight);
        result.add(diagonalNine);
        result.add(diagonalTen);
        result.add(diagonalEleven);
        result.add(diagonalTwelve);
        return result;
    }

    private  void reload(){
        for (int x = 1; x <= 7; x++) {
            for (int y = 1; y <= 6; y++)
                findButton(x, y).setStyle(defaultChip);
        }
        mainField = new Field();
        stage = 0;
        move.setStyle(greenChip);
        gameStatus = true;
    }


}