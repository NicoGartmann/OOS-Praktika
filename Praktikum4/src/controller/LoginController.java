package controller;
import base.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    private boolean neuanmeldung = false;

    @FXML TextField userID;
    @FXML PasswordField passwort;
    @FXML Button ausfuehren;
    @FXML CheckBox neuAnmeldung;


    @FXML
    void setNeuanmeldung() {
        this.neuanmeldung = neuAnmeldung.isSelected();
        System.out.println(this.neuanmeldung);
    }

    @FXML
    void login() {
        if (!this.neuanmeldung) {
            this.addBenutzer();
            Stage stage = (Stage) ausfuehren.getScene().getWindow();
            stage.close();
        }else{

        }
    }

    void addBenutzer() {
        String name = userID.getText();
        String pass = passwort.getText();
        char[] passneu = new char[pass.length()];
        for (int i=0; i < pass.length();i++) {
            passneu[i] = pass.charAt(i);
        }
        Benutzer benutzer = new Benutzer(name,passneu);
        System.out.println(benutzer);
    }
}
