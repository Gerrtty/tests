import org.junit.After;
import org.junit.Before;

import java.io.IOException;

public abstract class TestBase {

    protected ApplicationManager applicationManager;

    @Before
    public void before() {
        try {
            applicationManager = ApplicationManager.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        applicationManager.end();
    }

}
