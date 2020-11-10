package helpers;

import data.PostData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.ApplicatonManager;

import java.util.concurrent.TimeUnit;

public class PostHelper extends HelperBase {

    private ApplicatonManager applicatonManager;

    public PostHelper(ApplicatonManager applicatonManager) {
        super(applicatonManager);
        this.applicatonManager = applicatonManager;
    }

    public void publishPost(PostData postData) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".b-publisher__text")).click();
        driver.findElement(By.cssSelector(".b-publisher__text")).sendKeys(postData.getBody());
        driver.findElement(By.cssSelector(".b-publisher__controls__submit")).click();
    }

    public void deletePost() {
        driver.findElement(By.cssSelector("#history_container > .b-history-event:nth-child(1) .history_icon-settings-ico")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Удалить запись")).click();
        driver.findElement(By.cssSelector(".js-bubble__confirm-yes")).click();
    }

    public PostData getNewPostData() {
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement webElement = driver.findElement(By.cssSelector("#history_container > .b-history-event:nth-child(1) .b-history-event__event-textbox_status"));
        return new PostData(webElement.getText());
    }

    public int getPostsCount() {
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(By.cssSelector("#history_container")).getText().split("Вы  сказали").length;
    }

}
