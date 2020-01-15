package prak4client;


import javafx.scene.control.*;
import prak4gemklassen.*;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class LoginController {
	
	private Client mainapp;

	private boolean neuAnmeldung = false;
	
	@FXML
	private Button ausführen;
	
	
	@FXML
	private TextField userID;
	
	@FXML
	private PasswordField passwort;
	
	@FXML
	private CheckBox checkbox;
	
	@FXML
	private CheckBox remotecheckbox;
	
	@FXML
	public void handlecheckbox() {
		this.neuAnmeldung = checkbox.isSelected();
		 System.out.println("NeuAnmeldung: " + neuAnmeldung);
	}
	
	@FXML
	public void handleRemote() {
		mainapp.lokal = remotecheckbox.isSelected();
		System.out.println("Remote: " + mainapp.lokal);
	}
	
	@FXML
	public void handleAusfuehren() {
		Benutzer ben1 = new Benutzer(userID.getText(),passwort.getText().toCharArray());
		
		if(neuAnmeldung == true) {
			try {
				if(mainapp.lokal == true) {
					mainapp.neuAnmeldungRemote();
				}
				else {
					mainapp.neuAnmeldungLokal();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			if (!(ben1.userID.isEmpty() || String.copyValueOf(ben1.passWort).isEmpty())) {
				try {
					if (mainapp.lokal == true) {
						mainapp.benutzerLoginRemote(ben1);
					} else {
						mainapp.benutzerLoginLokal(ben1);
					}
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}  else {
				this.fail();
			}
		}
	}
	
	
	public void setmainapp(Client main) {
		
		this.mainapp = main;
		
	}
	
	public void fail() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Eingaben falsch!");
		alert.setContentText("Benutzer wurde falsch eingetippt oder existiert noch nicht.");
		alert.showAndWait();
	}
	

}
