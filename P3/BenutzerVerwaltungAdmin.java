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
	 * <p>benutzerEintragen trägt einen neuen Benutzer in die Datenhaltung ein</p>
	 * @param Benutzer
	 * @return void
	 * @throws BenutzerExistsException
	 */
	@Override
	public void benutzerEintragen(Benutzer benutzer) throws BenutzerExistsException, BenutzerInvalidException {
		// TODO Auto-generated method stub
		if(benutzer.userID == "" || String.copyValueOf(benutzer.passWort) == "") {
			throw new BenutzerInvalidException("Benutzereingaben ungueltig");
		}
		
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
	
	
	void benutzerLoeschen(Benutzer benutzer) throws BenutzerNotExistsException {
		if(!this.benutzerOK(benutzer)) {
			for(int i=0; i<this.data.size(); i++) {
				if(benutzer.equals(data.get(i))) {
					this.data.remove(benutzer);
				}
			}
		} else {
			throw new BenutzerNotExistsException("Benutzer ist nicht in der Datenhaltung vorhanden."); 
		}
	}
	
	/**
	 * Standardmethode - gibt alle Benutzer der Datenhaltung aus
	 * @return String
	 */
	public String toString() {
		String out="< ";
		for(Benutzer element: data) {
			out += element.toString()+" "; 
		}
		out += ">"; 
		return out; 
	}
	/**
	 * <p> Main Methode zum Testen von BenutzerVerwaltungAdmin
	 * @param args 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin(); 
		
		char[] p1 = {'q','w','e','r'}; 
		char[] p2 = {'a','s','d','f'}; 
		char[] p3 = {'v','x','c','n'}; 
		char[] p4 = {'x','v','w','y'}; 
		char[] p5 = {'s','a','v','e'}; 
		
		Benutzer ben1 = new Benutzer("Georgios",p1); 
		Benutzer ben2 = new Benutzer("Nico",p2);
		Benutzer ben3 = new Benutzer("Nico",p2);
		Benutzer ben4 = new Benutzer("Ralf",p3);
		Benutzer ben5 = new Benutzer("Olaf", p4); 
		Benutzer ben6 = new Benutzer("Kevin",p5); 
		Benutzer ben7 = new Benutzer("", p5); 
		
		
		System.out.println("In leerer Datenhaltung Benutzer Georgios loeschen: (Exception soll geworfen werden)");
		try {
			admin.benutzerLoeschen(ben1);
		} catch (BenutzerNotExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Benutzer in Datenhaltung eintragen:(soll ohne Probleme funktionieren)");
		System.out.println("Vorher: " + admin); 
		try {
			admin.benutzerEintragen(ben1);
			admin.benutzerEintragen(ben2);
			admin.benutzerEintragen(ben4);
			admin.benutzerEintragen(ben5);
		} catch (BenutzerExistsException e) {
			e.printStackTrace();
		} catch(BenutzerInvalidException e) {
			e.printStackTrace();
		}
		System.out.println("Nachher: " + admin);
		
		System.out.println("Ungueltiger benutzer ben7 eintragen: (soll exception werfen)"); 
		try {
			admin.benutzerEintragen(ben7);
		} catch (BenutzerExistsException e) {
			e.printStackTrace();
		} catch(BenutzerInvalidException e) {
			e.printStackTrace();
		}
		
		System.out.println("Benutzer Kevin testen: (soll true liefern)"); 
		System.out.println(admin.benutzerOK(ben6));
		
		System.out.println("Benutzer Olaf testen: (soll false liefern)"); 
		System.out.println(admin.benutzerOK(ben5)); 
		
		System.out.println("Bereits existierenden Nutzer Nico eintragen:(soll Exception werfen) "); 
		try {
			admin.benutzerEintragen(ben3);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(BenutzerInvalidException e) {
			e.printStackTrace();
		}
		System.out.println(admin); 
		
		System.out.println("Benutzer Nico löschen: (soll funktionieren) "); 
		System.out.println("Vorher: " + admin); 
		try {
			admin.benutzerLoeschen(ben2);
		} catch (BenutzerNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Nachher: " + admin); 
		
		System.out.println("Nicht existierenden Benutzer Kevin löschen: (soll Exception werfen)"); 
		try {
			admin.benutzerLoeschen(ben6);
		} catch (BenutzerNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(admin); 
		
	}

}
