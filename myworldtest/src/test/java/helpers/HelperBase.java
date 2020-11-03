package helpers;

import org.openqa.selenium.WebDriver;
import tests.ApplicatonManager;

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
