package prak4gemklassen;

import java.io.Serializable;

/**
	 * <h1> Benutzer </h1>
	 * <p>Die Klasse benutzer ist dazu da um einen Benutzer zu erstellen,
	 * Ihn mit einem anderen Benutzer zu Vergleichen und Ihn als String auszugeben</p>
	 * @author Georgios Nikas
	 * @version 1.0
	 */
public class Benutzer implements Serializable{
	
	public String userID;
	public char[] passWort;
	
	Benutzer() {
		
	}
	/**
	 * <p>Legt einen Benutzer an</p>
	 * @param userID BenutzerID
	 * @param passWort Passwort 
	 */
	public Benutzer(String userID, char[] passWort) {
	
		this.userID = userID;
		this.passWort = passWort;
		
	}
	
	/**
	 * <p>Vergleicht ob es sich um einen Benutzer handet, 
	 * falls ja dann wird dieser mit dem aktuellen Benutzer verglichen</p>
	 */
	public boolean equals(Object obj) {
		
		if((obj instanceof Benutzer)) {
				Benutzer b = (Benutzer) obj;
				return(this.userID.equals(b.userID) && String.copyValueOf(this.passWort).equals(String.copyValueOf(b.passWort)));
		}
		else return false;
	}
	
	/**
	 * <p>Gibt einen Benutzer als String aus</p>
	 */
	public String toString( ) {
		return("BenutzerID: " + this.userID.toString() + " Passwort: " + String.copyValueOf(passWort));
	}
	
}
