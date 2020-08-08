package Clients;

public class CommonClient {

    public   UserClient userClient;
    public CommentClient commentClient;
    public PostsClient postsClient;


    public CommonClient(){
        userClient = new UserClient(new BaseClient());
        commentClient = new CommentClient(new BaseClient());
        postsClient = new PostsClient(new BaseClient());
    }
}
