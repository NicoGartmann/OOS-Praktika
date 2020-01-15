package prak4server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.scene.control.Alert;
import prak4gemklassen.Benutzer;
import prak4gemklassen.BenutzervorhandenExceptions;
import prak4gemklassen.IstLeerException;
 class ServerOrb {
	
	ServerOrb(BenutzerVerwaltungAdmin bv) throws IOException, ClassNotFoundException, BenutzervorhandenExceptions, IstLeerException {
		ServerSocket server = new ServerSocket(4701);
		
		while(true) {
			Socket client = server.accept();
			ObjectInputStream in =
					new ObjectInputStream(client.getInputStream());
					ObjectOutputStream out =
					new ObjectOutputStream(client.getOutputStream());
			int methode = in.readInt();

			if(methode == 1)
			{
				Benutzer ben = (Benutzer) in.readObject();
				if(!bv.benutzerOK(ben)) {
					try {
						bv.benutzerEingabe(ben);
					} catch (BenutzervorhandenExceptions e) {
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Eingaben falsch!");
						alert.setContentText("Benutzer existiert bereits.");
						alert.showAndWait();
						//throw new BenutzervorhandenExceptions("Benutzer bereits vorhanden.");
					}
				} else {
					throw new BenutzervorhandenExceptions("Benutzer bereits vorhanden");
				}
			}
			if(methode == 2) {
				Benutzer ben = (Benutzer) in.readObject();
				out.writeBoolean(bv.benutzerOK(ben));
			}
			if(methode == 3) {
				bv.dbInitialisieren();
			}
			out.flush();
		}
	}

}
