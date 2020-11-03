package data;

public class PostData {

    private String body;

    public PostData(String body) {
        this.body = body;
    }

    public PostData() {

    }

    public String getBody() {
        return body;
    }

    public PostData getCreatedPostData() {
        PostData postData = new PostData();
        return postData;
    }

    public boolean equals(Object o) {

        PostData postData = (PostData) o;

        return postData.body.equals(body);

    }
}
