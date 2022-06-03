package Controller;

import Model.Checks;
import View.GameResult;
import Model.Field;
import Model.Slot;
import Model.Constants;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Pair;

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

    @FXML
    private Button reset;


    final static String blueChip = "-fx-background-color: #0000ff; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px; -fx-border-color: black; -fx-border-radius: 25em; -fx-border-width: 3px";
    final static String greenChip = "-fx-background-color: #bbff00; -fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px; -fx-border-color: black; -fx-border-radius: 25em; -fx-border-width: 3px";
    final static String defaultChip = "-fx-background-radius: 25em; -fx-max-height: 100px; -fx-max-width: 100px; -fx-min-height: 100px; -fx-min-width: 100px";



    @FXML
    void initialize() {
        Field.createNewField();
    }

    @FXML
    protected void rowClick1(){
        if (Field.getGameStatus()) {
            strokeProcessing(1);
        }
    }

    @FXML
    protected void rowClick2(){
        if (Field.getGameStatus()) {
            strokeProcessing(2);
        }
    }

    @FXML
    protected void rowClick3(){
        if (Field.getGameStatus()) {
            strokeProcessing(3);
        }
    }

    @FXML
    protected void rowClick4(){
        if (Field.getGameStatus()) {
            strokeProcessing(4);
        }
    }
    @FXML
    protected void rowClick5(){
        if (Field.getGameStatus()) {
            strokeProcessing(5);
        }
    }

    @FXML
    protected void rowClick6(){
        if (Field.getGameStatus()) {
            strokeProcessing(6);
        }
    }

    @FXML
    protected void rowClick7(){
        if (Field.getGameStatus()) {
            strokeProcessing(7);
        }
    }

    @FXML
    protected void restart(){
        for (int x = 1; x <= 7; x++) {
            for (int y = 1; y <= 6; y++)
                findButton(x, y).setStyle(defaultChip);
        }
        Field.createNewField();
        Field.setStage(Constants.GreenPlayer);
        Field.turnOnGameStatus();
    }



    protected void strokeProcessing(int line){
        Constants result = checkAndAddSlot(line);
        if (result != Constants.Empty){
            Field.turnOffGameStatus();
            if (result == Constants.Draw)
                GameResult.outDraw();
            else
                GameResult.outWinner(result);
        }

    }

    public Constants checkAndAddSlot(int line){
        List<Slot> row = Field.getMainField().getLine(line);
        int freePosition = Field.findFreePosition(row);
        if (freePosition != -1){
            int count = 1;
            for (Slot cell: row){
                if (cell.belonging != Constants.Empty){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (count == freePosition){
                    if (Field.getStage() == Constants.GreenPlayer){
                        cell.belonging = Constants.GreenPlayer;
                        findButton(line,freePosition).setStyle(greenChip);
                        Field.setStage(Constants.BluePlayer);
                        move.setStyle(blueChip);
                    } else {
                        cell.belonging = Constants.BluePlayer;
                        findButton(line,freePosition).setStyle(blueChip);
                        Field.setStage(Constants.GreenPlayer);
                        move.setStyle(greenChip);
                    }
                }
                count++;
            }
        }
        return Checks.checkStatus();
    }

    public Button findButton(int verticalLine, int horizontalLine){
        return (Button) getButtonMap().get(new Pair(horizontalLine, verticalLine));
    }

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

}