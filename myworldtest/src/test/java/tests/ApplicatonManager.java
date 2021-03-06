package tests;

import data.AccountData;
import helpers.GroupHelper;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import helpers.PostHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicatonManager implements AutoCloseable {

    private WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;
    private String baseUrl;

    private GroupHelper groupHelper;
    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private PostHelper postHelper;

    private static ThreadLocal<ApplicatonManager> applicatonManagerThreadLocal;

    private ApplicatonManager() {

        System.setProperty("webdriver.chrome.driver", "/home/yuliya/Desktop/driver/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        baseUrl = "https://my.mail.ru/";

        groupHelper = new GroupHelper(this);
        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
        postHelper = new PostHelper(this);

    }

    public static ApplicatonManager getInstance() {
        if (applicatonManagerThreadLocal == null || applicatonManagerThreadLocal.get() == null) {
            ApplicatonManager newInstance = new ApplicatonManager();
            newInstance.getNavigationHelper().openHomePage();
            applicatonManagerThreadLocal = new ThreadLocal<>();
            applicatonManagerThreadLocal.set(newInstance);
        }
        return applicatonManagerThreadLocal.get();
    }

    public boolean userLogined(AccountData user) {
        String id = driver.findElement(By.id("PH_user-email")).getText();
        return id.equals(user.getLogin().toLowerCase() + "@mail.ru");
    }

    public void stop() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Map<String, Object> getVars() {
        return vars;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public PostHelper getPostHelper() {
        return postHelper;
    }

    @Override
    public void close() {
        try {
            applicatonManagerThreadLocal.get().stop();
        }
        catch (Exception e) {

        }
    }
}
