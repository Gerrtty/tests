import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/yuliya/IdeaProjects/myworldtest/src/main/resources/properties.properties");
        Properties p = new Properties();
        p.load(new FileReader(file));
        String pass = p.getProperty("pass");
        System.out.println(pass);
        p.getProperty("login");
    }
}
