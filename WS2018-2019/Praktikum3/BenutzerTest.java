import junit.framework.TestCase;

public class BenutzerTest extends TestCase {
	
	
	private Benutzer ben1; 
	private Benutzer ben2; 
	private String userID1 = "uid"; 
	private char[] pw1 = {'p','w','d'};
	private String userID2 = "id"; 
	private char[] pw2 = {'p','w'}; 
	
	private String out = "Benutzer: " + ben1.userID + ", Passwort: " + String.copyValueOf(pw1);
	
	protected void setUp() throws Exception {
		ben1 = new Benutzer(userID1,pw1); 
		ben2 = new Benutzer(userID2,pw2); 
	}
	
	public void testBenutzerStringChar() {
		assertEquals(userID1,ben1.userID);
		assertEquals(pw1,String.valueOf(ben1.passWort));
	}
	
	public void testEqualsBenutzer() {
		assertEquals(ben1,ben2); 
		assertNotSame(ben1,ben2); 
		ben1 = ben2; 
		assertSame(ben1,ben2); 
	}
	
	public void testToStringBenutzer() {
		assertEquals(ben1.toString(),out); 
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(BenutzerTest.class);
	}
	
	
}
