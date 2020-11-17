package settings;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static String login;
    private static String password;
    private static String baseUrl;

    private static Properties document;

    public Settings() {
        set();
    }

    public static void set() {
        document = new Properties();
        File settings = new File("/home/yuliya/IdeaProjects/myworldtest/src/test/main/resources/properties.properties");
        try {
            document.load(new FileReader(settings));
        } catch (IOException e) {
            e.printStackTrace();
        }

        login = document.getProperty("login");
        password = document.getProperty("pass");
        baseUrl = document.getProperty("baseUrl");
    }

    public static String getLogin() {

        if (login == null) {
            set();
        }

        return login;
    }

    public static String getPassword() {

        if (password == null) {
            set();
        }

        return password;
    }

    public static String getBaseUrl() {

        if (baseUrl == null) {
            set();
        }

        return baseUrl;
    }

}
