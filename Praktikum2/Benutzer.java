
public class Benutzer {
	String userID; 
	char[] passWort; 
	
	Benutzer() {
		
	}
	
	Benutzer(String userID, char[] passWort) {
		this.userID= userID; 
		this.passWort= passWort; 
	}
	
	public boolean equals(Object obj) {
		Benutzer b = (Benutzer) obj; 
		return (this.userID.equals(b.userID)&&this.passWort.equals(b.passWort)); 
	}
	
	public String toString () {
		return ("Benutzer: " + this.userID.toString() + " Passwort: " + this.passWort.toString()); 
	}
}
