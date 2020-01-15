package prak4client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AnwendungsController{
	
	@FXML
	private Button abbrechen;
	
	@FXML
	public void handlecancel() {
		System.out.println("Anwendung wird geschlossen");
		
		Stage stage = (Stage) abbrechen.getScene().getWindow();
		stage.close();
	}
	
	

}
