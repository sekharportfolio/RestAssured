package Clients;

import Models.Users;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserClient  {
    private List<Users> users;
    private BaseClient client;

    public UserClient(BaseClient client){
        this.client=client;
    }

    public Response getUserClientResponse(String userName){
        return  given()
                .spec(client.getUri())
                .param("username", userName)
                .get("/users");
    }


    public  boolean isUserExists(String userName){
        users=  Arrays.asList(getUserClientResponse(userName).getBody().as(Users[].class));
        return users.stream().anyMatch( user-> userName.equalsIgnoreCase(user.getUsername()));
    }

    public int getStatusCode(String userName) {

        return getUserClientResponse(userName).getStatusCode();
    }



    public int getUserId(String userName) {
        users=  Arrays.asList(getUserClientResponse(userName).getBody().as(Users[].class));
       return users.stream().filter(user -> user.getUsername().equalsIgnoreCase(userName)).
                findFirst().map(Users::getId).get();
    }
}
