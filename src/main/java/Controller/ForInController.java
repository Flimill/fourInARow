package Controller;

import Model.Constants;
import Model.Field;
import Model.Slot;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.*;


public class ForInController {


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



    private Map getButtonMap() {
        List<Button> buttonList = List.of(but11,but12,but13,but14,but15, but16, but17,
                but21,but22,but23,but24,but25,but26,but27,
                but31,but32,but33,but34,but35,but36,but37,
                but41,but42,but43,but44,but45,but46,but47,
                but51,but52,but53,but54,but55,but56,but57,
                but61,but62,but63,but64,but65,but66,but67);
        Map<Pair<Integer, Integer>,Button> buttonMap = new HashMap<>();
        int i = 0; //индекс кнопки в buttonList
        for (int line = 1; line <= 6; line++)
            for (int position = 1; position <= 7; position++) {
                buttonMap.put(new Pair(line, position), buttonList.get(i));
                i++;
            }
        return buttonMap;
    }

    private Field mainField = new Field();
    boolean gameStatus = true; //
    private Constants stage = Constants.GreenPlayer;

    final static String blueChip = "-fx-background-color: #0000ff; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px; -fx-border-color: black; -fx-border-radius: 25em; -fx-border-width: 3px";
    final static String greenChip = "-fx-background-color: #bbff00; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px; -fx-border-color: black; -fx-border-radius: 25em; -fx-border-width: 3px";
    final static String defaultChip = "-fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px";



    @FXML
    void initialize() {

    }

    @FXML
    protected void rowClick1(){
        if (gameStatus) {
            checkAndAddSlot(1);
        }
    }

    @FXML
    protected void rowClick2(){
        if (gameStatus) {
            checkAndAddSlot(2);
        }
    }

    @FXML
    protected void rowClick3(){
        if (gameStatus) {
            checkAndAddSlot(3);
        }
    }

    @FXML
    protected void rowClick4(){
        if (gameStatus) {
            checkAndAddSlot(4);
        }
    }
    @FXML
    protected void rowClick5(){
        if (gameStatus) {
            checkAndAddSlot(5);
        }
    }

    @FXML
    protected void rowClick6(){
        if (gameStatus) {
            checkAndAddSlot(6);
        }
    }

    @FXML
    protected void rowClick7(){
        if (gameStatus) {
            checkAndAddSlot(7);
        }
    }

    @FXML
    protected void restart(){
        reload();
    }


    protected void checkAndAddSlot(int line){
        List<Slot> row = mainField.getLine(line);
        int freePosition = findFreePosition(row);
        if (freePosition != -1){
            int count = 1;
            for (Slot cell: row){
                if (cell.status){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (count == freePosition){
                    cell.status = false;
                    if (stage == Constants.GreenPlayer){
                        cell.belonging = Constants.GreenPlayer;
                        findButton(line,freePosition).setStyle(greenChip);
                        stage = Constants.BluePlayer;
                        move.setStyle(blueChip);
                    } else {
                        cell.belonging = Constants.BluePlayer;
                        findButton(line,freePosition).setStyle(blueChip);
                        stage = Constants.GreenPlayer;
                        move.setStyle(greenChip);
                    }
                }
                count++;
            }
        }
        checkStatus();
        if (findFreePosition(row) == -1){
            checkForDraw();
        }
    }

    protected int findFreePosition(List<Slot> line){
        int freePosition = -1;
        int count = 1;
        for (Slot element: line){
            if (element.status) freePosition = count;
            count++;
        }
        return freePosition;
    }

    public Button findButton(int verticalLine, int horizontalLine){
        return (Button) getButtonMap().get(new Pair(horizontalLine, verticalLine));
    }

    private void checkStatus(){
        List<Slot> matrix = mainField.getMatrix();
        List<List<Constants>> horizontalLines = getHorizontalLinesFromMatrix(matrix);
        List<List<Constants>> verticalLines = getVerticalLinesFromMatrix(matrix);
        List<List<Constants>> diagonalLines = getDiagonalLinesFromMatrix(matrix);
        for (List<Constants> line: horizontalLines){
            checkForWinner(line);
        }
        for (List<Constants> line: verticalLines){
            checkForWinner(line);
        }
        for (List<Constants> line: diagonalLines){
            checkForWinner(line);
        }


    }

    private void checkForWinner(List<Constants> line){
        Constants result = checkLine(line);
        FXMLLoader winner = new FXMLLoader();
        if (result != Constants.Empty){
            gameStatus = false;
            if (result == Constants.GreenPlayer)
                winner.setLocation(getClass().getResource("greenWins.fxml"));
            if (result == Constants.BluePlayer)
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
        List<Slot> matrix = mainField.getMatrix();
        List<Constants> topLine = getHorizontalLinesFromMatrix(matrix).get(0);
        boolean allFilled = true;
        for (Constants cell: topLine){
            if (cell == Constants.Empty) {
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

    private Constants checkLine(List<Constants> line){
        int scorePlayer0 = 0;
        int scorePlayer1 = 0;
        Constants prevSlotBelonging = Constants.Empty;
        for (Constants belonging: line){
            if (belonging != prevSlotBelonging){
                scorePlayer0 = 0;
                scorePlayer1 = 0;
            }
            switch (belonging){
                case GreenPlayer -> {
                    scorePlayer0++;
                }
                case BluePlayer -> {
                    scorePlayer1++;
                }
            }
            if (scorePlayer0 == 4) return Constants.GreenPlayer;
            else if (scorePlayer1 == 4) return Constants.BluePlayer;
            prevSlotBelonging = belonging;
        }
        return Constants.Empty;
    }

    private List<List<Constants>> getHorizontalLinesFromMatrix(List<Slot> matrix){
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

    private List<List<Constants>> getVerticalLinesFromMatrix(List<Slot> matrix){
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

    private List<List<Constants>> getDiagonalLinesFromMatrix(List<Slot> matrix){
        List<List<Constants>> result = List.of();
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

    private  void reload(){
        for (int x = 1; x <= 7; x++) {
            for (int y = 1; y <= 6; y++)
                findButton(x, y).setStyle(defaultChip);
        }
        mainField = new Field();
        stage = Constants.GreenPlayer;
        move.setStyle(greenChip);
        gameStatus = true;
    }


}