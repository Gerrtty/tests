package tests;

import org.junit.Before;


public class TestBase {

    protected static ApplicatonManager applicatonManager = ApplicatonManager.getInstance();

//    @After
//    public void tearDown() {
//        applicatonManager.stop();
//    }

    @Before
    public void setUp() {
        applicatonManager = ApplicatonManager.getInstance();
    }

}
