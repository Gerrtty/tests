package helpers;

import data.PostData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.ApplicatonManager;

import java.util.concurrent.TimeUnit;

public class GroupHelper extends HelperBase {

    private ApplicatonManager applicatonManager;

    public GroupHelper(ApplicatonManager applicatonManager) {
        super(applicatonManager);
        this.applicatonManager = applicatonManager;
    }

    public void testPostInGroup(PostData postData) {
        driver.findElement(By.cssSelector(".b-publisher__text")).click();
        driver.findElement(By.cssSelector(".b-publisher__text")).sendKeys(postData.getBody());
        driver.findElement(By.cssSelector(".b-publisher__controls__submit")).click();
    }

    public PostData getNewPostData() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement webElement = driver.findElement(By.cssSelector("#history_container > .b-history-event:nth-child(1) .b-history-event__event-textbox_status"));
        return new PostData(webElement.getText());
    }
}
