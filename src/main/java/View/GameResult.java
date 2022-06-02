package View;

import Model.Constants;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameResult {

    public static void outWinner(Constants result) {
        FXMLLoader winner = new FXMLLoader();
        if (result == Constants.GreenPlayer)
            winner.setLocation(GameResult.class.getResource("greenWins.fxml"));
        if (result == Constants.BluePlayer)
            winner.setLocation(GameResult.class.getResource("blueWins.fxml"));
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

    public static void outDraw(){
        FXMLLoader draw = new FXMLLoader();
        draw.setLocation(GameResult.class.getResource("draw.fxml"));
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

