package base;

import exception.*;
/**
 * <p>�berschrift: Interface Benutzerverwaltung</p>
 * <p>Beschreibung: Die Methoden des Interfaces
 * 					soll allen Benutzern des Systems
 * 					zur Verf�gung stehen.</p>
 * @author nicog
 * @version 1.0
 */
public interface BenutzerVerwaltung {
	void benutzerEintragen(Benutzer benutzer) throws BenutzerExistsException, BenutzerInvalidException; 
	boolean benutzerOK(Benutzer benutzer); 
}
