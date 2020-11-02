import org.openqa.selenium.By;

public class PostHelper extends HelperBase {

    private ApplicatonManager applicatonManager;

    public PostHelper(ApplicatonManager applicatonManager) {
        super(applicatonManager);
        this.applicatonManager = applicatonManager;
    }

    public void publishPost(PostData postData) {
        driver.findElement(By.cssSelector(".b-publisher__text")).click();
        driver.findElement(By.cssSelector(".b-publisher__text")).sendKeys(postData.getBody());
        driver.findElement(By.cssSelector(".b-publisher__controls__submit")).click();
    }

}
