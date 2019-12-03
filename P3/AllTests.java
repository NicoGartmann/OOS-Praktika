import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({BenTest.class,BenVerwaltungAdminTest.class,BenVerwaltungAdminTestInitialised.class})
public class AllTests {
}
