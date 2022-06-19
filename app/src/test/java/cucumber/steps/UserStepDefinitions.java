package cucumber.steps;

import io.cucumber.docstring.DocString;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import suport.api.UserApi;
import support.domain.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserStepDefinitions {

    private final String USER_ENDPOINT = "/v3/user/{name}";
    private User expectedUser;
    UserApi userApi;

    public UserStepDefinitions(){
        userApi = new UserApi();
    }

    @Given("I create a user")
    public void iCreateAUser() {
        expectedUser = User.builder().build();
        userApi.createUser(expectedUser);

    }

    @Then("User is saved")
    public void userIsSaved() {
        String actualUsername = userApi.getUsername(expectedUser);
        assertThat(actualUsername, is(expectedUser.getUsername()));
    }


}
