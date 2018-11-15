import java.util.ArrayList;

public class BenutzerverwaltungAdmin implements BenutzerVerwaltung {
	
	private ArrayList <Benutzer> data = new ArrayList<Benutzer>(); 
	
	public void benutzerEintragen(Benutzer benutzer) throws BenutzerExistsException {
		for(int i=0; i<this.data.size(); i++) {
			if(this.data.get(i).equals(benutzer)) {
				throw new BenutzerExistsException("Benutzer bereits vorhanden!");
			}
		}
		this.data.add(benutzer);
	}
	
	public boolean benutzerOK(Benutzer benutzer) {
		for(int i=0; i<data.size() ; i++) {
			if(this.data.get(i).equals(benutzer)) {
				return true; 
			}
		}
		return false; 
	}
	
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
	
	public String toString() {
		String res = "";
		for(int i=0; i < this.data.size(); i++) {
			System.out.println(this.data.get(i).toString());
		}
		return res;
	}
	
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
			admin.benutzerEintragen(b1);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(admin);
		
		try {
			admin.benutzerLoeschen(b1);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(admin);
		
		try {
			admin.benutzerLoeschen(b4);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(admin);
		
	}
}
