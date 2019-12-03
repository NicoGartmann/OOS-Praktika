import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class BenTest {
	public BenTest() {
		
	}
	
	static Benutzer ben1;
	static Benutzer ben2;
	static Benutzer ben3;
	static Benutzer ben4;
	static Benutzer ben5;
	static Benutzer ben6;
	@BeforeClass
	public static void setUp() throws Exception {
        char[] p1 = {'q','w','e','r'}; 
		char[] p2 = {'a','s','d','f'}; 
		char[] p3 = {'v','x','c','n'}; 
		char[] p4 = {' '}; 
		
		ben1 = new Benutzer("Georgios",p1); 
		ben2 = new Benutzer("Nico",p2);
		ben3 = new Benutzer("Nico",p2);
		ben4 = new Benutzer("Georgios",p3); 
        ben5 = null; 
        ben6 = new Benutzer("",p4); 
    }

    @AfterClass
    public static void tearDown() throws Exception { 
    }

    
    @Test 
    public void benutzerStringString() {
        assertEquals("Georgios",ben1.userID); 
        assertEquals("qwer",String.valueOf(ben1.passWort)); 
    }

    
    @Test 
    public void equalsBenutzer() {
        assertEquals(ben2,ben3);  
        assertNotSame(ben2,ben3); 
        ben2 = ben3; 
        assertSame(ben2,ben3); 
        assertFalse(ben1.equals(ben2)); 
    }

  
    @Test 
    public void toStringBenutzer() {
        String str = "Georgios/qwer"; 
        assertEquals(str,ben1.toString());
        str = "/ "; 
        assertEquals(str,ben6.toString());
    }

  
    /*public static void main(String[] args) {
        junit.textui.TestRunner.run(BenTest.class); 
    	//JUnitCore.runClasses(BenTest.class);
    }*/
}
