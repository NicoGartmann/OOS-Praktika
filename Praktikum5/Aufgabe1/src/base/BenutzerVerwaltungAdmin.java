package base;

import java.util.*;
import java.io.*;
import exception.*;

/**
 * <p>Überschrift: base.BenutzerVerwaltungAdmin</p>
 * <p>Beschreibung: base.BenutzerVerwaltung Admin implementiert base.BenutzerVerwaltung
 * 					Desweiterem ist der Admin in der Lage, base.Benutzer in die Datenhaltung
 * 					einzutragen und ggf. auch zu löschen.</p>
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung, Serializable {
	ArrayList<Benutzer> data = new ArrayList<Benutzer>();


	/**
	 * <p>benutzerEintragen trägt einen neuen base.Benutzer in die Datenhaltung ein</p>
	 * @param benutzer
	 * @return void
	 * @throws BenutzerExistsException, BenutzerInvalidException
	 */
	@Override
	public void benutzerEintragen(Benutzer benutzer) throws BenutzerExistsException, BenutzerInvalidException {
		// TODO Auto-generated method stub
		//if(benutzer.userID == "" || String.copyValueOf(benutzer.passWort) == "") {
		if(benutzer.userID.isEmpty() || String.copyValueOf(benutzer.passWort).isEmpty()) {
			throw new BenutzerInvalidException("Benutzereingaben ungueltig");
		}

		if(this.benutzerOK(benutzer)){
			this.data.add(benutzer);
		}
		else {
			throw new BenutzerExistsException("base.Benutzer existiert bereits.");
		}

		BenutzerVerwaltungAdmin tmp = (BenutzerVerwaltungAdmin) this.getData();
		if(!this.equals(tmp)) {
			for (int i = 0; i < this.data.size(); i++) {
				if (tmp.benutzerOK(this.data.get(i))) {
					tmp.data.add(this.data.get(i));
				}
			}
			this.data = tmp.data;
			this.dataChange();
		}
	}

	/**
	 * <p>benutzerOK prüft lediglich, ob der base.Benutzer benutzer bereits in der Datenhaltung vorhanden
	 * ist </p>
	 * @param benutzer
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
			throw new BenutzerNotExistsException("base.Benutzer ist nicht in der Datenhaltung vorhanden.");
		}

		BenutzerVerwaltungAdmin tmp = (BenutzerVerwaltungAdmin) this.getData();
		if(!this.data.equals(tmp.data)) {
			this.dataChange();
		}
	}

	/**
	 * Standardmethode - gibt alle base.Benutzer der Datenhaltung aus
	 * @return String
	 */
	public String toString() {
		BenutzerVerwaltungAdmin tmp = (BenutzerVerwaltungAdmin) this.getData();
		String out="< ";
		for(Benutzer element: tmp.data) {
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

	public void dbInitialisieren() {
		BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
		admin.dataChange();
	}


}
