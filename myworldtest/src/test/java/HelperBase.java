import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class HelperBase {
    protected WebDriver driver;

    protected ApplicatonManager applicatonManager;

    public HelperBase(ApplicatonManager applicatonManager) {
        this.applicatonManager = applicatonManager;
        this.driver = applicatonManager.getDriver();
    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
