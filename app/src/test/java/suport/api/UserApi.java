package suport.api;


import org.apache.http.HttpStatus;
import support.domain.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class UserApi {
    private final String CREATE_USER_ENDPOINT = "/v3/user";
    private final String USER_ENDPOINT = "/v3/user/{name}";

    public void createUser(User user) {
        given().
                body(user).
                when().
                post(CREATE_USER_ENDPOINT).
                then().
                statusCode(HttpStatus.SC_OK);
    }

    public String getUsername(User user) {
        return given().
                pathParam("name", user.getUsername()).
        when().
                get(USER_ENDPOINT).
        thenReturn().
                path("username");

    }
}
