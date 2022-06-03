package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameWindow {
    public static void showGameWindow(){
        FXMLLoader draw = new FXMLLoader();
        draw.setLocation(GameResult.class.getResource("forIn.fxml"));
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
