import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestClass extends TestBase {

    @Test
    public void addingTest()  {

        WebElement start = applicationManager.getDriver().findElement(By.name("Display is 0"));

        // 1 + 2 = 3
        WebElement one = applicationManager.getDriver().findElement(By.name("One"));
        one.click();
        WebElement plus = applicationManager.getDriver().findElement(By.name("Plus"));
        plus.click();
        WebElement two = applicationManager.getDriver().findElement(By.name("Two"));
        two.click();
        WebElement eq = applicationManager.getDriver().findElement(By.name("Equals"));
        eq.click();

        WebElement end = applicationManager.getDriver().findElement(By.name("Display is 3"));

        Assert.assertEquals(start, end);

    }

}
