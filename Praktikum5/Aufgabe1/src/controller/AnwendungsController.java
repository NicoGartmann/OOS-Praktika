package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AnwendungsController {

    @FXML Button weiterBtn;


    @FXML
    void StartFensterNext() {
        System.out.println("Fenster wird geschlossen!");
        Stage stage = (Stage) weiterBtn.getScene().getWindow();
        stage.close();
    }

}
