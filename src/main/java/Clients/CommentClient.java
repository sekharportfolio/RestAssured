package Clients;

import Models.Comments;
import Utilities.EmailValidator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentClient {

    private BaseClient client;
    private List<Comments> comments = new ArrayList<>();

    public CommentClient(BaseClient client){
        this.client=client;
    }

    public List<String> getInvalidEmailIds() {
        comments= client.getResponseBody().as((Type) Comments.class);
        return comments.stream().map(Comments::getEmail).filter(email -> !EmailValidator.checkEmailFormat(email)).
                collect(Collectors.toList());
    }

}
