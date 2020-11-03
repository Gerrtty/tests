package tests;

import data.AccountData;
import data.PostData;
import helpers.GroupHelper;
import helpers.PostHelper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MyTest extends TestBase {

    @Test
    public void publishPostTest() {
        login();
        PostData post = new PostData("Hi!");
        PostHelper postHelper = applicatonManager.getPostHelper();

        postHelper.publishPost(post);

        applicatonManager.getNavigationHelper().openProfilePage();
        PostData newPost = postHelper.getNewPostData();

        // assert
        Assert.assertEquals(post, newPost);
    }

    @Test
    public void postInGroupTest() {
        PostData postDataInGroup = new PostData("New post in group");
        GroupHelper groupHelper = applicatonManager.getGroupHelper();
        applicatonManager.getNavigationHelper().openGroupPage();
        groupHelper.testPostInGroup(postDataInGroup);
        PostData newPostData = groupHelper.getNewPostData();

        // assert
        Assert.assertEquals(postDataInGroup, newPostData);
    }

    @Test
    public void deletePost() {
        PostHelper postHelper = applicatonManager.getPostHelper();
        applicatonManager.getNavigationHelper().openProfilePage();
        int countOfPostsBefore = postHelper.getPostsCount();
        postHelper.deletePost();
        int countOfPostsAfter = postHelper.getPostsCount();

        // assert
        Assert.assertEquals(countOfPostsBefore - 1, countOfPostsAfter);
    }

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

}