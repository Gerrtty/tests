import org.junit.Before;
import org.junit.After;

public class TestBase {
    protected ApplicatonManager applicatonManager;

    @After
    public void tearDown() {
        applicatonManager.stop();
    }

    @Before
    public void setUp() {
        applicatonManager = new ApplicatonManager();
    }
}
