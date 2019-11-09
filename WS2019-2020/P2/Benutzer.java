/**
 * <p>Überschrift: Struktur von Benutzern</p>
 * <p>Beschreibung: Die Klasse definiert die grundlegende Struktur von 
 * 					Benutzer. 
 * 					Die Struktur eines Benutzers setzt sich zusammen aus: 
 * 					- der UserID und
 * 					- dem Passwort
 * 					Da es nur um eine Struktur geht, werden lediglich die 
 * 					beiden Standardmethoden equals und toString 
 * 					implementiert </p>
 * @author nicog
 * @version 1.0
 *
 */
public class Benutzer {

	String userID; 
	char[] passWort; 
	
	Benutzer(){
		
	}
	
	Benutzer(String userID,char[] passWort) {
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
	
	/**
	 * <p>Main-Methode Test Benutzer</p>
	 * @param args 
	 * @return void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] p1 = {'q','w','e','r'}; 
		char[] p2 = {'a','s','d','f'}; 
		char[] p3 = {'v','x','c','n'}; 
		
		Benutzer ben1 = new Benutzer("Georgios",p1); 
		Benutzer ben2 = new Benutzer("Nico",p2);
		Benutzer ben3 = new Benutzer("Nico",p2);
		Benutzer ben4 = new Benutzer("Georgios",p3); 
		
		
		System.out.println("Test toString, alle Benutzer:");
		System.out.println(ben1); 
		System.out.println(ben2);  
		System.out.println(ben3); 
		System.out.println(ben4); 
		
		System.out.print("Test auf Gleichheit  Nico(ben2) & Nico(ben3), erwartet: true, tatsächlich: "); 
		System.out.println(ben2.equals(ben3)); 
		
		System.out.print("Test auf Gleichheit Georgios(ben1) & Georgios(ben4), erwartet: false, tatsächlich: ");
		System.out.println(ben1.equals(ben4)); 
		
	}

}
