package Clients;

import Models.Comments;
import Utilities.EmailValidator;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class CommentClient {

    private BaseClient client;
    private List<Comments> comments = new ArrayList<>();

    public CommentClient(BaseClient client){
        this.client=client;
    }

    /**
     * this method will help to call the comments service
     * @param postId
     * @return response
     */
    public Response getCommentsClientResponse(int postId){
        return  given()
                .spec(client.getUri())
                .param("postId", postId)
                .get("/comments");
    }

    /**
     * this method helps you to get invalid emails count
     * @param postId
     * @return count
     */
    public int getInvalidEmailCount(int postId) {
        comments=  Arrays.asList(getCommentsClientResponse(postId).getBody().as(Comments[].class));
        return comments.stream().map(Comments::getEmail).filter(email -> !EmailValidator.checkEmailFormat(email)).
                collect(Collectors.toList()).size();
    }

    /**
     * this method helps you to get valid emails count
     * @param postId
     * @return count
     */
    public int getValidEmailCount(int postId) {
        comments=  Arrays.asList(getCommentsClientResponse(postId).getBody().as(Comments[].class));
        return comments.stream().map(Comments::getEmail).filter(email -> EmailValidator.checkEmailFormat(email)).
                collect(Collectors.toList()).size();
    }

}
