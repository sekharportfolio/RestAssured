package Clients;

import Models.Posts;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class PostsClient {
    private BaseClient client;
    private List<Posts> posts;

    public PostsClient(BaseClient client){
        this.client=client;
    }

    public Response getPostClientResponse(int userId){
        return  given()
                .spec(client.getUri())
                .param("userId", userId)
                .get("/posts");
    }

    public int getPostCount(int userId) {
        posts=  Arrays.asList(getPostClientResponse(userId).getBody().as(Posts[].class));
        return posts.stream().map(Posts::getId).collect(Collectors.toList()).size();
    }

    public int getPostId(int userId) {
        posts=  Arrays.asList(getPostClientResponse(userId).getBody().as(Posts[].class));
        return posts.stream().filter(post -> post.getUserId().equals(userId)).
                findFirst().map(Posts::getId).get();
    }


    public int getPostClientStatusCode(int userId) {

        return getPostClientResponse(userId).getStatusCode();
    }
}
