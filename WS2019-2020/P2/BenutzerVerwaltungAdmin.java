/**
 * <p>Überschrift: BenutzerVerwaltungAdmin</p>
 * <p>Beschreibung: BenutzerVerwaltung Admin implementiert BenutzerVerwaltung
 * 					Desweiterem ist der Admin in der Lage, Benutzer in die Datenhaltung
 * 					einzutragen und ggf. auch zu löschen.</p>
 * @author nicog
 * @version 1.0
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {
	
	/**
	 * <p>benutzerEintragen trägt einen neuen Benutzer in die Datenhaltung ein
	 * @param Benutzer
	 * @return void
	 * @throws BenutzerExistsException
	 */
	@Override
	public void benutzerEintragen(Benutzer benutzer) throws BenutzerExistsException {
		// TODO Auto-generated method stub

	}

	/**
	 * <p>benutzerOK prüft lediglich, ob der Benutzer benutzer bereits in der Datenhaltung vorhanden
	 * ist </p>
	 * @param Benutzer
	 * @return boolean
	 */
	@Override
	public boolean benutzerOK(Benutzer benutzer) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Standardmethode - gibt alle Benutzer der Datenhaltung aus
	 * @return String
	 */
	public String toString() {
		return ""; 
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
		admin.benutzerEintragen(ben1);
		admin.benutzerEintragen(ben2);
		admin.benutzerEintragen(ben4);
		admin.benutzerEintragen(ben5);
		System.out.println("Nachher: ");
		System.out.println(admin); 
		
		System.out.println("Bereits existierenden Nutzer eintragen: "); 
		admin.benutzerEintragen(ben3);
		System.out.println(admin); 
		
		System.out.println("Benutzer löschen: "); 
		admin.benutzerLoeschen(ben3); 
		System.out.println(admin); 
		
		System.out.println("Nicht existierenden Benutzer löschen: "); 
		admin.benutzerLoeschen(ben3); 
		System.out.println(admin); 
		
	}

}
