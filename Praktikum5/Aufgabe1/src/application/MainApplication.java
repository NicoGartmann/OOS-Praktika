package application;

import base.Benutzer;
import base.BenutzerVerwaltungAdmin;
import exception.BenutzerInvalidException;
import exception.BenutzerExistsException;
import com.sun.javafx.stage.EmbeddedWindow;
import controller.AnmeldungsController;
import controller.AnwendungsController;
import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainApplication extends Application {
    BenutzerVerwaltungAdmin newAdmin = new BenutzerVerwaltungAdmin();
    MainApplication refMain;

    @Override
    public void start(Stage stage) throws Exception {

        System.out.println("DB initialisieren? 1) Ja 2) Nein:");
        BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
        int dbInitialisieren = Integer.parseInt(din.readLine());
        if (dbInitialisieren == 1) {
            newAdmin.dbInitialisieren();
        }
        System.out.println(newAdmin.toString());
        try {
            Parent root;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/login.fxml"));
            root = loader.load();
            Stage stageStart = new Stage();
            stageStart.setScene(new Scene(root));
            LoginController login = loader.<LoginController>getController();
            refMain = this;
            login.setRefMain(refMain);
            stageStart.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void neuAnmeldung() throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/anmelden.fxml"));
        root = loader.load();

        Stage stageAnmelden = new Stage();
        stageAnmelden.setScene(new Scene(root));
        AnmeldungsController anmeldung = loader.<AnmeldungsController>getController();
        refMain = this;
        anmeldung.setRefMain(refMain);

        stageAnmelden.show();
    }

    public void neuerBenutzer(Benutzer benutzer) throws BenutzerInvalidException, BenutzerExistsException {
        try{
            this.newAdmin.benutzerEintragen(benutzer);
            Parent root;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/login.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);

            LoginController login = loader.<LoginController>getController();
            login.setRefMain(this);

            stage.show();

        }catch(BenutzerExistsException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Benutzer existiert!");
            alert.setContentText("Der Benutzer ist bereits in der Datenhaltung vorhanden!");

            alert.showAndWait();
        }catch(BenutzerInvalidException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Eingaben ungültig!");
            alert.setContentText("Benutzer Name oder Passwort sind falsch!");

            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void benutzerLogin(Benutzer benutzer) throws IOException {
        if (this.newAdmin.benutzerOK(benutzer) == false) {
            Parent root;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/anwendung.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            Stage stageAnwendung = new Stage();
            stageAnwendung.setScene(scene);

            AnwendungsController anwendung = loader.<AnwendungsController>getController();

            stageAnwendung.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Benutzer nicht in der Datenhaltung");
            alert.setContentText("Um die Anwendung zu starten, müssen Sie sich erst registrieren!");

            alert.showAndWait();
        }
    }
}
