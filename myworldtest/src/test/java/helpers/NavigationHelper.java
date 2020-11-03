package helpers;

import org.openqa.selenium.Dimension;
import tests.ApplicatonManager;

public class NavigationHelper extends HelperBase {

    private String baseUrl;
    private ApplicatonManager applicatonManager;

    public NavigationHelper(ApplicatonManager applicatonManager, String baseUrl) {
        super(applicatonManager);
        this.applicatonManager = applicatonManager;
        this.baseUrl = baseUrl;
    }

    public void openUrl(String url) {
        driver.get(baseUrl + url);
        driver.manage().window().setSize(new Dimension(945, 1033));
    }

    public void openHomePage() {
        openUrl("");
    }

    public void openGroupPage() {
        openUrl("/community/testgroup123/");
    }

    public void openProfilePage() {
        openUrl("/mail/gerrtty/");
    }

}
