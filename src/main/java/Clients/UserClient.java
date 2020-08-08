package Clients;

import Models.Users;
import Utilities.TestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserClient  {
    private List<Users> users;
    private BaseClient client;

    public UserClient(BaseClient client){
        this.client=client;
    }

    public  boolean isUserExists(String userName){

        Response response = given()
                .spec(client.getUri())
                .param("username", userName)
                .get("/users");
        users=  Arrays.asList(response.getBody().as(Users[].class));
        return users.stream().anyMatch( user-> userName.equalsIgnoreCase(user.getUsername()));
    }

    public int getUserId(String userName) {
        Response response = given()
                .spec(client.getUri())
                .param("username", userName)
                .get("/users");
        users=  Arrays.asList(response.getBody().as(Users[].class));
       return users.stream().filter(user -> user.getUsername().equalsIgnoreCase(userName)).
                findFirst().map(Users::getId).get();
    }
}
