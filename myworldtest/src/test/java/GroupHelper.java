import org.openqa.selenium.By;

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

}
