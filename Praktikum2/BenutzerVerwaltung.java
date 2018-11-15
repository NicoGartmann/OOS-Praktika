
public interface BenutzerVerwaltung {
	
	
	void benutzerEintragen(Benutzer benutzer) throws BenutzerExistsException;  
	boolean benutzerOK(Benutzer benutzer); 
}
