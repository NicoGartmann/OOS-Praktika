package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AnwendungsController {

    @FXML
    Button abbrechen;

    @FXML
    void showMeldung() {
        System.out.println("Fenster wird geschlossen!");
        Stage stage = (Stage) abbrechen.getScene().getWindow();
        stage.close();
    }

}
