package controller;

import application.MainApplication;
import exception.BenutzerInvalidException;
import exception.BenutzerExistsException;
import base.Benutzer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnmeldungsController {

    @FXML TextField FieldName;
    @FXML PasswordField FieldPasswort;
    @FXML PasswordField FieldPasswort2;
    @FXML Button BtnAusfuehren;
    MainApplication refMain;

    @FXML
    public void anmeldung() throws BenutzerExistsException, BenutzerInvalidException {
        String name = FieldName.getText();
        String pass1 = FieldPasswort.getText();
        String pass2 = FieldPasswort2.getText();

        if (pass1.equals(pass2)) {
            char[] passneu = new char[pass1.length()];
            for (int i=0; i < pass1.length();i++) {
                passneu[i] = pass1.charAt(i);
            }
            Benutzer benutzer = new Benutzer(name, passneu);
            this.refMain.neuerBenutzer(benutzer);

            Stage stage = (Stage) BtnAusfuehren.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Passwörter stimmen nicht überein. Wiederholen Sie die Eingabe!");

            alert.showAndWait();
        }
    }


    public void setRefMain(MainApplication tmp) {
        this.refMain = tmp;
    }
}
