package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        stage.getIcons().add(new Image(String.valueOf(GameWindow.class.getResource("/images/icon.png"))));
        stage.setTitle("4 In A Row");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
