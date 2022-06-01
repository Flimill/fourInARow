module game {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.fourinarow to javafx.fxml;
    exports game.Model;
    opens game.Model to javafx.fxml;
    exports game.View;
    opens game.View to javafx.fxml;
    exports game.Controller;
    opens game.Controller to javafx.fxml;

}