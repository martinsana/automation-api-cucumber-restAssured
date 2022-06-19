package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.domain.Pet;

public class PetsStepDefinitions {
    @Given("I have available pets")
    public void iHaveAvailablePets() throws JsonProcessingException {
        Pet pet = Pet.builder().build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pet);
        System.out.println(json);


    }

    @When("I search for available pets")
    public void iSearchForAvailablePets() {
        
    }

    @Then("I see the list of available pets")
    public void iSeeTheListOfAvailablePets() {
    }
}
