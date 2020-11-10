package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.AccountData;
import data.PostData;
import helpers.PostHelper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class MyTest extends TestBase {

    @Test
    public void login() {

        Properties properties = new Properties();

        try {
            File account = new File("/home/yuliya/IdeaProjects/myworldtest/src/test/main/resources/properties.properties");
            properties.load(new FileReader(account));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        AccountData user = new AccountData(properties.getProperty("login"), properties.getProperty("pass"));
        applicatonManager.getNavigationHelper().openHomePage();
        applicatonManager.getLoginHelper().login(user);

    }

    // принимает параметры из метода dataFromJsonFile()
    @ParameterizedTest
    @MethodSource("dataFromJsonFile")
    public void publishPostTest(PostData post) {
        PostHelper postHelper = applicatonManager.getPostHelper();

        postHelper.publishPost(post);

        applicatonManager.getNavigationHelper().openProfilePage();
        PostData newPost = postHelper.getNewPostData();

        // assert
        Assert.assertEquals(post, newPost);
    }

    // считывет дынные из файла testdata.json
    private static PostData[] dataFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("/home/yuliya/Desktop/testdata/testdata.json");
        try {
            Scanner scanner = new Scanner(file);
            String s = scanner.nextLine();
            System.out.println(s.length());
            return objectMapper.readValue(s, PostData[].class);
        } catch (FileNotFoundException | JsonProcessingException e) {
            e.printStackTrace();
        }

        return new PostData[0];
    }

//    @Test
//    public void postInGroupTest() {
//        PostData postDataInGroup = new PostData("New post in group");
//        GroupHelper groupHelper = applicatonManager.getGroupHelper();
//        applicatonManager.getNavigationHelper().openGroupPage();
//        groupHelper.testPostInGroup(postDataInGroup);
//        PostData newPostData = groupHelper.getNewPostData();
//
//        // assert
//        Assert.assertEquals(postDataInGroup, newPostData);
//    }
//
//    @Test
//    public void deletePost() {
//        PostHelper postHelper = applicatonManager.getPostHelper();
//        applicatonManager.getNavigationHelper().openProfilePage();
//        int countOfPostsBefore = postHelper.getPostsCount();
//        postHelper.deletePost();
//        int countOfPostsAfter = postHelper.getPostsCount();
//
//        // assert
//        Assert.assertEquals(countOfPostsBefore - 1, countOfPostsAfter);
//    }

}