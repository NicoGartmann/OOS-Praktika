package prak4client;

import prak4gemklassen.*;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

/**
	 * <h1> BenutzerVerwaltung </h1>
	 * <p>Dies ist ein Interface für benutzerEingabe und benutzerOK</p>
	 * @author Georgios Nikas
	 * @version 1.0
	 */
public interface BenutzerVerwaltung {
	
	void benutzerEingabe(Benutzer benutzer) throws BenutzervorhandenExceptions, IstLeerException, ClassNotFoundException;
	boolean benutzerOK(Benutzer benutzer) throws ClassNotFoundException, IOException;

}
