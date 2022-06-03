package Controller;

import Model.Computer;
import View.GameWindow;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartWindowController {


    @FXML
    private Button computer;

    @FXML
    private Button player;

    @FXML
    protected void playWithPayer(){
        player.getScene().getWindow().hide();
        Computer.computerPlayer = false;
        GameWindow.showGameWindow();

    }

    @FXML
    protected void playWithComputer(){
        computer.getScene().getWindow().hide();
        Computer.computerPlayer = true;
        GameWindow.showGameWindow();

    }

}
