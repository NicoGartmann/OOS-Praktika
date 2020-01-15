package prak4client;

import javafx.scene.control.Alert;
import prak4gemklassen.*;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnmeldungsController {
	
	private Client mainapp;
	
	
	@FXML
	private Button ausfuehren;
	
	@FXML
	private TextField userID;
	
	@FXML
	private PasswordField passwort; 
	
	@FXML
	private PasswordField passwort2;
	
	

	public void setmainapp(Client main) {
		
		this.mainapp = main;
		
	}
	
	@FXML
	public void handleAusfuehren() {
		
		if(passwort.getText().equals(passwort2.getText()))
		{
			Benutzer ben1 = new Benutzer(userID.getText(),passwort.getText().toCharArray());
			System.out.println(ben1);
			try {
				mainapp.neuerBenutzer(ben1);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch ( BenutzervorhandenExceptions e) {
				userID.setStyle("-fx-background-color: #FF9090; -fx-prompt-text-fill: black");
                userID.clear();
                userID.setPromptText("User existiert bereits");
                
			} catch ( IstLeerException e) {
				userID.setStyle("-fx-background-color: #FF9090; -fx-prompt-text-fill: black");
                userID.clear();
                userID.setPromptText("Eintrag nicht korrekt!");
			}
			Stage stage = (Stage) ausfuehren.getScene().getWindow();
			stage.close();
		}
		else {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Passw�rter stimmen nicht �berein!");

			alert.showAndWait();
		
		}
		
	}
	
	public void fail(){

		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText("Ooops, there was an error!");

		alert.showAndWait();
	}
	

	

}
