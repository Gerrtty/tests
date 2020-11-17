package tests;

import helpers.PostHelper;
import org.junit.Test;

public class MyTest extends AuthBase {

    @Test
    public void deletePost() {
        PostHelper postHelper = applicatonManager.getPostHelper();
        applicatonManager.getNavigationHelper().openProfilePage();
        int countOfPostsBefore = postHelper.getPostsCount();
        postHelper.deletePost();
        int countOfPostsAfter = postHelper.getPostsCount();

        // assert
        //Assert.assertEquals(countOfPostsBefore - 1, countOfPostsAfter);
    }

//        // принимает параметры из метода dataFromJsonFile()
//    @ParameterizedTest
//    @MethodSource("dataFromJsonFile")
//    public void publishPostTest(PostData post) {
//        PostHelper postHelper = applicatonManager.getPostHelper();
//
//        postHelper.publishPost(post);
//
//        applicatonManager.getNavigationHelper().openProfilePage();
//        PostData newPost = postHelper.getNewPostData();
//
//        // assert
//        Assert.assertEquals(post, newPost);
//    }
//
//    // считывет дынные из файла testdata.json
//    private static PostData[] dataFromJsonFile() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = new File("/home/yuliya/Desktop/testdata/testdata.json");
//        try {
//            Scanner scanner = new Scanner(file);
//            String s = scanner.nextLine();
//            System.out.println(s.length());
//            return objectMapper.readValue(s, PostData[].class);
//        } catch (FileNotFoundException | JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        return new PostData[0];
//    }

//    @Test
//    public void postInGroupTest() {
//        PostData postDataInGroup = new PostData("New post in group");
//        GroupHelper groupHelper = applicatonManager.getGroupHelper();
//        groupHelper.testPostInGroup(postDataInGroup);
//        PostData newPostData = groupHelper.getNewPostData();
//
//        // assert
//        Assert.assertEquals(postDataInGroup, newPostData);
//    }

}
