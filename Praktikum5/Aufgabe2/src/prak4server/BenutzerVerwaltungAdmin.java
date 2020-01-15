package prak4server;

import prak4gemklassen.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
	 * <h1> BenutzerVerwaltungAdmin </h1>
	 * <p>BenutzerVerwaltungAdmin ist f�r die Handhabung von Benutzerdaten in einer Datenhaltung.
	 * Mit dieser Klasse kann man Benutzer eingeben,�berpr�fen ob er schon existiert und l�schen kann</p>
	 * @author Georgios Nikas
	 * @version 1.0
	 */



public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {
	
	
	/**<p>
	 * Erstellung der Datenhaltung</p>
	 */
	 List<Benutzer> Liste = new ArrayList<Benutzer>();
	
	
	/**<p>
	 *Zur eingabe von Benutzerdaten in die Datenhaltung
	 *�berpr�ft als erstes ob der Benutzer bereitsvorhanden ist.
	 *Als zweites ob der Benutzer leer ist.
	 *Als drittes ob die userID leer ist.
	 *Als viertes ob das Passwort leer ist.
	 *Falls alle vier F�lle false sind wird der Benutzer angelegt.</p>
	 *@param benutzer �bergibt den Benutzer 
	 *@throws BenutzervorhandenExceptions
	 *@throws IstLeerException
	 * @throws ClassNotFoundException 
	 */
		
		@Override
	public void benutzerEingabe(Benutzer benutzer) throws BenutzervorhandenExceptions, IstLeerException, ClassNotFoundException {
						
			try {
				dbLesen();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		/*if(Liste.contains(benutzer)) {
			throw new BenutzervorhandenExceptions("Dieser Benutzer existiert bereits");
		}
		else */ if(benutzer == null) {
			throw new IstLeerException("Dem Benutzer fehlt BenutzerID und Passwort");
		}
		//else if(benutzer.userID == "") {
		else if(benutzer.userID.isEmpty()) {
			throw new IstLeerException("Dem Benutzer wurde keine BenuterID �bergeben");
		}
		//else if(benutzer.passWort.length == 0) {
		else if(String.copyValueOf(benutzer.passWort).isEmpty()) {
			throw new IstLeerException("Dem Benutzer wurde kein Passwort �bergeben");
		}
		else {
			Liste.add(benutzer);
			try {
				dbSchreiben();
				System.out.println("Benutzer hinzugef�gt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
				
	}
		/**<p>
		 * �berpr�ft ob ein Benutzer bereits vorhanden ist</p>
		 * @return Gibt true zur�ck falls er vorhanden ist und false falls nicht
		 * @throws ClassNotFoundException 
		 * @throws IOException 
		 */
	@Override
	public boolean benutzerOK(Benutzer benutzer) throws ClassNotFoundException {
		
		
		try {
			dbLesen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return (this.Liste.contains(benutzer));
			
	}
	
	/**<p>
	 * Ist dazu da einen Benutzer zu l�schen.
	 * �berpr�ft ob die Datenhaltung leer ist oder der Benutzer nicht in der Datenhaltung vorhanden ist,
	 * falls dies der Fall ist wirft er die Exception Benutzernichtvorhanden aus.
	 * Ansonsten geht er die Liste durch sucht den Benutzer und l�scht ihn.</p>
	 * @param benutzer
	 * @throws BenutzernichtvorhandenException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void benutzerLoeschen(Benutzer benutzer) throws BenutzernichtvorhandenException, ClassNotFoundException{
		
		try {
			dbLesen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(this.Liste.isEmpty() || !(this.Liste.contains(benutzer))) {
			throw new BenutzernichtvorhandenException("Der Benutzer existiert nicht");
		}
		
		else {
			this.Liste.remove(benutzer);
			System.out.println("Benutzer wurde gel�scht");
			try {
				dbSchreiben();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	 
	}
	
	void dbInitialisieren() throws IOException{
		
		
		String filename = "BenutzerlisteServer.ser";
		List<Benutzer> listSer = new ArrayList<Benutzer>();
		
		

		
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(listSer);
				
			out.close();
			file.close();
			
			System.out.println("Benutzer wurde Serialisiert");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	void dbSchreiben() throws IOException {
		String filename = "BenutzerlisteServer.ser";
		
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			
			out.writeObject(Liste);
			
				
			out.close();
			file.close();
			
			System.out.println("Benutzer wurde Serializiert");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void dbLesen() throws IOException, ClassNotFoundException {
		try {
			FileInputStream file = new FileInputStream("BenutzerlisteServer.ser");
			ObjectInputStream in = new ObjectInputStream(file);
					
			Liste = (List)in.readObject();
						
			in.close();
			file.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File ist leer");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Gibt Benutzer aus der Datenhaltung aus.
	 */
	public String toString() {
		int size = this.Liste.size();
		String res = "";
		for(int i=0; i < size; i++) {
			System.out.println(this.Liste.get(i).toString());
		}
		return res;
	}

}