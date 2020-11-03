package tests;

import org.junit.Before;

public class TestBase {

    protected ApplicatonManager applicatonManager;

//    @After
//    public void tearDown() {
//        applicatonManager.stop();
//    }

    @Before
    public void setUp() {
        applicatonManager = ApplicatonManager.getInstance();
    }
}
