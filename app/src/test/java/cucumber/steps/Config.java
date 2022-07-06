package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import suport.api.PetApi;
import suport.api.UserApi;
import suport.config.ConfigManager;
import suport.config.ServerConfig;

public class Config {

    private UserApi userApi;
    private PetApi petApi;

    public Config() {
        userApi = new UserApi();
        petApi = new PetApi();
    }

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        ServerConfig properties = ConfigManager.getConfiguration();

        RestAssured.baseURI = String.format("%s:%d",properties.baseUri(), properties.port());
        RestAssured.basePath = properties.basePath();

        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                build();


    }

    @After("@deleteAllUsers")
    public void deleteAllUsers() {
        System.out.println("Deleting all users");
        userApi.deleteAllUsers();
    }

    @After("@deleteExtraPets")
    public void deleteExtraPets() {
        System.out.println("Deleting extra pets");
        petApi.deleteExtraPets("available");
    }

}
