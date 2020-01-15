package prak4client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import prak4gemklassen.Benutzer;
import prak4gemklassen.BenutzervorhandenExceptions;

public class ClientOrb implements BenutzerVerwaltung{
	
	public ClientOrb() {
		
	}

	public void benutzerEingabe(Benutzer ben) throws BenutzervorhandenExceptions {
		// TODO Auto-generated method stub
		try {
			Socket server = new Socket("localhost", 4701);
			ObjectOutputStream out =
					new ObjectOutputStream(server.getOutputStream());
					ObjectInputStream is =
					new ObjectInputStream(server.getInputStream());
			out.writeInt(1);
			out.writeObject(ben);
			out.flush();
			server.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean benutzerOK(Benutzer ben) {
		boolean result = false;
		try {
			Socket server = new Socket("localhost", 4701);
			ObjectOutputStream out =
					new ObjectOutputStream(server.getOutputStream());
					ObjectInputStream is =
					new ObjectInputStream(server.getInputStream());
			out.writeInt(2);
			out.writeObject(ben);
			out.flush();
			result = is.readBoolean();
			server.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	
	public void dbInitialisieren() throws UnknownHostException, IOException {
		Socket server = new Socket("localhost", 4701);
		ObjectOutputStream out =
				new ObjectOutputStream(server.getOutputStream());
				ObjectInputStream is =
				new ObjectInputStream(server.getInputStream());
		out.writeInt(3);
		out.flush();
		server.close();
	}


}
