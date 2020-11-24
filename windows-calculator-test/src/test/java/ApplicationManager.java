import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ApplicationManager {
    private static ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<ApplicationManager>();
    private Properties properties;
    private DesktopOptions options;
    private WiniumDriver driver;
    private Process shell;

    public ApplicationManager() throws IOException {
        properties = new Properties();
        File settings = new File("C:\\Users\\79870\\Desktop\\settings.properties");
        properties.load(new FileReader(settings));
        ProcessBuilder pro = new ProcessBuilder(properties.getProperty("exeURL"));
        shell = pro.start();
        options = new DesktopOptions();
        options.setApplicationPath(properties.getProperty("appPath"));
        driver = new WiniumDriver(new URL(properties.getProperty("driverURL")), options);
    }

    public static ApplicationManager getInstance() throws IOException {
        if (applicationManagerThreadLocal.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            applicationManagerThreadLocal.set(newInstance);
        }
        return applicationManagerThreadLocal.get();
    }

    public void end() {
        shell.destroy();
    }

    public WiniumDriver getDriver() {
        return driver;
    }

}
