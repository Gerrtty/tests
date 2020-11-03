package helpers;

import data.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.ApplicatonManager;

public class LoginHelper extends HelperBase {

    private ApplicatonManager applicatonManager;

    public LoginHelper(ApplicatonManager applicatonManager) {
        super(applicatonManager);
        this.applicatonManager = applicatonManager;
    }

    public void login(AccountData user) {

        applicatonManager.getNavigationHelper().openHomePage();

        driver.findElement(By.cssSelector(".l-loginform_row:nth-child(2) .l-loginform_row_label_input")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".l-loginform_row:nth-child(2) .l-loginform_row_label_input"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.cssSelector(".l-loginform_row_label")).click();
        driver.findElement(By.cssSelector(".l-loginform_row_label")).sendKeys(user.getLogin());
        driver.findElement(By.cssSelector(".l-loginform_row_label__100 > .l-loginform_row_label_input")).click();
        driver.findElement(By.cssSelector(".l-loginform_row_label__100 > .l-loginform_row_label_input")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".l-loginform_footer > .ui-button-main")).click();
    }

}
