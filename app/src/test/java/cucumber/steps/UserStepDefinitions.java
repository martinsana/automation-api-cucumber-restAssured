package cucumber.steps;

import io.cucumber.docstring.DocString;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import support.domain.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class UserStepDefinitions {

    private final String CREATE_USER_ENDPOINT = "/v3/user";
    private final String USER_ENDPOINT = "/v3/user/{name}";
    private Map<String, String> expectedUser = new HashMap<>();
    private User user;

    @When("I do a post to {word} with:")
    public void iDoAPostToVUserWith(String endpoint, Map<String, String> user) {

        expectedUser = user;

        given().
                body(user).
        when().
                post(endpoint).
        then().
                statusCode(HttpStatus.SC_OK);
    }

    @Then("I do get {word}, the user created is returned")
    public void iDoGetVUserTheUserTheUserCreatedIsReturned(String endpoint) {
        expectedUser.put("username", "theUser");
        when().
                get(endpoint).
        then().
                statusCode(HttpStatus.SC_OK).
                body("username", is(expectedUser.get("username")));
    }

    @When("I do a post to {word} with docstring:")
    public void iDoAPostToVUserWithDocstring(String endpoint, DocString docString) {
        given().
                body(docString.getContent()).
        when().
                post(endpoint).
        then().
                statusCode(HttpStatus.SC_OK);
    }

    @Given("I create a user")
    public void iCreateAUser() {
        user = User.builder().build();

        given().
                body(user).
        when().
                post(CREATE_USER_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_OK);

    }

    @Then("User is saved")
    public void userIsSaved() {
        given().
                pathParam("name", user.getUsername()).
        when().
                get(USER_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_OK).
                body("username", is(user.getUsername()));
    }
}
