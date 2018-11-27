import junit.framework.TestCase;

public class BenutzerTest extends TestCase {
	private Benutzer ben1; 
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(BenutzerTest.class);
	}
	
	public void testBenutzerStringString() {
		char[] pw1 = {'p','w','d'};
		Benutzer ben1 = new Benutzer("uid",pw1); 
		assertEquals("uid",ben1.userID);
		assertEquals("pwd",String.valueOf(ben1.passWort));
	}
	
	public void testEqualsBenutzer() {
		char [] pw1 = {'p','w','d'}; 
		char [] pw2 = {'p','w'}; 
		ben1 = new Benutzer("uid",pw1); 
		Benutzer ben2= new Benutzer("uid",pw1);
		assertEquals(ben1,ben2); 
		assertNotSame(ben1,ben2); 
		ben1 = ben2; 
		assertSame(ben1,ben2); 
		Benutzer ben3 = new Benutzer("ui",pw2); 
		assertFalse(ben1.equals(ben3)); 
	}
	
	public void testToStringBenutzer() {
		char[] pw1 = {'p','w','d'}; 
		Benutzer ben1 = new Benutzer("uid",pw1);
		String out = "Benutzer: " + ben1.userID + ", Passwort: " + String.copyValueOf(pw1);
		assertEquals(ben1.toString(),out); 
	}
}
