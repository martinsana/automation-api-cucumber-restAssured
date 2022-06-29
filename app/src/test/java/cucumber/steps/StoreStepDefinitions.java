package cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import suport.api.PetApi;
import suport.api.StoreApi;
import support.domain.Order;
import support.domain.Pet;

import static org.hamcrest.CoreMatchers.is;

public class StoreStepDefinitions {

    PetApi petApi;
    Pet expectedPet;
    StoreApi storeApi;
    Order expectedOrder;
    private Response actualOrderResponse;

    public StoreStepDefinitions() {
        petApi = new PetApi();
        storeApi = new StoreApi();
    }

    @Given("I want have an {word} pet")
    public void iWantHaveAnAvailablePet(String status) {
        Pet pet = Pet.builder()
                .id(77)
                .status(status)
                .build();

        expectedPet = petApi.createPet(pet);
    }

    @When("I order for a pet")
    public void iOrderForAPet() {
        Order order = Order.builder()
                .id(888)
                .petId(expectedPet.getId())
                .build();

        expectedOrder = storeApi.createOrder(order);
    }

    @Then("the order is approved")
    public void theOrderIsApproved() {
        actualOrderResponse = storeApi.getOrderResponseByID(expectedOrder.getId());
        actualOrderResponse.
                then().
                body(
                        "status", is(expectedOrder.getStatus()),
                        "id", is(expectedOrder.getId()),
                        "petId", is(expectedOrder.getPetId()),
                        "quantity", is(expectedOrder.getQuantity())
                );
    }
}
