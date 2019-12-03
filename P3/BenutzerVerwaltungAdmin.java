import java.util.*;
import java.io.*;

/**
 * <p>Überschrift: BenutzerVerwaltungAdmin</p>
 * <p>Beschreibung: BenutzerVerwaltung Admin implementiert BenutzerVerwaltung
 * 					Desweiterem ist der Admin in der Lage, Benutzer in die Datenhaltung
 * 					einzutragen und ggf. auch zu löschen.</p>
 * @author nicog
 * @version 2.0
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung, Serializable {
	private ArrayList<Benutzer> data = new ArrayList<Benutzer>();
	
	
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
		
		BenutzerVerwaltungAdmin tmp = (BenutzerVerwaltungAdmin) this.getData();
		if(!this.equals(tmp)) {
			this.dataChange();
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
		BenutzerVerwaltungAdmin tmp = (BenutzerVerwaltungAdmin) this.getData();
		return (!tmp.data.contains(benutzer));  
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
		
		BenutzerVerwaltungAdmin tmp = (BenutzerVerwaltungAdmin) this.getData();
		if(!this.data.equals(tmp.data)) {
			this.dataChange();
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
	
	Object getData() {
		BenutzerVerwaltungAdmin tmp = new BenutzerVerwaltungAdmin();
		try {
			FileInputStream fs = new FileInputStream("data.s"); 
			ObjectInputStream is = new ObjectInputStream(fs);
			tmp = (BenutzerVerwaltungAdmin) is.readObject();
			is.close();
		} catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		return tmp; 
	}
	
	void dataChange() {
		try {
			FileOutputStream fs = new FileOutputStream("data.s"); 
			ObjectOutputStream os = new ObjectOutputStream(fs); 
			os.writeObject(this);
			os.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void dbInitialisieren() {
		BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin(); 
		try {
			FileOutputStream fs = new FileOutputStream("data.s"); 
			ObjectOutputStream os = new ObjectOutputStream(fs); 
			os.writeObject(admin);
			os.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
