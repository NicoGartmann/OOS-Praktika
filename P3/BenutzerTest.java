import junit.framework.TestCase;

public class BenutzerTest extends TestCase {
    @Before 
    protected void setUp() throws Exception {
        char[] p1 = {'q','w','e','r'}; 
		char[] p2 = {'a','s','d','f'}; 
		char[] p3 = {'v','x','c','n'}; 
		
		Benutzer ben1 = new Benutzer("Georgios",p1); 
		Benutzer ben2 = new Benutzer("Nico",p2);
		Benutzer ben3 = new Benutzer("Nico",p2);
		Benutzer ben4 = new Benutzer("Georgios",p3); 
        Benuter ben5 = null; 
    }

    @After
    protected void tearDown() throws Exception {
        super.tearDown(); 
    }
    
    /**
     */
     @Test
    public void testBenutzerStringString() {
        assertEquals("Georgios",ben1.userID); 
        assertEquals("qwer",String.valueOf(ben1.passwort)); 
    }

    /**
     */
     @Test
    public void testEqualsBenutzer() {
        assertEquals(ben2,ben3); 
        assertNotEquals(ben1,ben4); 
        assertNotSame(ben2,ben3); 
        ben2 = ben3; 
        assertSame(ben2,ben3); 
        assertFalse(ben1.equals(ben2)); 
    }

    /**
     */
     @Test
    public void testToStringBenutzer() {
        String str = "Georgios/qwer"; 
        assertEquals(str,ben1.toString()); 

    }

    /**
     */
     @Test
     public void testNullPointerException() {
         try {
            ben5.equals(ben1); 
            fail("ben must not be null");
         } catch (NullPointerException e) {
             e.printStackTrace(); 
         }
     }
    /**
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(BenutzerTest.class); 
    }
}