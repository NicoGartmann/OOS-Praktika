import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BenVerwaltungAdminText {

	public BenVerwaltungAdminText(){
		
	}
	
	static Benutzer ben1;
	static Benutzer ben2;
	static Benutzer ben3;
	static Benutzer ben4;
	static Benutzer ben5;
	static Benutzer ben6;
	static Benutzer ben7;
	static BenutzerVerwaltungAdmin admin;
	static BenutzerVerwaltungAdmin tmp;
	
	@BeforeClass 
	public static void setUp() throws Exception{
        admin = new BenutzerVerwaltungAdmin(); 
        admin.dbInitialisieren();
        char[] p1 = {'q','w','e','r'}; 
		char[] p2 = {'a','s','d','f'}; 
		char[] p3 = {'v','x','c','n'}; 
		char[] p4 = {'x','v','w','y'}; 
		char[] p5 = {'s','a','v','e'}; 
		
		ben1 = new Benutzer("Georgios",p1); 
		ben2 = new Benutzer("Nico",p2);
		ben3 = new Benutzer("Nico",p2);
		ben4 = new Benutzer("Ralf",p3);
		ben5 = new Benutzer("Olaf", p4); 
		ben6 = new Benutzer("Kevin",p5); 
		ben7 = new Benutzer("", p5);
    }

    @AfterClass
    public static void tearDown() throws Exception{
    }

    @Test
    public void benEintragen(){
        try {
			admin.benutzerEintragen(ben1);
		} catch (BenutzerExistsException | BenutzerInvalidException e) {
			// TODO Auto-generated catch block
			fail("Keine Exception erwartet");
		} 
        
        try {
        	admin.benutzerEintragen(ben7);
        	fail("BenutzerInvalidException erwartet"); 
        }catch (BenutzerInvalidException e) {
        	
        } catch(BenutzerExistsException e) {
        	fail("BenutzerInvalidException erwartet");
        }
        
        try {
        	admin.benutzerEintragen(ben1);
        	fail("BenutzerExistsException erwartet"); 
        } catch(BenutzerExistsException e) {
        	
        } catch(BenutzerInvalidException e) {
        	fail("BenutzerExistsException erwartet");
        }
        assertEquals(ben1,admin.data.get(0)); 
    }

    @Test
    public void benOK() { 
        assertFalse(admin.benutzerOK(ben1)); 
        try {
			admin.benutzerLoeschen(ben1);	
		} catch (BenutzerNotExistsException e) {
			fail("Keine Exception erwartet"); 
		} 
        assertTrue(admin.benutzerOK(ben1)); 
    } 
    
    @Test
    public void benLoeschen() {
        try {
			admin.benutzerEintragen(ben1);
		} catch (BenutzerExistsException | BenutzerInvalidException e) {
			fail("Keine Exception erwartet"); 
		} 
        try {
			admin.benutzerLoeschen(ben1);
		} catch (BenutzerNotExistsException e) {
			fail("BenutzerNotExistsException erwartet");
		} 
        assertTrue(admin.data.isEmpty());
        
        try {
        	admin.benutzerLoeschen(ben1);
        	fail("BenutzerNotExitsException erwartet"); 
        } catch(BenutzerNotExistsException e) {
      
        }
    }
    
    @Test
    public void benutzerEintragenNotInitialised() {
    	try {
    		admin.benutzerEintragen(ben1);
    		admin.benutzerEintragen(ben3);
    		admin.benutzerEintragen(ben4);
    		admin.benutzerEintragen(ben5);
    		admin.benutzerEintragen(ben6);
    	} catch(BenutzerExistsException | BenutzerInvalidException e) {
    		fail("Keine Exception erwartet"); 
    	}
    	
    	tmp = (BenutzerVerwaltungAdmin) admin.getData();
    	assertEquals(admin.data,tmp.data); 
    	
    	try {
    		admin.benutzerEintragen(ben1);
    		fail("BenutzerExistsException erwartet");
    	} catch(BenutzerExistsException e) {
    		
    	} catch(BenutzerInvalidException e) {
    		fail("BenutzerExistsException erwartet");
    	}
    	
    	try {
    		admin.benutzerEintragen(ben7);
    		fail("BenutzerInvalidExceptin erwartet"); 
    	} catch(BenutzerInvalidException e) {
    		
    	} catch(BenutzerExistsException e) {
    		fail("BenutzerInvalidException erwartet");
    	}
    }

}
