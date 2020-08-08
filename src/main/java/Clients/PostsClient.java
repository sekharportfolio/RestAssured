package Clients;

import Models.Posts;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class PostsClient {
    private BaseClient client;
    private List<Posts> posts;

    public PostsClient(BaseClient client){
        this.client=client;
    }

    public int getPostCount() {
        posts= client.getResponseBody().as((Type) Posts.class);
        return posts.stream().map(Posts::getId).collect(Collectors.toList()).size();
    }
}
