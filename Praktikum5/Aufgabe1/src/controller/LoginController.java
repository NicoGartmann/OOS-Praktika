package controller;

import application.MainApplication;
import base.Benutzer;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {

    private boolean neuAnmeldung = false;
    MainApplication refMain;

    @FXML CheckBox cb;
    @FXML TextField benutzername;
    @FXML PasswordField keineahnung;
    @FXML Button machenBtn;

    @FXML
    public void setNeuAnmeldung() {

        neuAnmeldung = cb.isSelected();
        System.out.println(neuAnmeldung);

    }

    @FXML
    public void checkAnmeldung() throws IOException {

        if (this.neuAnmeldung) {
            refMain.neuAnmeldung();
            Stage stage = (Stage) machenBtn.getScene().getWindow();
            stage.close();

        }else{
            String name = benutzername.getText();
            String pass = keineahnung.getText();
            char[] passneu = new char[pass.length()];
            for (int i=0; i < pass.length();i++) {
                passneu[i] = pass.charAt(i);
            }
            Benutzer benutzer = new Benutzer(name,passneu);
            refMain.benutzerLogin(benutzer);
            Stage stage = (Stage) machenBtn.getScene().getWindow();
            stage.close();
        }

    }

    public void addBenutzer() {

        String name = benutzername.getText();
        String pass = keineahnung.getText();
        char[] passneu = new char[pass.length()];
        for (int i=0; i < pass.length(); i++) {
            passneu[i] = pass.charAt(i);
        }
        Benutzer benutzer = new Benutzer(name,passneu);
        System.out.println(benutzer);

    }

    public void setRefMain(MainApplication tmp) {
        this.refMain = tmp;
    }

}
