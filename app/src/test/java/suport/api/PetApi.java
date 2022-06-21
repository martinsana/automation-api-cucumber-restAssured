package suport.api;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import support.domain.Pet;

import java.util.List;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={status}";

    public List<Pet> getPetsByStatus(String status) {
        return given().
                pathParam("status", status).
        when().
                get(FIND_PETS_BY_STATUS_ENDPOINT).
        then().
                statusCode(HttpStatus.SC_OK).
                extract().body().jsonPath().getList("", Pet.class);
    }

    public Response getPetsResponseByStatus(String status) {
        return given().
                pathParam("status", status).
        when().
                get(FIND_PETS_BY_STATUS_ENDPOINT);


    }
}
