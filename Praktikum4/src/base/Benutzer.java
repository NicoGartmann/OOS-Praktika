package base;

import java.io.*;

/**
 * <p>�berschrift: Struktur von Benutzern</p>
 * <p>Beschreibung: Die Klasse definiert die grundlegende Struktur von 
 * 					Benutzer. 
 * 					Die Struktur eines Benutzers setzt sich zusammen aus: 
 * 					- der UserID und
 * 					- dem Passwort
 * 					Da es nur um eine Struktur geht, werden lediglich die 
 * 					beiden Standardmethoden equals und toString 
 * 					implementiert </p>
 * @author nicog
 * @version 2.0
 *
 */
public class Benutzer implements Serializable {

	String userID; 
	char[] passWort; 
	
	public Benutzer(){
		
	}
	
	public Benutzer(String userID,char[] passWort) {
		this.userID = userID; 
		this.passWort = passWort; 
	}
	
	/**
	 * <p>Standardmethode</p>
	 * @param benutzer liefert das Objekt, dessen Inhalte mit denen des
	 * 					aktuellen Objekts verglichen werden sollen.
	 * @return boolean
	 */
	public boolean equals(Object benutzer) { 
		return 	(	(benutzer != null)
					&& (benutzer instanceof Benutzer)
					&& (this.userID.equals(((Benutzer) benutzer).userID))
					&& (String.copyValueOf(this.passWort).equals(String.copyValueOf(((Benutzer)  benutzer).passWort)))
				); 
	}
	
	/**
	 * <p>Standardmethode, die die Inhalte der beiden Attribute in der folgenden 
	 * Form ausgibt: userID/passWort</p>
	 * @return String
	 */
	public String toString() {
		return (this.userID + "/" + String.copyValueOf(passWort)); 
	}
}
