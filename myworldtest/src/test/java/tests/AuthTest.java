package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.AccountData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AuthTest extends TestBase {

    // принимает параметры из метода dataFromJsonFile()
    @ParameterizedTest
    @MethodSource("dataFromJsonFile")
    public void publishPostTest(AccountData user) {
        applicatonManager.getNavigationHelper().openHomePage();
        applicatonManager.getLoginHelper().login(user);
    }

    // считывет дынные из файла authdata.json
    // Тут у меня в файле authdata.json лежат 2 невалидных и 1 валидные данные
    private static AccountData[] dataFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("/home/yuliya/Desktop/testdata/authdata.json");
        try {
            Scanner scanner = new Scanner(file);
            String s = scanner.nextLine();
            return objectMapper.readValue(s, AccountData[].class);
        } catch (FileNotFoundException | JsonProcessingException e) {
            e.printStackTrace();
        }

        return new AccountData[0];
    }

}