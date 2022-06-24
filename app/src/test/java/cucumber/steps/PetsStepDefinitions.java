package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import suport.api.PetApi;
import support.domain.Pet;
import support.domain.User;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

public class PetsStepDefinitions {

    PetApi petApi;
    private List<Pet> actualPets;
    private Response actualPetsResponse;

    public PetsStepDefinitions(){
        petApi = new PetApi();
    }

    @Given("I have {word} pets")
    public void iHaveAvailablePets(String status) throws JsonProcessingException {

    }

    @When("I search for {word} pets")
    public void iSearchForAvailablePets(String status) {
       Response actualPetsResponse = petApi.getPetsResponseByStatus(status);

       actualPets = actualPetsResponse.body().jsonPath().getList("", Pet.class);

        actualPetsResponse.
                then().
                    statusCode(HttpStatus.SC_OK).
                    body(
                        "size()", is(actualPets.size()),
                            "findAll { it.status == '" + status + "' }.size()", is(actualPets.size()));
    }

    @Then("I see the list of {word} pets")
    public void iSeeTheListOfAvailablePets(String status) {
        assertThat(actualPets, is(not(empty())));
    }

    @Then("I see the list with {} pet/pets")
    public void iSeeTheListWithPets(int petsQuantity) {
        assertThat(actualPets.size(), is(petsQuantity));
    }

    @Given("I do not have {word} pets")
    public void iDoNotHaveSoldPets(String status) {
        petApi.deletePetsByStatus(status);
    }

    @When("search for {word} pets")
    public void searchForAvailablePets(String status) {
        actualPetsResponse = petApi.getPetsResponseByStatus(status);
    }

    @Then("see the list with {int} of {word} pets")
    public void seeTheListOfAvailablePets(Integer quantity, String status) {
        actualPetsResponse.
                then().
                statusCode(HttpStatus.SC_OK).
                body(
                        "size()", is(quantity),
                        "findAll {it.status == '" + status + "' }.size()", is(quantity)
                );
    }

    @And("{int} pets are named {word}")
    public void petsAreNamedLion(Integer quantity, String name) {
        actualPetsResponse.
                then().
                body(
                      "findAll {it.name.contains('" + name + "') }.size()", is(quantity)
                );
    }
}
