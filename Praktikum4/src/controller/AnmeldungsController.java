package controller;

import base.Benutzer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnmeldungsController {
    @FXML Button ausfuehren;
    @FXML PasswordField passwort;
    @FXML PasswordField passwort2;
    @FXML TextField userID;

    @FXML
    void register() {
        String name = userID.getText();
        String pass1 = passwort.getText();
        String pass2 = passwort2.getText();

        if (pass1.equals(pass2)) {
            char[] passneu = new char[pass1.length()];
            for (int i=0; i < pass1.length();i++) {
                passneu[i] = pass1.charAt(i);
            }
            Benutzer benutzer = new Benutzer(name, passneu);
            System.out.println(benutzer);

            Stage stage = (Stage) ausfuehren.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Passwörter stimmen nicht überein. Wiederholen Sie die Eingabe!");
            alert.showAndWait();
            //userID.setText("Passwort!=Wiederholung");
        }
    }
}
