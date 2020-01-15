package prak4client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import prak4gemklassen.*;


public class Client extends Application{
	private BenutzerVerwaltungAdmin bv = new BenutzerVerwaltungAdmin();
	public boolean lokal;
	private String address;

	public Client() throws IOException {

		System.out.println("Soll die Datenbank neu initialisiert werden?\n1) Ja\n2) Nein");
		BufferedReader din = new BufferedReader(
				new InputStreamReader(System.in));
		int dbInitialisieren = Integer.parseInt(din.readLine());
		
		if(dbInitialisieren == 1) {
			bv.dbInitialisieren();
		}
		
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		Parent root = (Parent)fxmlLoader.load();
		LoginController controller = (LoginController)fxmlLoader.getController();
		controller.setmainapp(this);
		stage.setTitle("Benutzerverwaltung");
		stage.setScene(new Scene(root));
		stage.show();
		
	}

	
	public static void main(String[] args) {
		launch(args);
	}

	public void neuAnmeldungRemote() throws IOException {
		// TODO Auto-generated method stub
		this.address = "localhost";
		showAnmeldungView();
		
	}

	public void neuAnmeldungLokal() throws IOException {
		// TODO Auto-generated method stub
		showAnmeldungView();
		
	}
	
	public void showAnmeldungView() throws IOException {
		Stage stage2 = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Anmeldung.fxml"));
		Parent root = (Parent)fxmlLoader.load();
		AnmeldungsController controller = (AnmeldungsController)fxmlLoader.getController();
		controller.setmainapp(this);
		stage2.setTitle("Benutzerverwaltung");
		stage2.setScene(new Scene(root));
		stage2.show();
	}

	public void benutzerLoginLokal(Benutzer ben) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		if(bv.benutzerOK(ben)) {
			Stage stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Anwendung.fxml"));
			Parent root = (Parent)fxmlLoader.load();
			stage.setTitle("Benutzerverwaltung");
			stage.setScene(new Scene(root));
			stage.show();
		}
		else {
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Login.fxml"));
			Stage stage3 = new Stage();
			Parent root = (Parent) fxmlloader.load();
			LoginController anmeldung = fxmlloader.getController();
			anmeldung.setmainapp(this);
			anmeldung.fail();
			stage3.setTitle("Benutzerverwaltung");
			stage3.setScene(new Scene(root));
			stage3.setResizable(false);
			stage3.show();
		}
		
	}
	
	public void benutzerLoginRemote(Benutzer ben) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ClientOrb co = new ClientOrb();
		if(co.benutzerOK(ben)) {
			Stage stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Anwendung.fxml"));
			Parent root = (Parent)fxmlLoader.load();
			stage.setTitle("Benutzerverwaltung");
			stage.setScene(new Scene(root));
			stage.show();
		}
		else {
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Login.fxml"));
			Stage stage3 = new Stage();
			Parent root = (Parent) fxmlloader.load();
			LoginController anmeldung = fxmlloader.getController();
			anmeldung.setmainapp(this);
			anmeldung.fail();
			stage3.setTitle("Benutzerverwaltung");
			stage3.setScene(new Scene(root));
			stage3.setResizable(false);
			stage3.show();
		}
		
	}

	public void neuerBenutzer(Benutzer ben) throws ClassNotFoundException, BenutzervorhandenExceptions, IstLeerException, IOException {
		// TODO Auto-generated method stub
		if (this.lokal) {
			ClientOrb co = new ClientOrb();
			if (!co.benutzerOK(ben)) {
				co.benutzerEingabe(ben);
			}else{
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Eingaben falsch!");
				alert.setContentText("Benutzer existiert bereits");

				alert.showAndWait();
			}

		}
		else {
			bv.benutzerEingabe(ben);
			bv.dbLesen();
			System.out.println(bv.Liste.get(bv.Liste.size() - 1).toString());

		}

	}

	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		//Client client = new Client();
	}



}
