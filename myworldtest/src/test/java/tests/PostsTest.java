package tests;

import data.PostData;
import helpers.GroupHelper;
import helpers.PostHelper;
import org.junit.Assert;
import org.junit.Test;

public class PostsTest extends AuthBase {

    @Test
    public void postInGroupTest() {
        PostData postDataInGroup = new PostData("New post in group");
        GroupHelper groupHelper = applicatonManager.getGroupHelper();
        groupHelper.testPostInGroup(postDataInGroup);
        PostData newPostData = groupHelper.getNewPostData();

        // assert
        Assert.assertEquals(postDataInGroup, newPostData);
    }

    @Test
    public void publishPostTest() {
        PostHelper postHelper = applicatonManager.getPostHelper();

        PostData post = new PostData("New post");
        postHelper.publishPost(post);

        applicatonManager.getNavigationHelper().openProfilePage();
        PostData newPost = postHelper.getNewPostData();

        // assert
        Assert.assertEquals(post, newPost);
    }

}