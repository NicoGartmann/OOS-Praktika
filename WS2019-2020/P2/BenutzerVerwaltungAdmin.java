import java.util.*;

/**
 * <p>Überschrift: BenutzerVerwaltungAdmin</p>
 * <p>Beschreibung: BenutzerVerwaltung Admin implementiert BenutzerVerwaltung
 * 					Desweiterem ist der Admin in der Lage, Benutzer in die Datenhaltung
 * 					einzutragen und ggf. auch zu löschen.</p>
 * @author nicog
 * @version 1.0
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {
	ArrayList<Benutzer> data = new ArrayList<Benutzer>();
	/**
	 * <p>benutzerEintragen trägt einen neuen Benutzer in die Datenhaltung ein
	 * @param Benutzer
	 * @return void
	 * @throws BenutzerExistsException
	 */
	@Override
	public void benutzerEintragen(Benutzer benutzer) throws BenutzerExistsException {
		// TODO Auto-generated method stub
		if(this.benutzerOK(benutzer)){
			this.data.add(benutzer); 
		}
		else {
			throw new BenutzerExistsException("Benutzer existiert bereits."); 
		}
	}

	/**
	 * <p>benutzerOK prüft lediglich, ob der Benutzer benutzer bereits in der Datenhaltung vorhanden
	 * ist </p>
	 * @param Benutzer
	 * @return boolean
	 */
	@Override
	public boolean benutzerOK(Benutzer benutzer) {
		for(Benutzer element: data) {
			if(element.equals(benutzer)) {
				return false; 
			}
		}		
		return true; 
	}
	
	void benutzerLoeschen(Benutzer benutzer) throws BenutzerNotAvailableException {
		if(!this.benutzerOK(benutzer)) {
			for(int i=0; i<this.data.size(); i++) {
				if(benutzer.equals(data.get(i))) {
					this.data.remove(benutzer);
				}
			}
		} else {
			throw new BenutzerNotAvailableException("Benutzer ist nicht in der Datenhaltung vorhanden."); 
		}
	}
	
	/**
	 * Standardmethode - gibt alle Benutzer der Datenhaltung aus
	 * @return String
	 */
	public String toString() {
		String out="< | ";
		for(Benutzer element: data) {
			out += element.toString() + " | "; 
		}
		out += ">"; 
		return out; 
	}
	/**
	 * <p> Main Methode zum Testen von BenutzerVerwaltungAdmin
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin(); 
		
		char[] p1 = {'q','w','e','r'}; 
		char[] p2 = {'a','s','d','f'}; 
		char[] p3 = {'v','x','c','n'}; 
		char[] p4 = {'x','v','w','y'}; 
		
		Benutzer ben1 = new Benutzer("Georgios",p1); 
		Benutzer ben2 = new Benutzer("Nico",p2);
		Benutzer ben3 = new Benutzer("Nico",p2);
		Benutzer ben4 = new Benutzer("Ralf",p3);
		Benutzer ben5 = new Benutzer("Olaf", p4); 
		
		System.out.println("Benutzer in Datenhaltung eintragen: ");
		System.out.println("Vorher: "); 
		System.out.println(admin);
		try {
			admin.benutzerEintragen(ben1);
			admin.benutzerEintragen(ben2);
			admin.benutzerEintragen(ben4);
			admin.benutzerEintragen(ben5);
		} catch (BenutzerExistsException e) {
			e.printStackTrace();
		}
		System.out.println("Nachher: ");
		System.out.println(admin); 
		
		System.out.println("Bereits existierenden Nutzer eintragen: "); 
		try {
			admin.benutzerEintragen(ben3);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(admin); 
		
		System.out.println("Benutzer löschen: "); 
		try {
			admin.benutzerLoeschen(ben2);
		} catch (BenutzerNotAvailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(admin); 
		
		System.out.println("Nicht existierenden Benutzer löschen: "); 
		try {
			admin.benutzerLoeschen(ben3);
		} catch (BenutzerNotAvailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(admin); 
		
	}

}
