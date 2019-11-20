import junit.framework.TestCase;

public class BenutzerVerwaltungAdminTest extends TestCase {
    @Before
    protected void setUp() throws Exception{
        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin(); 
        char[] p1 = {'q','w','e','r'}; 
		char[] p2 = {'a','s','d','f'}; 
		char[] p3 = {'v','x','c','n'}; 
		char[] p4 = {'x','v','w','y'}; 
		char[] p5 = {'s','a','v','e'}; 
		
		Benutzer ben1 = new Benutzer("Georgios",p1); 
		Benutzer ben2 = new Benutzer("Nico",p2);
		Benutzer ben3 = new Benutzer("Nico",p2);
		Benutzer ben4 = new Benutzer("Ralf",p3);
		Benutzer ben5 = new Benutzer("Olaf", p4); 
		Benutzer ben6 = new Benutzer("Kevin",p5); 
		Benutzer ben7 = new Benutzer("", p5);
    }

    @After 
    protected void tearDown() throws Exception{
        super.tearDown();
    }

    @Test
    public void testBenutzerEintragen(){
        admin.benutzerEintragen(ben1); 
        assertEquals(ben1,admin.data.get(0)); 
    }

    @Test
    public void testBenutzerOK() { 
        assertTrue(admin.benutzerOK(ben1)); 
        admin.benutzerEintragen(ben1); 
        assertFalse(admin.benutzerOK(ben1)); 
    } 
    
    @Test
    public void testBenuzerLoeschen() {
        admin.benutzerEintragen(ben1); 
        admin.benutzerLoeschen(ben1); 
        assertTrue(admin.data.isEmpty()); 
    }

    @Test 
    public void testBenutzerExistsException() {
        try {
            admin.benutzerEintragen(ben1); 
            admin.benutzerEintragen(ben1); 
            fail("Zwei gleiche Benutzer duerfen nicht in Datenhaltung vorhanden sein."); 
        } catch(BenutzerExistsException e) {
            e.printStackTrace();
        }
    }

    @Test 
    public void testBenutzerNotExistsException() {
        try {
            admin.benutzerLoeschen(ben1); 
            fail("Nicht eingetragener Benutzer darf nicht geloescht werden.");
        } catch(BenutzerNotExistsException e) {
            e.printStackTrace();
        }
    }

    @Test 
    public void testBenutzerInvalidException() {
        try {
            admin.benutzerEintragen(ben1); 
            fail("Invalide Benutzer duerfen nicht eingetragen werden"); 
        } catch(BenutzerInvalidException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(BenutzerTest.class); 
    }
}