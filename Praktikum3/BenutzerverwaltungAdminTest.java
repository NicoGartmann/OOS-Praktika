import junit.framework.TestCase;
import java.util.ArrayList;

import org.junit.Assert; 
public class BenutzerverwaltungAdminTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}; 

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(BenutzerTest.class);
	}
	
	public void testBenutzerverwaltungAdminDefault() {
		
	}
	
	public void testBenutzerEintragen() {
		char[] pw1 = {'p','w','d'};
		Benutzer ben1 = new Benutzer("uid",pw1);
		BenutzerverwaltungAdmin admin = new BenutzerverwaltungAdmin(); 
		try {
			admin.benutzerEintragen(ben1);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(admin);
	}
	
	public void testBenuterLoeschen() {
		char[] pw1 = {'p','w','d'};
		Benutzer ben1 = new Benutzer("uid",pw1);
		BenutzerverwaltungAdmin admin = new BenutzerverwaltungAdmin(); 
		try {
			admin.benutzerEintragen(ben1);
		} catch (BenutzerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			admin.benutzerLoeschen(ben1);
		} catch (BenutzerExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertNull(admin);
	}

}
