import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BenVerwaltungAdminTestInitialised {
	
	public BenVerwaltungAdminTestInitialised() {
		
	}

	Benutzer ben1,ben2,ben3,ben4,ben5,ben6,ben7;
	BenutzerVerwaltungAdmin admin;
	@Before
	public void setUp() throws Exception {
		admin = new BenutzerVerwaltungAdmin();
		admin.dbInitialisieren();
		char[] p1 = {'q','w','e','r'}; 
		char[] p2 = {'a','s','d','f'}; 
		char[] p3 = {'v','x','c','n'}; 
		char[] p4 = {'x','v','w','y'}; 
		char[] p5 = {'s','a','v','e'};
		ben1 = new Benutzer("Nico",p1);
		ben2 = new Benutzer("Georgios",p2);
		ben3 = new Benutzer("Frederik",p3);
		ben4 = new Benutzer("Salvadore",p4);
		ben5 = new Benutzer("Nico",p1);
		ben6 = new Benutzer("",p5);
		ben7 = null; 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void beneintragen() {
		try {
			admin.benutzerEintragen(ben6);
			fail("Benutzer wurde eingetragen, obwohl der Benutzer ungueltig war.");
		} catch(BenutzerExistsException e) {
			fail("Benutzer existiert nicht, ist aber ungueltig.");
		} catch(BenutzerInvalidException e) {
			
		}
		
		try {
			admin.benutzerEintragen(ben1);
		} catch(BenutzerExistsException e) {
			fail("Benutzer existiert noch nicht.");
		} catch(BenutzerInvalidException e) {
			fail("Benutzer ist gueltig.");
		}
		
		try {
			admin.benutzerEintragen(ben1);
			fail("Benutzer existiert bereits in der Datenbank und darf nicht erneut eingetragen werden.");
		} catch(BenutzerInvalidException e) {
			fail("Benutzer ist gueltig, existiert aber bereits in der Datenhaltung."); 
		} catch(BenutzerExistsException e) {
			
		}
	}
	
	@Test
	public void benok() {
		assertTrue(admin.benutzerOK(ben1)); 
		try {
			admin.benutzerEintragen(ben1);
		} catch(BenutzerExistsException e) {
			fail("Benutzer existiert noch nicht.");
		} catch(BenutzerInvalidException e) {
			fail("Benutzer ist gueltig.");
		}
		assertFalse(admin.benutzerOK(ben1)); 
	}
	
	@Test
	public void benloeschen() {
		try {
			admin.benutzerLoeschen(ben1);
			fail("Benutzer darf nicht geloescht werden, da er nicht in Datenhaltung existiert."); 
		} catch(BenutzerNotExistsException e) {
			
		}
		try {
			admin.benutzerEintragen(ben1);
		} catch(BenutzerExistsException e) {
			fail("Benutzer existiert noch nicht.");
		} catch(BenutzerInvalidException e) {
			fail("Benutzer ist gueltig.");
		}
		
		try {
			admin.benutzerLoeschen(ben1);
		} catch(BenutzerNotExistsException e) {
			fail("Benutzer ist in Datenhaltung erhalten und muss geloescht werden."); 
		}
		
		assertTrue(admin.benutzerOK(ben1)); 
	}

}
