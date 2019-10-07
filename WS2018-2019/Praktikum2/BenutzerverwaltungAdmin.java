import java.util.ArrayList;

public class BenutzerverwaltungAdmin implements BenutzerVerwaltung {
	
	/**
	 * <h1> Admin </h1>
	 * <p>Admin kann Benutzer in die Datenhaltung data hinzufuegen oder loeschen, 
	 * genauso wie zu pruefen, ob ein Benutzer in der Datenhaltung vorhanden ist</p>
	 * @author Nico Gartmann
	 * @version 1.0
	 * @since 2018-11-15
	 */
	
	private ArrayList <Benutzer> data = new ArrayList<Benutzer>(); 
	
	/**
	 * <p>Fuegt einen neuen Benutzer hinzu, wenn dieser nicht schon in der Datenhaltung eingetragen 
	 * ist</p>
	 * @param benutzer
	 * @throws BenutzerExistsException
	 */
	@Override 
	public void benutzerEintragen(Benutzer benutzer) throws BenutzerExistsException {
		for(int i=0; i<this.data.size(); i++) {
			if(this.data.get(i).userID.equals(benutzer.userID)) {
				throw new BenutzerExistsException("Benutzer bereits vorhanden!");
			}
		}
		this.data.add(benutzer);
	}
	
	/**
	 * <p>Prueft, ob ein Benutzer in der Datenhaltung eingetragen ist</p>
	 * @param benutzer
	 * @return boolean 
	 */
	@Override 
	public boolean benutzerOK(Benutzer benutzer) {
		for(int i=0; i<data.size() ; i++) {
			if(this.data.get(i).equals(benutzer)) {
				return true; 
			}
		}
		return false; 
	}
	
	/**
	 * <p>Loescht einen Benutzer, wenn dieser in der Datenhaltung existiert</p>
	 * @param benutzer
	 * @throws BenutzerExistsException
	 */
	void benutzerLoeschen(Benutzer benutzer) throws BenutzerExistsException {
		if(this.data.isEmpty()) {
			throw new BenutzerExistsException("Benutzer existiert nicht!");
		}
		for(int i=0; i<data.size(); i++) {
			if(this.data.get(i).equals(benutzer)) {
				this.data.remove(i); 
				break; 
			}
			if((!this.data.get(i).equals(benutzer)) && (i==this.data.size()-1)) {
				throw new BenutzerExistsException("Benutzer existiert nicht!");
			}
		}	
	}
	
	/**
	 * <p>Gibt Benuzer aus der Datenhaltung aus</p>
	 * @return String
	 */
	public String toString() {
		String res = "";
		for(int i=0; i < this.data.size(); i++) {
			System.out.println(this.data.get(i).toString());
		}
		return res;
	}
	
	/**
	 * <p>Main Methode zum Testen</p>
	 * @param args
	 */
	
	public static void main(String[] args) {
		BenutzerverwaltungAdmin admin = new BenutzerverwaltungAdmin(); 
		
		// Passwoerter 
		char[] p1 = {'a','s','d','f'}; 
		char[] p2 = {'j','k','l','m'}; 
		char[] p3 = {'y','v','y','v'}; 
		char[] p4 = {'a','b','c','d'}; 
		
		//Benutzer 
		Benutzer b1 = new Benutzer("Nico",p1); 
		Benutzer b2 = new Benutzer("George",p2); 
		Benutzer b3 = new Benutzer("Ashkan",p3); 
		Benutzer b4 = new Benutzer("Pascal", p4); 
		Benutzer b5 = new Benutzer("Nico", p2); 
	
		
		try {
			admin.benutzerEintragen(b1);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			admin.benutzerEintragen(b2);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			admin.benutzerEintragen(b3);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//loest Exception aus 
		try {
			admin.benutzerEintragen(b5);
		} catch (BenutzerExistsException e) {
			e.printStackTrace();
		}
		
		System.out.println(admin);
		
		try {
			admin.benutzerLoeschen(b1);
		} catch (BenutzerExistsException e) {
			e.printStackTrace();
		}
		
		System.out.println(admin);
		
		
		//loest exception aus 
		try {
			admin.benutzerLoeschen(b4);
		} catch (BenutzerExistsException e) {
			e.printStackTrace();
		}
		
		System.out.println(admin);
		
	}
}
