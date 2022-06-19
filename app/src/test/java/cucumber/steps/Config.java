package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import suport.api.UserApi;

public class Config {

    UserApi userApi;

    public Config() {
        userApi = new UserApi();
    }

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.baseURI = "http://localhost:12345";
        RestAssured.basePath = "/api";

        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                build();


    }

    @After("@deleteAllUsers")
    public void deleteAllUsers() {
        System.out.println("Deleting all users");
        userApi.deleteAllUsers();
    }
}
