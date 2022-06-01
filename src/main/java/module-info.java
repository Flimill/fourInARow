module com.example.fourinarow {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens View to javafx.fxml;
    exports Model;
    opens Model to javafx.fxml;
    exports Controller;
    exports View;
    opens Controller to javafx.fxml;


}