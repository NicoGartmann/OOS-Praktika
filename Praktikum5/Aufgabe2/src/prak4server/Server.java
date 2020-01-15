package prak4server;

import java.io.IOException;

import prak4gemklassen.BenutzervorhandenExceptions;
import prak4gemklassen.IstLeerException;



public class Server {
	
	public Server() throws IOException, ClassNotFoundException, BenutzervorhandenExceptions, IstLeerException {
		BenutzerVerwaltungAdmin bv = new BenutzerVerwaltungAdmin();
		ServerOrb so = new ServerOrb(bv);
	}
	
	public static void main(String[] args) throws BenutzervorhandenExceptions, IstLeerException {
		try {
			System.out.println("Server Läuft");
			Server s = new Server();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
