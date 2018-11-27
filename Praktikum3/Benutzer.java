
public class Benutzer {
	
	/**
	 * <h1> Benutzer </h1>
	 * <p> Benutzer dient zum Erstellen eines Benutzers, der einen Namen und ein Passwort
	 * besitzen muss </p>
	 * 
	 * @author Nico Gartmann
	 * @version 1.0
	 * @since 2018-11-15 
	 */
	String userID; 
	char[] passWort; 
	
	Benutzer() {
		
	}
	
	/**
	 * <p>Erstellt Benutzer</p>
	 * @param userID
	 * @param passWort
	 */
	Benutzer(String userID, char[] passWort) {
		this.userID= userID; 
		this.passWort= passWort; 
	}
	
	/**
	 * <p>Prüft ob 2 Nutzer gleich sind</p>
	 * @param obj 
	 * @return boolean true bei gleichem Nutzer 
	 */
	public boolean equals(Object obj) {
		if((obj instanceof Benutzer) && (obj!=null)) {
			Benutzer b = (Benutzer) obj;
			return (this.userID.equals(b.userID) && this.passWort.equals(b.passWort)); 
		}
		else return false; 
		
	}
	
	/**
	 * <p>Einen Nutzer ausgeben</p>
	 * @return String 
	 */
	public String toString () {
		return ("Benutzer: " + this.userID.toString() + ", Passwort: " + String.copyValueOf(this.passWort)); 
	}
}
