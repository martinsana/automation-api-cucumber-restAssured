package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    public PetsStepDefinitions(){
        petApi = new PetApi();
    }

    @Given("I have available pets")
    public void iHaveAvailablePets() throws JsonProcessingException {

    }

    @When("I search for {word} pets")
    public void iSearchForAvailablePets(String status) {
       actualPets = petApi.getPetsByStatus(status);

    }

    @Then("I see the list of available pets")
    public void iSeeTheListOfAvailablePets() {
        assertThat(actualPets, is(not(empty())));
    }
}
